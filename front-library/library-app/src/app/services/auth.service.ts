import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

export interface User {
  id: number;
  username: string;
  role: string;
}

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/rocketLibrary/api'; 

  constructor(private http: HttpClient) {}

  login(data: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/login`, data, {
      withCredentials: true,
    }).pipe(
      tap((res: any) => {
        localStorage.setItem('role', res.role);
        localStorage.setItem('user', JSON.stringify(res.user)); 
      })
    );
  }

  register(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, data, {
      withCredentials: true,
    });
  }

  
  logout() {
    localStorage.clear();
  }

  isAdmin(): boolean {
    return localStorage.getItem('role') === 'ADMIN';
  }

  isLoggedIn(): boolean {
    return !!this.getCurrentUser();
  }


  getCurrentUser(): User | null {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user) : null;
  }
}