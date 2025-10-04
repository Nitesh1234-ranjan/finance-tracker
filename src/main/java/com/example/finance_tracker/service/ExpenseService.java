package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.ExpenseDTO;
import com.example.finance_tracker.mapper.ExpenseMapper;
import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.model.User;
import com.example.finance_tracker.repository.ExpenseRepository;
import com.example.finance_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService implements ExpenseServiceInterface {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ExpenseDTO addExpense(ExpenseDTO dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Expense expense = ExpenseMapper.toEntity(dto, user);
        expense = expenseRepository.save(expense);
        return ExpenseMapper.toDTO(expense);
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        return ExpenseMapper.toDTOList(expenseRepository.findAll());
    }

    @Override
    public ExpenseDTO getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
        return ExpenseMapper.toDTO(expense);
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO dto) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setCategory(dto.getCategory());
        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());
        expense.setDate(dto.getDate());
        expense = expenseRepository.save(expense);
        return ExpenseMapper.toDTO(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
