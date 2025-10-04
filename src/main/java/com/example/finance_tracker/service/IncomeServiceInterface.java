package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.IncomeDTO;
import java.util.List;

public interface IncomeServiceInterface {
    IncomeDTO addIncome(IncomeDTO dto);
    List<IncomeDTO> getAllIncomes();
    IncomeDTO getIncomeById(Long id);
    IncomeDTO updateIncome(Long id, IncomeDTO dto);
    void deleteIncome(Long id);
}
