package com.example.finance_tracker.orchestration;

import com.example.finance_tracker.dto.UserDTO;
import com.example.finance_tracker.dto.ExpenseDTO;
import com.example.finance_tracker.dto.IncomeDTO;

import java.util.List;
import java.util.Map;

public interface OrchestrationInterface {

    // User methods
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);

    // Expense methods
    ExpenseDTO addExpense(ExpenseDTO dto);
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO getExpenseById(Long id);
    ExpenseDTO updateExpense(Long id, ExpenseDTO dto);
    void deleteExpense(Long id);

    // Income methods
    IncomeDTO addIncome(IncomeDTO dto);
    List<IncomeDTO> getAllIncomes();
    IncomeDTO getIncomeById(Long id);
    IncomeDTO updateIncome(Long id, IncomeDTO dto);
    void deleteIncome(Long id);

    // Report methods
    Map<String, Object> getSummaryReport();
    Map<String, Object> getMonthlyReport(int month, int year);
}
