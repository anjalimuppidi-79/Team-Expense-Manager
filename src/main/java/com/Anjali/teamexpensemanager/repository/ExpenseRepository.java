package com.Anjali.teamexpensemanager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Anjali.teamexpensemanager.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	List<Expense> findByEventId(Long eventId);
}
