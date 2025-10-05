package com.example.finance_tracker.controller;

import com.example.finance_tracker.constants.ApiPaths;
import com.example.finance_tracker.dto.ExpenseDTO;
import com.example.finance_tracker.orchestration.OrchestrationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ApiPaths.EXPENSES)
public class ExpenseController {

    private final OrchestrationInterface orchestration;

    @Autowired
    public ExpenseController(OrchestrationInterface orchestration) {
        this.orchestration = orchestration;
    }

    @PostMapping
    public ExpenseDTO addExpense(@RequestBody ExpenseDTO dto) {
        return orchestration.addExpense(dto);
    }

    @GetMapping
    public List<ExpenseDTO> getAllExpenses() {
        return orchestration.getAllExpenses();
    }

    @GetMapping(ApiPaths.EXPENSE_BY_ID)
    public ExpenseDTO getExpenseById(@PathVariable Long id) {
        return orchestration.getExpenseById(id);
    }

    @PutMapping(ApiPaths.EXPENSE_BY_ID)
    public ExpenseDTO updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO dto) {
        return orchestration.updateExpense(id, dto);
    }

    @DeleteMapping(ApiPaths.EXPENSE_BY_ID)
    public void deleteExpense(@PathVariable Long id) {
        orchestration.deleteExpense(id);
    }
}
