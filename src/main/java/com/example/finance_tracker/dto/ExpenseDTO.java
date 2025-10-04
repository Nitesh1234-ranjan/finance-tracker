package com.example.finance_tracker.dto;

import java.time.LocalDate;

public class ExpenseDTO {
    private Long id;
    private String category;
    private double amount;
    private String description;
    private LocalDate date;
    private Long userId;   // To link expense with a user

    public ExpenseDTO() {}

    public ExpenseDTO(Long id, String category, double amount, String description, LocalDate date, Long userId) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.description = description;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
