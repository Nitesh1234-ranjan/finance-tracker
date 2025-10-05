package com.example.finance_tracker.orchestration;

import com.example.finance_tracker.dto.UserDTO;
import com.example.finance_tracker.dto.ExpenseDTO;
import com.example.finance_tracker.dto.IncomeDTO;
import com.example.finance_tracker.service.UserServiceInterface;
import com.example.finance_tracker.service.ExpenseServiceInterface;
import com.example.finance_tracker.service.IncomeServiceInterface;
import com.example.finance_tracker.service.ReportServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Orchestration implements OrchestrationInterface {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private ExpenseServiceInterface expenseService;

    @Autowired
    private IncomeServiceInterface incomeService;

    @Autowired
    private ReportServiceInterface reportService;

    // ===== User methods =====
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userService.getUserById(id);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    // ===== Expense methods =====
    @Override
    public ExpenseDTO addExpense(ExpenseDTO dto) {
        return expenseService.addExpense(dto);
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @Override
    public ExpenseDTO getExpenseById(Long id) {
        return expenseService.getExpenseById(id);
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO dto) {
        return expenseService.updateExpense(id, dto);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseService.deleteExpense(id);
    }

    // ===== Income methods =====
    @Override
    public IncomeDTO addIncome(IncomeDTO dto) {
        return incomeService.addIncome(dto);
    }

    @Override
    public List<IncomeDTO> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    @Override
    public IncomeDTO getIncomeById(Long id) {
        return incomeService.getIncomeById(id);
    }

    @Override
    public IncomeDTO updateIncome(Long id, IncomeDTO dto) {
        return incomeService.updateIncome(id, dto);
    }

    @Override
    public void deleteIncome(Long id) {
        incomeService.deleteIncome(id);
    }

    @Override
    public Map<String, Object> getSummaryReport() {
        return reportService.getSummaryReport();
    }

    @Override
    public Map<String, Object> getMonthlyReport(int month, int year) {
        return reportService.getMonthlyReport(month, year);
    }

    @Override
    public boolean validateUser(String email, String password){
        return userService.validateUser(email, password);
    }
}
