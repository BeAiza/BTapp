package org.BTapp.BudgetTracker.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

@RestController
@RequestMapping(value = "/budgets", method = RequestMethod.GET)
public class BudgetController {

    @Autowired
    private final BudgetService budgetService;
    @Autowired
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

    @GetMapping(value = "/list")
    public String list(@RequestParam("search") String search, Model model) {
        //Receive users budgets and add them to model
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        Long userId = currentUser.getId();

        List<Budget> budgets = budgetService.findAllBUserId(userId, search);
        model.addAttribute("budgets", budgets);

        return "budget/list"; //Thymeleaf view
    }

    @GetMapping(value = "/create")
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

    @GetMapping(value = "/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Budget> budget = budgetService.findById(id);
        budget.ifPresent(value -> model.addAttribute("budget", value));
        return "budget/edit"; // Thymeleaf view for budget editing
    }

    @PutMapping(value = "/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Budget budget) {
        budgetService.save(budget);
        return "redirect/budgets";
    }

}
