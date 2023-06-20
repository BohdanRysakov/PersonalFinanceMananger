package com.pfma.Service;

import com.pfma.exceptions.UserNotFoundException;
import com.pfma.model.Budget;
import com.pfma.model.BudgetInfo;
import com.pfma.model.User;
import com.pfma.repository.BudgetInfoRepository;
import com.pfma.repository.BudgetRepository;
import com.pfma.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private BudgetInfoRepository budgetInfoRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Budget> getBudgets() {
        return budgetRepository.findAll();
    }
    @Secured("ROLE_VIEWER")
    public Budget getBudget(UUID id) {
        return budgetRepository.findById(id).orElse(null);
    }

    public Budget createBudget(Budget budget,User user, BudgetInfo budgetInfo) {

        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("Пользователь не найден");
        }

        budgetInfo.setBudget(budget);
        budgetInfo.addUser(user);

        return budgetRepository.save(budget);
    }



    @Secured("ROLE_CHANGE")
    public Budget updateBudget(UUID id, Budget budget) {
        Budget existingBudget = getBudget(id);
        if (existingBudget != null) {
            BeanUtils.copyProperties(budget, existingBudget, "id");
            return budgetRepository.save(existingBudget);
        }
        return null;
    }

    @Secured("ROLE_OWNER")
    public void deleteBudget(UUID id) {
        budgetRepository.deleteById(id);
    }
}
