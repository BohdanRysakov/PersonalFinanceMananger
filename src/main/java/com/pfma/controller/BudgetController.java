package com.pfma.controller;

import com.pfma.Service.BudgetService;
import com.pfma.model.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping
    public List<Budget> getBudgets() {
        return budgetService.getBudgets();
    }

    @GetMapping("/{id}")
    public Budget getBudget(@PathVariable UUID id) {
        return budgetService.getBudget(id);
    }

    @PostMapping
    public Budget addBudget(@RequestBody Budget budget) {
        return budgetService.addBudget(budget);
    }

    @PutMapping("/{id}")
    public Budget updateBudget(@PathVariable UUID id, @RequestBody Budget budget) {
        return budgetService.updateBudget(id, budget);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable UUID id) {
        budgetService.deleteBudget(id);
    }
}