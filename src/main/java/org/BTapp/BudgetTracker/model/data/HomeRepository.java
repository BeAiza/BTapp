package org.BTapp.BudgetTracker.model.data;

import org.BTapp.BudgetTracker.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
    private Home findByUserId(long userId) {
        return null;
    }

    private Home findByUsername(String username) {
        return null;
    }


    private Home findByEmail(String email) {
        return null;
    }



}