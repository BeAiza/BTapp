package org.BTapp.BudgetTracker.model.data;

import org.BTapp.BudgetTracker.model.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {
    Optional<Star> findByUserIdAndBudgetId(Long userId, Long budgetId);
}