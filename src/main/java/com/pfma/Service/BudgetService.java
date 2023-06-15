package com.pfma.Service;

import com.pfma.model.Budget;
import com.pfma.model.BudgetInfo;
import com.pfma.model.User;
import com.pfma.repository.BudgetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getBudgets() {
        return budgetRepository.findAll();
    }

    public Budget getBudget(UUID id) {
        return budgetRepository.findById(id).orElse(null);
    }

    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget updateBudget(UUID id, Budget budget) {
        Budget existingBudget = getBudget(id);
        if (existingBudget != null) {
            BeanUtils.copyProperties(budget, existingBudget, "id");
            return budgetRepository.save(existingBudget);
        }
        return null;
    }

    public void deleteBudget(UUID id) {
        budgetRepository.deleteById(id);
    }
}
