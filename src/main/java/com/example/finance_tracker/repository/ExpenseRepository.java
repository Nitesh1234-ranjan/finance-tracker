package com.example.finance_tracker.repository;

import com.example.finance_tracker.model.Expense;
import com.example.finance_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    List<Expense> findByUser(User user);

}
