package com.bank.bank_app.service;

import com.bank.bank_app.model.entity.CardEntity;
import com.bank.bank_app.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static com.bank.bank_app.utils.Base64Converter.decodeFromBase64;
import static com.bank.bank_app.utils.Base64Converter.encodeToBase64;

@Service
public class CardServiceImpl implements CardService{
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<CardEntity> showAllCards() {
        List<CardEntity> cards = cardRepository.findAll();
        cards.forEach(CardServiceImpl::decodeCardNumber);
        return cards;
    }

    @Override
    public CardEntity getCard(long id) {
        CardEntity card = cardRepository.findById(id).orElseThrow(NoSuchElementException::new);
        decodeCardNumber(card);
        return card;
    }

    @Override
    public CardEntity saveCard(CardEntity cardEntity) {
        encodeCardNumber(cardEntity);
        return cardRepository.save(cardEntity);
    }

    @Override
    public long deleteCard(long id) {
        cardRepository.deleteById(id);
        return id;
    }

    @Override
    public CardEntity updateCard(CardEntity cardEntity) {
        return saveCard(cardEntity);
    }

    private static void encodeCardNumber(CardEntity card) {
        String encodedCardNumber = encodeToBase64(card.getCardNumber());
        card.setCardNumber(encodedCardNumber);
    }

    private static void decodeCardNumber(CardEntity card) {
        String decodedPassportNumber = decodeFromBase64(card.getCardNumber());
        card.setCardNumber(decodedPassportNumber);
    }
}
