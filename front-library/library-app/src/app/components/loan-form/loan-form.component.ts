import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService, User } from '../../services/auth.service';
import { LoanService } from '../../services/loan.service';

@Component({
  selector: 'app-loan-form',
  templateUrl: './loan-form.component.html',
  styleUrls: ['./loan-form.component.css']
})
export class LoanFormComponent implements OnInit {
  loanForm: FormGroup;
  userId: number | null = null;
  message: string = '';

  constructor(
    private fb: FormBuilder,
    private auth: AuthService,
    private loanService: LoanService,
    private router: Router
  ) {
    this.loanForm = this.fb.group({
      bookId: ['', Validators.required],
      dueDate: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    // Obtener el usuario actual desde el servicio Auth
    const user: User | null = this.auth.getCurrentUser();  // El tipo ahora es `User | null`
    
    if (user) {
      this.userId = user.id;  // Ahora TypeScript sabe que `user` tiene un `id`
    } else {
      this.message = 'Usuario no autenticado';
      // Si el usuario no está autenticado, redirigir al login
      this.router.navigate(['/login']);
    }
  }

  submitLoan(): void {
    if (this.loanForm.invalid) {
      this.message = 'Por favor, complete todos los campos.';
      return;
    }

    const loanData = {
      userId: this.userId,
      bookId: this.loanForm.value.bookId,
      dueDate: this.loanForm.value.dueDate
    };

    this.loanService.createLoan(loanData).subscribe({
      next: (response) => {
        this.message = 'Préstamo realizado con éxito';
        this.router.navigate(['/libros']);
      },
      error: (error) => {
        this.message = 'Error al realizar el préstamo. Inténtalo nuevamente.';
        console.error(error);
      }
    });
  }
}
