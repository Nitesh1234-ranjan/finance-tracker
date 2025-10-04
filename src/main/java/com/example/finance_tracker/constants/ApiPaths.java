package com.example.finance_tracker.constants;

public class ApiPaths {

    private ApiPaths() {
        // private constructor to prevent instantiation
    }

    public static final String USERS = "/users";
    public static final String USER_BY_ID = "/{id}";

    public static final String EXPENSES = "/expenses";
    public static final String EXPENSE_BY_ID = "/{id}";

    public static final String INCOMES = "/incomes";
    public static final String INCOME_BY_ID = "/{id}";

    public static final String REPORTS = "/reports";
    public static final String SUMMARY_REPORT = "/reports/summary";
    public static final String MONTHLY_REPORT = "/reports/monthly";

    public static final String Summary = "/summary";
}
