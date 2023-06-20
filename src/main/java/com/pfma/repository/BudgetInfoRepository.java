package com.pfma.repository;

import com.pfma.model.Budget;
import com.pfma.model.BudgetInfo;
import com.pfma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BudgetInfoRepository extends JpaRepository<BudgetInfo, UUID> {
    Optional<BudgetInfo> findBudgetInfoByBudget(Budget budget);
    Optional<List<BudgetInfo>> findBudgetInfosByRoleAndBudgetAndUsersIsLike(User user);
}
