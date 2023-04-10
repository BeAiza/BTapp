package org.BTapp.BudgetTracker.Service;


import org.BTapp.BudgetTracker.model.Star;
        import org.BTapp.BudgetTracker.model.data.StarRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.Optional;

@Service
public class StarService {
    @Autowired
    private StarRepository starRepository;

    public Optional<Star> findByUserIdAndBudgetId(Long userId, Long budgetId) {
        return starRepository.findByUserIdAndBudgetId(userId, budgetId);
    }

    public Star save(Star star) {
        return starRepository.save(star);
    }

    public void deleteById(Long id) {
        starRepository.deleteById(id);
    }
}