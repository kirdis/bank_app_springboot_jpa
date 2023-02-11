package com.bank.bank_app.service;

import com.bank.bank_app.model.entity.AtmEntity;
import com.bank.bank_app.repository.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AtmServiceImpl implements AtmService{

    @Autowired
    private AtmRepository atmRepository;

    @Override
    public List<AtmEntity> showAllAtms() {
        return atmRepository.findAll();
    }

    @Override
    public AtmEntity getAtm(long id) {
        Optional<AtmEntity> atm = atmRepository.findById(id);
        return atm.orElseThrow(NoSuchElementException::new);
    }

    @Override
    public AtmEntity saveAtm(AtmEntity atmEntity) {
        return atmRepository.save(atmEntity);
    }

    @Override
    public long deleteAtm(long id) {
        atmRepository.deleteById(id);
        return id;
    }

    @Override
    public AtmEntity updateAtm(AtmEntity atmEntity) {
        return saveAtm(atmEntity);
    }
}
