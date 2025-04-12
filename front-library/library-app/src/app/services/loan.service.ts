import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
  private apiUrl = 'http://localhost:8080/rocketLibrary/api/loans';

  constructor(private http: HttpClient) {}

  createLoan(data: any): Observable<any> {
    return this.http.post(this.apiUrl, data);
  }

  getAllLoans(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/getActiveLoans`);
  }


  getLoansByUser(userId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/user/${userId}`);
  }
}
