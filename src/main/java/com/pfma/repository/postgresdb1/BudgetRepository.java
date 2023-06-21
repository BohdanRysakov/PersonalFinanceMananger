package com.pfma.repository.postgresdb1;

import com.pfma.model.postgresdb1.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BudgetRepository extends JpaRepository<Budget, UUID> {

}
