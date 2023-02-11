package com.bank.bank_app.controller;

import com.bank.bank_app.model.entity.OperationEntity;
import com.bank.bank_app.service.OperationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping("")
    public ResponseEntity<List<OperationEntity>> showAllOperations() {
        return new ResponseEntity<>(operationService.showAllOperations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationEntity> getOperation(@PathVariable long id) {
        return new ResponseEntity<>(operationService.getOperation(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<OperationEntity> saveOperation(@Valid @RequestBody OperationEntity operationEntity) {
        return new ResponseEntity<>(operationService.saveOperation(operationEntity), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOperation(@PathVariable long id) {
        operationService.deleteOperation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperationEntity> updateOperation(@PathVariable long id, @Valid @RequestBody OperationEntity operationEntity) {
        operationEntity.setId(id);
        return new ResponseEntity<>(operationService.updateOperation(operationEntity), HttpStatus.OK);
    }
}
