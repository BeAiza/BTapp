package org.BTapp.BudgetTracker.controller;

import org.BTapp.BudgetTracker.model.Budget;
import org.BTapp.BudgetTracker.model.Star;
import org.BTapp.BudgetTracker.model.User;
import org.BTapp.BudgetTracker.Service.BudgetService;
import org.BTapp.BudgetTracker.Service.StarService;
import org.BTapp.BudgetTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stars")
public class StarController {
    @Autowired
    private StarService starService;
    @Autowired
    private UserService userService;
    @Autowired
    private BudgetService budgetService;

    @PostMapping
    public String toggleStar(@RequestParam("budgetId") Long budgetId) {
        Long userId = 1L; // Replace with the actual user ID from authentication
        Optional<Star> starOptional = starService.findByUserIdAndBudgetId(userId, budgetId);

        if (starOptional.isPresent()) {
            starService.deleteById(starOptional.get().getId());
        } else {
            User user = userService.findById(userId).orElse(null);
            Budget budget = budgetService.findById(budgetId).orElse(null);
            if (user != null && budget != null) {
                Star star = new Star();
                star.setUser(user);
                star.setBudget(budget);
                starService.save(star);
            }
        }

        return "redirect:/budgets";
    }
}