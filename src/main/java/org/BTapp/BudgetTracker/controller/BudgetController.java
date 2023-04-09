package org.BTapp.BudgetTracker.controller;

import org.BTapp.BudgetTracker.Service.BudgetService;
import org.BTapp.BudgetTracker.Service.UserService;
import org.BTapp.BudgetTracker.model.Budget;
import org.BTapp.BudgetTracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/budgets")
public class BudgetController {


    private final BudgetService budgetService;
    private final UserService userService;



    private Long userId;
    @Autowired
    public BudgetController(BudgetService budgetService, UserService userService) {
        this.budgetService = budgetService;
        this.userService = userService;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @GetMapping
    public String list(Model model) {
        //Receive users budgets and add them to model
        //Replace "userId" with actual user ID from auth
        Long userId = 1L;
        List<Budget> budgets = budgetService.findAllBUserId(userId);
        model.addAttribute("budgets", budgets);

        return "budget/list"; //Thymeleaf view
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("budget", new Budget());
        return "budget/create";
    }

    @PostMapping
    public String create(@ModelAttribute Budget budget) {
        User user = userService.findById(userId).orElse(null);
        if (user != null) {
            budget.setUser(user);
            budgetService.save(budget);
        }

        return "redirect/budgets";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Budget> budget = budgetService.findById(id);
        budget.ifPresent(value -> model.addAttribute("budget", value));
        return "budget/edit"; // Thymeleaf view for budget editing
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Budget budget) {
        budgetService.save(budget);
        return "redirect/budgets";
    }

}