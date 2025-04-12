import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  username: string = '';  // Para almacenar el nombre de usuario
  password: string = '';  // Para almacenar la contraseña
  errorMessage: string = '';  // Para mostrar mensajes de error en el login

  constructor(private authService: AuthService, private router: Router) {}

  // Método que se llama cuando el usuario hace clic en el botón de login
  onLogin(): void {
    // Llamamos al servicio de login para autenticar al usuario
    this.authService.login({ username: this.username, password: this.password }).subscribe({
      next: (response) => {
        // Si la respuesta es exitosa, almacenamos al usuario en localStorage
        localStorage.setItem('user', JSON.stringify(response.user)); // Guardamos al usuario
        this.router.navigate(['/libros']);  // Redirigimos al usuario a la página de libros
      },
      error: (error) => {
        // Si hay un error, mostramos un mensaje de error
        this.errorMessage = 'Login fallido, por favor verifica tus credenciales';
      },
    });
  }
}

