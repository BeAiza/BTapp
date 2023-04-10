package org.BTapp.BudgetTracker.Service;

import org.BTapp.BudgetTracker.model.Budget;
import org.BTapp.BudgetTracker.model.data.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// handles business logic to improve the maintainability, modularity, and testability of the application.
@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    // Implement budget-related business logic methods here, e.g., create, update, delete, etc.


    public List<Budget> findAllBUserId (Long userId, String search) {
        return budgetRepository.findAllByUserId(userId, search);
    }
    public Optional<Budget> findById(Long id) {
        return budgetRepository.findById(id);
    }

    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    public void deleteById(Long id) {
        budgetRepository.deleteById(id);
    }
}
