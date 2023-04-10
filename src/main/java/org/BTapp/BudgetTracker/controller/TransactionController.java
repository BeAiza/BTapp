package org.BTapp.BudgetTracker.controller;

import org.BTapp.BudgetTracker.Service.BudgetService;
import org.BTapp.BudgetTracker.Service.TransactionService;
import org.BTapp.BudgetTracker.model.Budget;
import org.BTapp.BudgetTracker.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final BudgetService budgetService;
    private Long budgetId;
    @Autowired
    public TransactionController(TransactionService transactionService, BudgetService budgetService) {
        this.transactionService = transactionService;
        this.budgetService = budgetService;
    }
    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }
    @GetMapping("/list")
    public String list(@RequestParam("search") String search, Model model) {
        //retrieve the transaction for a specific budget and add to the model
        //replace "budgetId" with actual budget ID from request
        Long budgetId = 1L;
        List<Transaction> transactions = transactionService.findAllByBudgetId(budgetId, search);
        model.addAttribute("transactions", transactions);

        return "transactions/list";

    }
    @PostMapping
    public String create(@ModelAttribute Transaction transaction) {
        Budget budget = budgetService.findById(budgetId).orElse(null);
        if (budget != null){
            transaction.setBudget(budget);
            transactionService.save(transaction);
        }
        return "redirect:/transactions";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Transaction transaction) {
        transactionService.save(transaction);

        return "redirect:/transactions";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        transactionService.deleteById(id);
        return "redirect:/transactions";
    }

    @GetMapping("/category-total")
    @ResponseBody
    public double categoryTotal(@RequestParam Long budgetId,
                                @RequestParam String category) {
        return transactionService.calculateTotalAmountByCategory(budgetId, category);
    }


}
