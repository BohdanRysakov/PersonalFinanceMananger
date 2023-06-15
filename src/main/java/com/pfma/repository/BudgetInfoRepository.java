package com.pfma.repository;

import com.pfma.model.BudgetInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BudgetInfoRepository extends JpaRepository<BudgetInfo, UUID> {
}
