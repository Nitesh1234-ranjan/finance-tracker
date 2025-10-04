package com.example.finance_tracker.service;

import java.util.Map;

public interface ReportServiceInterface {
    Map<String, Object> getSummaryReport();
    Map<String, Object> getMonthlyReport(int month, int year);
}
