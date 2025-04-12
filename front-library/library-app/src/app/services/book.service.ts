import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private apiUrl = 'http://localhost:8080/rocketLibrary/api/books'; 

  constructor(private http: HttpClient) {}

  getAllBooks(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/getAll?role=ADMIN`, {
      withCredentials: true,
    });
  }

  getBookById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/getById/${id}`, {
      withCredentials: true,
    });
  }

  createBook(book: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/create`, book, {
      withCredentials: true,
    });
  }
}