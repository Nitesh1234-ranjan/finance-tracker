package com.example.finance_tracker.controller;

import com.example.finance_tracker.constants.ApiPaths;
import com.example.finance_tracker.dto.IncomeDTO;
import com.example.finance_tracker.orchestration.OrchestrationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.INCOMES)
public class IncomeController {

    private final OrchestrationInterface orchestration;

    @Autowired
    public IncomeController(OrchestrationInterface orchestration) {
        this.orchestration = orchestration;
    }

    @PostMapping
    public IncomeDTO addIncome(@RequestBody IncomeDTO dto) {
        return orchestration.addIncome(dto);
    }

    @GetMapping
    public List<IncomeDTO> getAllIncomes() {
        return orchestration.getAllIncomes();
    }

    @GetMapping(ApiPaths.INCOME_BY_ID)
    public IncomeDTO getIncomeById(@PathVariable Long id) {
        return orchestration.getIncomeById(id);
    }

    @PutMapping(ApiPaths.INCOME_BY_ID)
    public IncomeDTO updateIncome(@PathVariable Long id, @RequestBody IncomeDTO dto) {
        return orchestration.updateIncome(id, dto);
    }

    @DeleteMapping(ApiPaths.INCOME_BY_ID)
    public void deleteIncome(@PathVariable Long id) {
        orchestration.deleteIncome(id);
    }
}
