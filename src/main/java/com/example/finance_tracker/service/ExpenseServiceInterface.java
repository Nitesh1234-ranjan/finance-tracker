package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.ExpenseDTO;
import java.util.List;

public interface ExpenseServiceInterface {
    ExpenseDTO addExpense(ExpenseDTO dto);
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO getExpenseById(Long id);
    ExpenseDTO updateExpense(Long id, ExpenseDTO dto);
    void deleteExpense(Long id);
}
