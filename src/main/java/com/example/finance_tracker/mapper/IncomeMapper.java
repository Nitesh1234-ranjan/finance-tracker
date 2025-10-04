package com.example.finance_tracker.mapper;

import com.example.finance_tracker.dto.IncomeDTO;
import com.example.finance_tracker.model.Income;
import com.example.finance_tracker.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class IncomeMapper {

    public static Income toEntity(IncomeDTO dto, User user) {
        if (dto == null) return null;
        Income income = new Income();
        income.setId(dto.getId());
        income.setSource(dto.getSource());
        income.setAmount(dto.getAmount());
        income.setDate(dto.getDate());
        income.setUser(user);
        return income;
    }

    public static IncomeDTO toDTO(Income entity) {
        if (entity == null) return null;
        return new IncomeDTO(
                entity.getId(),
                entity.getSource(),
                entity.getAmount(),
                entity.getDate(),
                entity.getUser() != null ? entity.getUser().getId() : null
        );
    }

    public static List<IncomeDTO> toDTOList(List<Income> incomes) {
        return incomes.stream()
                .map(IncomeMapper::toDTO)
                .collect(Collectors.toList());
    }
}
