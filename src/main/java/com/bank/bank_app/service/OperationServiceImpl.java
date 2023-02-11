package com.bank.bank_app.service;

import com.bank.bank_app.model.entity.OperationEntity;
import com.bank.bank_app.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService{
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public List<OperationEntity> showAllOperations() {
        return operationRepository.findAll();
    }

    @Override
    public OperationEntity getOperation(long id) {
        Optional<OperationEntity> operation = operationRepository.findById(id);
        return operation.orElseThrow(NoSuchElementException::new);
    }

    @Override
    public OperationEntity saveOperation(OperationEntity operationEntity) {
        operationRepository.save(operationEntity);
        return operationEntity;
    }

    @Override
    public OperationEntity updateOperation(OperationEntity operationEntity) {
        return saveOperation(operationEntity);
    }

    @Override
    public long deleteOperation(long id) {
        operationRepository.deleteById(id);
        return id;
    }
}
