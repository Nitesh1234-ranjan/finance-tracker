import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Expense {
  id?: number;
  category: string;
  amount: number;
  description: string;
  date: string;
  userId: number;
}

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {
  private baseUrl = 'http://52.66.200.200:8081/expenses';

  constructor(private http: HttpClient) {}


  addExpense(expense: Expense): Observable<Expense> {
    return this.http.post<Expense>(this.baseUrl, expense);
  }


  getAllExpenses(): Observable<Expense[]> {
    return this.http.get<Expense[]>(this.baseUrl);
  }


  getExpenseById(id: number): Observable<Expense> {
    return this.http.get<Expense>(`${this.baseUrl}/${id}`);
  }


  updateExpense(id: number, expense: Expense): Observable<Expense> {
    return this.http.put<Expense>(`${this.baseUrl}/${id}`, expense);
  }


  deleteExpense(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
