package com.pfma.Service;

import com.pfma.model.postgresdb1.Operation;
import com.pfma.model.postgresdb1.User;
import com.pfma.repository.postgresdb1.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private UserService userService;

    public Operation createOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    public Optional<Operation> getOperation(UUID id) {
        return operationRepository.findById(id);
    }

    public Operation updateOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    public void deleteOperation(UUID id) {
        operationRepository.deleteById(id);
    }

    public void assignOperationToUser(UUID operationId, UUID userId) {
        Operation operation = getOperation(operationId).orElseThrow(() -> new RuntimeException("Operation not found"));
        User user = userService.getUser(userId).orElseThrow(() -> new RuntimeException("User not found"));
        operation.setUser(user);
        operationRepository.save(operation);
    }
}