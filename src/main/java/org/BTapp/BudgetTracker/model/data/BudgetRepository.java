package org.BTapp.BudgetTracker.model.data;

import org.BTapp.BudgetTracker.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    //interfaces with custom search queries.
    @Query
    List<Budget> findAllByUserId(Long userId, String search);




}
