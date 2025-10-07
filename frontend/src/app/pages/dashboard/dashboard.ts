import { Component, OnInit, Inject, PLATFORM_ID } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { ReportService, Report } from '../../services/service/report';
import { IncomeService, Income } from '../../services/service/income';
import { ExpenseService, Expense } from '../../services/service/expense';
import { Router } from '@angular/router';
@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.css']
})
export class DashboardComponent implements OnInit {
  isBrowser : boolean;
  summary?: Report;
  monthly?: Report;

  incomes: Income[] = [];
  expenses: Expense[] = [];

  currentMonth = new Date().getMonth() + 1;
  currentYear = new Date().getFullYear();

  constructor(
    private reportService: ReportService,
    private incomeService: IncomeService,
    private expenseService: ExpenseService,
    private router: Router,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {
      this.isBrowser = isPlatformBrowser(this.platformId);
    }

  ngOnInit(): void {
    this.loadSummary();
    this.loadMonthly();
    this.loadIncomes();
    this.loadExpenses();
  }

  loadSummary(): void {
    this.reportService.getSummaryReport().subscribe({
      next: (data: Report) => this.summary = data,
      error: (err: any) => console.error('Error loading summary', err)
    });
  }

  loadMonthly(): void {
    this.reportService.getMonthlyReport(this.currentMonth, this.currentYear).subscribe({
      next: (data: Report) => this.summary = data,
      error: (err: any) => console.error('Error loading monthly', err)
    });
  }

  loadIncomes(): void {
    this.incomeService.getAllIncomes().subscribe({
      next: (data: Income[]) => this.incomes = data.slice(-5).reverse(),
      error: (err: any) => console.error('Error loading incomes', err)
    });
  }

  deleteIncome(id: number): void {
    if (confirm('Delete this income?')) {
      this.incomeService.deleteIncome(id).subscribe({
        next: () => this.loadIncomes(),
        error: (err: any) => console.error('Error Deleting income', err)
      });
    }
  }

  loadExpenses(): void {
    this.expenseService.getAllExpenses().subscribe({
      next: (data: Expense[]) => this.expenses = data.slice(-5).reverse(),
      error: (err: any) => console.error('Error loading expense', err)
    });
  }

  deleteExpense(id: number): void {
    if (confirm('Delete this expense?')) {
      this.expenseService.deleteExpense(id).subscribe({
        next: () => this.loadExpenses(),
        error: (err: any) => console.error('Error deleting expense', err)
      });
    }
  }

  logout() {
    if (this.isBrowser) {
      localStorage.removeItem('isLoggedIn');
    }
    this.router.navigate(['/login']);
  }
}
