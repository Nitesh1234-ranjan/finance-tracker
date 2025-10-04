package com.example.finance_tracker.dto;

import java.time.LocalDate;

public class IncomeDTO {
    private Long id;
    private String source;
    private double amount;
    private LocalDate date;
    private Long userId;

    public IncomeDTO() {}

    public IncomeDTO(Long id, String source, double amount, LocalDate date, Long userId) {
        this.id = id;
        this.source = source;
        this.amount = amount;
        this.date = date;
        this.userId = userId;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
