package com.example.finance_tracker.service;

import com.example.finance_tracker.model.Income;
import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.repository.IncomeRepository;
import com.example.finance_tracker.repository.ExpenseRepository;
import com.example.finance_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService implements ReportServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    // Summary report for all users combined
    @Override
    public Map<String, Object> getSummaryReport() {
        double totalIncome = 0;
        double totalExpense = 0;

        List<Income> incomes = incomeRepository.findAll();
        for (Income i : incomes) totalIncome += i.getAmount();

        List<Expense> expenses = expenseRepository.findAll();
        for (Expense e : expenses) totalExpense += e.getAmount();

        Map<String, Object> report = new HashMap<>();
        report.put("totalIncome", totalIncome);
        report.put("totalExpense", totalExpense);
        report.put("balance", totalIncome - totalExpense);
        return report;
    }

    // Monthly report (filter by month & year)
    @Override
    public Map<String, Object> getMonthlyReport(int month, int year) {
        double totalIncome = 0;
        double totalExpense = 0;

        List<Income> incomes = incomeRepository.findAll();
        for (Income i : incomes) {
            if (i.getDate().getMonthValue() == month && i.getDate().getYear() == year)
                totalIncome += i.getAmount();
        }

        List<Expense> expenses = expenseRepository.findAll();
        for (Expense e : expenses) {
            if (e.getDate().getMonthValue() == month && e.getDate().getYear() == year)
                totalExpense += e.getAmount();
        }

        Map<String, Object> report = new HashMap<>();
        report.put("totalIncome", totalIncome);
        report.put("totalExpense", totalExpense);
        report.put("balance", totalIncome - totalExpense);
        return report;
    }
}
