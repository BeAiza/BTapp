package org.BTapp.BudgetTracker.model.data;

import org.BTapp.BudgetTracker.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    //interfaces with custom search queries.
    @Query("SELECT b FROM Budget b WHERE b.user.id = :userId AND (b.name LIKE %:search% OR :search IS NULL OR :search = '')")
    List<Budget> findAllByUserId(Long userId, String search);




}
