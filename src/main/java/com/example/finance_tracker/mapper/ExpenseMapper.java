package com.example.finance_tracker.mapper;

import com.example.finance_tracker.dto.ExpenseDTO;
import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class ExpenseMapper {

    public static Expense toEntity(ExpenseDTO dto, User user) {
        if (dto == null) return null;
        Expense expense = new Expense();
        expense.setId(dto.getId());
        expense.setCategory(dto.getCategory());
        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());
        expense.setDate(dto.getDate());
        expense.setUser(user);
        return expense;
    }

    public static ExpenseDTO toDTO(Expense entity) {
        if (entity == null) return null;
        return new ExpenseDTO(
                entity.getId(),
                entity.getCategory(),
                entity.getAmount(),
                entity.getDescription(),
                entity.getDate(),
                entity.getUser() != null ? entity.getUser().getId() : null
        );
    }

    public static List<ExpenseDTO> toDTOList(List<Expense> expenses) {
        return expenses.stream()
                .map(ExpenseMapper::toDTO)
                .collect(Collectors.toList());
    }
}
