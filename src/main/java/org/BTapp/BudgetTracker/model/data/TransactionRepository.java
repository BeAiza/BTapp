package org.BTapp.BudgetTracker.model.data;

import org.BTapp.BudgetTracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByBudgetId(Long budgetId);
}
