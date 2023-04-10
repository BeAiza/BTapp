package org.BTapp.BudgetTracker.model.data;

import org.BTapp.BudgetTracker.model.Budget;
import org.BTapp.BudgetTracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByBudgetId(Long budgetId);
    //interfaces with custom search queries.
    @Query
    List<Transaction> findAllByBudgetIdAndSearch(Long budgetId, String search);
}


