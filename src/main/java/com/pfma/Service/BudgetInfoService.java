package com.pfma.Service;

import com.pfma.exceptions.BudgetInfoNotFoundException;
import com.pfma.model.Budget;
import com.pfma.model.BudgetInfo;
import com.pfma.model.Role;
import com.pfma.model.User;
import com.pfma.repository.BudgetInfoRepository;
import com.pfma.repository.BudgetRepository;
import com.pfma.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BudgetInfoService {
    @Autowired
    private BudgetInfoRepository budgetInfoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BudgetRepository budgetRepository;

    public List<BudgetInfo> getBudgetInfos() {
        return budgetInfoRepository.findAll();
    }

//    @Secured({"ROLE_OWNER","ROLE_ADMIN"})
//    public void grantRoles(BudgetInfo budgetInfo) {
//        // Найдите пользователя по ID
//        Optional<User> userOptional = userRepository.findById(userId);
//
//        // Найдите бюджет по ID
//        Optional<Budget> budgetOptional = budgetRepository.findById(budgetId);
//
//        // Если пользователь и бюджет найдены, обновите роли
//        if(userOptional.isPresent() && budgetOptional.isPresent()) {
//            User user = userOptional.get();
//            Budget budget = budgetOptional.get();
//
//
//           BudgetInfo budgetInfo = new BudgetInfo();
//           budgetInfo.setRole(roles);
//           budgetInfo.setUsers(new ArrayList<>((Collection) user));
//        }
//    }

    public BudgetInfo getBudgetInfo(UUID id) {
        return budgetInfoRepository.findById(id).orElse(null);
    }

    public BudgetInfo addBudgetInfo(BudgetInfo budgetInfo) {
        return budgetInfoRepository.save(budgetInfo);
    }

    public BudgetInfo updateBudgetInfo(UUID id, BudgetInfo budgetInfo) {
        BudgetInfo existingBudgetInfo = getBudgetInfo(id);
        if (existingBudgetInfo != null) {
            BeanUtils.copyProperties(budgetInfo, existingBudgetInfo, "id");
            return budgetInfoRepository.save(existingBudgetInfo);
        }
        return null;
    }

    public void deleteBudgetInfo(UUID id) {
        budgetInfoRepository.deleteById(id);
    }
}
