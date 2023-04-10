package org.BTapp.BudgetTracker.Service;

import org.BTapp.BudgetTracker.model.Transaction;
import org.BTapp.BudgetTracker.model.data.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// handles business logic to improve the maintainability, modularity, and testability of the application.
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

// Implement transaction-related business logic methods here, e.g., create, update, delete, etc.

    public List<Transaction> findAllByBudgetId(Long budgetId, String search) {
        return transactionRepository.findAllByBudgetId(budgetId, search);
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public double calculateTotalAmountByCategory(Long budgetId, String category) {
        List<Transaction> transactions = findAllByBudgetId(budgetId);
        //Instead of using a for loop to calculate the total amount, used the stream() API to achieve the same result in a more concise way
        return transactions.stream()
                .filter(transaction -> transaction.getCategory().equalsIgnoreCase(category))
                .mapToDouble(Transaction::getAmount)
                .sum();

    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

}

