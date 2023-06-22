package com.pfma.Service;

import com.pfma.exceptions.UserNotFoundException;
import com.pfma.model.postgresdb1.Budget;
import com.pfma.model.postgresdb1.Operation;
import com.pfma.model.postgresdb1.User;
import com.pfma.repository.postgresdb1.BudgetRepository;
import com.pfma.repository.postgresdb1.UserRepository;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Log4j
public class BudgetService {
    private static final Logger logger = LogManager.getLogger(BudgetService.class);
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

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
    @Secured({"ROLE_OWNER","ROLE_ADMIN"})
    public void addUserToBudget(UUID userId, Budget budget) {
        User user = userService.getUser(userId).orElseThrow(
                () -> {
                    logger.info("Failed to add user <" + userRepository.findUserNameById(userId) +
                            "> to budget <"+budget.getBudgetName()+">" +
                            "Cause: user not found"
                    );
                    throw  new UserNotFoundException("User not found");
                }
        );
        budget.getUsers().add(user);
        budgetRepository.save(budget);
    }
}