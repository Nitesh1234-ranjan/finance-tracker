package com.example.finance_tracker.controller;

import com.example.finance_tracker.constants.ApiPaths;
import com.example.finance_tracker.orchestration.OrchestrationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(ApiPaths.REPORTS)
public class ReportController {

    private final OrchestrationInterface orchestration;

    @Autowired
    public ReportController(OrchestrationInterface orchestration) {
        this.orchestration = orchestration;
    }

    @GetMapping(ApiPaths.Summary)
    public Map<String, Object> getSummaryReport() {
        return orchestration.getSummaryReport();
    }

    @GetMapping("/monthly")
    public Map<String, Object> getMonthlyReport(@RequestParam int month, @RequestParam int year) {
        return orchestration.getMonthlyReport(month, year);
    }
}
