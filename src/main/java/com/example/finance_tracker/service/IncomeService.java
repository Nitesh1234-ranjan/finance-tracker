package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.IncomeDTO;
import com.example.finance_tracker.mapper.IncomeMapper;
import com.example.finance_tracker.model.Income;
import com.example.finance_tracker.model.User;
import com.example.finance_tracker.repository.IncomeRepository;
import com.example.finance_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService implements IncomeServiceInterface {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public IncomeDTO addIncome(IncomeDTO dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Income income = IncomeMapper.toEntity(dto, user);
        income = incomeRepository.save(income);
        return IncomeMapper.toDTO(income);
    }

    @Override
    public List<IncomeDTO> getAllIncomes() {
        return IncomeMapper.toDTOList(incomeRepository.findAll());
    }

    @Override
    public IncomeDTO getIncomeById(Long id) {
        Income income = incomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Income not found"));
        return IncomeMapper.toDTO(income);
    }

    @Override
    public IncomeDTO updateIncome(Long id, IncomeDTO dto) {
        Income income = incomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Income not found"));
        income.setSource(dto.getSource());
        income.setAmount(dto.getAmount());
        income.setDate(dto.getDate());
        income = incomeRepository.save(income);
        return IncomeMapper.toDTO(income);
    }

    @Override
    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
