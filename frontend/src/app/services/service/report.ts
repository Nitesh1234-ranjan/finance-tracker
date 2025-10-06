import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Report {
  totalIncome: number;
  totalExpense: number;
  balance: number;
}

@Injectable({
  providedIn: 'root'
})
export class Report {
  private baseUrl = 'http://localhost:8080/reports';

  constructor(private http: HttpClient) {}


  getSummaryReport(): Observable<Report> {
    return this.http.get<Report>(`${this.baseUrl}/summary`);
  }


  getMonthlyReport(month: number, year: number): Observable<Report> {
    const params = new HttpParams()
      .set('month', month.toString())
      .set('year', year.toString());

    return this.http.get<Report>(`${this.baseUrl}/monthly`, { params });
  }
}
