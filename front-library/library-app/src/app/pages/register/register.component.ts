import { AuthService } from '../../services/auth.service';
import { Component } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
})
export class RegisterComponent {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private auth: AuthService,
    private router: Router
  ) {
    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['USER'], // Rol por defecto
    });
  }

  register() {
    if (this.form.invalid) return;

    this.auth.register(this.form.value).subscribe({
      next: () => this.router.navigate(['/login']),
      error: () => alert('Registro fallido'),
    });
  }
}