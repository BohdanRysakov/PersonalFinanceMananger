package com.pfma.Service;

import com.pfma.model.postgresdb1.Budget;
import com.pfma.model.postgresdb1.Operation;
import com.pfma.repository.postgresdb1.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Optional<Budget> getBudget(UUID id) {
        return budgetRepository.findById(id);
    }

    public Budget updateBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public void deleteBudget(UUID id) {
        budgetRepository.deleteById(id);
    }

    public void addOperationToBudget(UUID budgetId, Operation operation) {
        Budget budget = getBudget(budgetId).orElseThrow(() -> new RuntimeException("Budget not found"));
        budget.getOperations().add(operation);
        budgetRepository.save(budget);
    }
}