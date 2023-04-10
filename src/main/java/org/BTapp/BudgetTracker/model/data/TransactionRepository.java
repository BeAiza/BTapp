package org.BTapp.BudgetTracker.model.data;

import org.BTapp.BudgetTracker.model.Budget;
import org.BTapp.BudgetTracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query
    List<Transaction> findAllByBudgetId(Long budgetId, String search);
    //interfaces with custom search queries.


}
