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

    //query selects all transactions whose budget ID matches the provided budgetId
    @Query("SELECT t FROM Transaction t WHERE t.budget.id = :budgetId AND (t.description LIKE %:search% OR :search IS NULL OR :search = '')")
    List<Transaction> findAllByBudgetIdAndSearch(Long budgetId, String search);
}


