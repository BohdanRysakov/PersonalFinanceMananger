package com.pfma.controller;

import com.pfma.Service.OperationService;
import com.pfma.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public List<Operation> getOperations() {
        return operationService.getOperations();
    }

    @GetMapping("/{id}")
    public Operation getOperation(@PathVariable UUID id) {
        return operationService.getOperation(id);
    }

    @PostMapping
    public Operation addOperation(@RequestBody Operation operation) {
        return operationService.addOperation(operation);
    }

    @PutMapping("/{id}")
    public Operation updateOperation(@PathVariable UUID id, @RequestBody Operation operation) {
        return operationService.updateOperation(id, operation);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable UUID id) {
        operationService.deleteOperation(id);
    }
}