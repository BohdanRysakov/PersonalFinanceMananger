package com.pfma.Service;

import com.pfma.model.Budget;
import com.pfma.model.BudgetInfo;
import com.pfma.repository.BudgetInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BudgetInfoService {
    @Autowired
    private BudgetInfoRepository budgetInfoRepository;

    public List<BudgetInfo> getBudgetInfos() {
        return budgetInfoRepository.findAll();
    }

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
