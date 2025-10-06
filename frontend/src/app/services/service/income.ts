import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Income {
  id?: number;
  source: string;
  amount: number;
  date: string;
  userId: number;
}

@Injectable({
  providedIn: 'root'
})
export class Income {
  private baseUrl = 'http://localhost:8080/incomes';

  constructor(private http: HttpClient) {}

  addIncome(income: Income): Observable<Income> {
    return this.http.post<Income>(this.baseUrl, income);
  }

  getAllIncomes(): Observable<Income[]> {
    return this.http.get<Income[]>(this.baseUrl);
  }

  getIncomeById(id: number): Observable<Income> {
    return this.http.get<Income>(`${this.baseUrl}/${id}`);
  }

  updateIncome(id: number, income: Income): Observable<Income> {
    return this.http.put<Income>(`${this.baseUrl}/${id}`, income);
  }

  deleteIncome(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
