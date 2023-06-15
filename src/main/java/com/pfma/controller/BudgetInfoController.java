package com.pfma.controller;

import com.pfma.Service.BudgetInfoService;
import com.pfma.model.Budget;
import com.pfma.model.BudgetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/budgets")
public class BudgetInfoController {

    @Autowired
    private BudgetInfoService budgetInfoService;

    @GetMapping
    public List<BudgetInfo> getBudgets() {
        return budgetInfoService.getBudgetInfos();
    }

    @GetMapping("/{id}")
    public BudgetInfo getBudgetInfo(@PathVariable UUID id) {
        return budgetInfoService.getBudgetInfo(id);
    }

    @PostMapping
    public BudgetInfo addBudgetInfo(@RequestBody BudgetInfo budgetInfo) {
        return budgetInfoService.addBudgetInfo(budgetInfo);
    }

    @PutMapping("/{id}")
    public BudgetInfo updateBudget(@PathVariable UUID id, @RequestBody BudgetInfo budgetInfo) {
        return budgetInfoService.updateBudgetInfo(id, budgetInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable UUID id) {
        budgetInfoService.deleteBudgetInfo(id);
    }
}