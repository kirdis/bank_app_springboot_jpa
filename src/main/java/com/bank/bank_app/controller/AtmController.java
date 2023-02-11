package com.bank.bank_app.controller;

import com.bank.bank_app.model.entity.AtmEntity;
import com.bank.bank_app.service.AtmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atm")
public class AtmController {

    @Autowired
    private AtmService atmService;

    @GetMapping("")
    public ResponseEntity<List<AtmEntity>>  showAllAtms() {
        return new ResponseEntity<>(atmService.showAllAtms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtmEntity> getAtm(@PathVariable long id) {
        return new ResponseEntity<>(atmService.getAtm(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<AtmEntity> saveAtm(@Valid @RequestBody AtmEntity atmEntity) {
        return new ResponseEntity<>(atmService.saveAtm(atmEntity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtmEntity> updateAtm(@PathVariable long id, @Valid @RequestBody AtmEntity atmEntity) {
        atmEntity.setId(id);
        return new ResponseEntity<>(atmService.updateAtm(atmEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAtm(@PathVariable long id) {
        atmService.deleteAtm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
