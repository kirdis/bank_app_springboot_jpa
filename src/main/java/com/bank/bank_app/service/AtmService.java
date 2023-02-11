package com.bank.bank_app.service;

import com.bank.bank_app.model.entity.AtmEntity;

import java.util.List;

public interface AtmService {
    public List<AtmEntity> showAllAtms();

    public AtmEntity getAtm(long id);

    public AtmEntity saveAtm(AtmEntity atmEntity);

    public long deleteAtm(long id);

    public AtmEntity updateAtm(AtmEntity atmEntity);
}
