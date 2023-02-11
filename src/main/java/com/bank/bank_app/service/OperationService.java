package com.bank.bank_app.service;

import com.bank.bank_app.model.entity.OperationEntity;

import java.util.List;

public interface OperationService {
    public List<OperationEntity> showAllOperations();

    public OperationEntity getOperation(long id);

    public OperationEntity saveOperation(OperationEntity operationEntity);

    public OperationEntity updateOperation(OperationEntity operationEntity);

    public long deleteOperation(long id);
}
