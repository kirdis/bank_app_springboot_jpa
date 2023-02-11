package com.bank.bank_app.service;

import com.bank.bank_app.model.entity.CardEntity;

import java.util.List;

public interface CardService {
    public List<CardEntity> showAllCards();

    public CardEntity getCard(long id);

    public CardEntity saveCard(CardEntity cardEntity);

    public long deleteCard(long id);

    public CardEntity updateCard(CardEntity cardEntity);
}
