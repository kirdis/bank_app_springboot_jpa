package com.bank.bank_app.controller;

import com.bank.bank_app.model.entity.CardEntity;
import com.bank.bank_app.service.CardService;
import com.bank.bank_app.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public ResponseEntity<List<CardEntity>> showAllCards() {
        return new ResponseEntity<>(cardService.showAllCards(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardEntity> getCard(@PathVariable long id) {
        return new ResponseEntity<>(cardService.getCard(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CardEntity> saveCard(@Valid @RequestBody CardEntity cardEntity) {
        return new ResponseEntity<>(cardService.saveCard(cardEntity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardEntity> updateAtm(@PathVariable long id, @Valid @RequestBody CardEntity cardEntity) {
        cardEntity.setId(id);
        return new ResponseEntity<>(cardService.updateCard(cardEntity), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCard(@PathVariable long id) {
        cardService.deleteCard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
