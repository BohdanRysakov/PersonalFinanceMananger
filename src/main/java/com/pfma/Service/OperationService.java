package com.pfma.Service;

import com.pfma.model.Operation;
import com.pfma.repository.OperationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OperationService {
    @Autowired
    private OperationRepository operationRepository;

    public List<Operation> getOperations() {
        return operationRepository.findAll();
    }

    public Operation getOperation(UUID id) {
        return operationRepository.findById(id).orElse(null);
    }

    public Operation addOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    public Operation updateOperation(UUID id, Operation operation) {
        Operation existingOperation = getOperation(id);
        if (existingOperation != null) {
            BeanUtils.copyProperties(operation, existingOperation, "id");
            return operationRepository.save(existingOperation);
        }
        return null;
    }

    public void deleteOperation(UUID id) {
        operationRepository.deleteById(id);
    }
}
