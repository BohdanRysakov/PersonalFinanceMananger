package com.pfma.repository.postgresdb1;

import com.pfma.model.postgresdb1.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperationRepository extends JpaRepository<Operation, UUID> {
}
