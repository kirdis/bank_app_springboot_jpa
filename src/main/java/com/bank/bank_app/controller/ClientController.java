package com.bank.bank_app.controller;

import com.bank.bank_app.model.entity.ClientEntity;
import com.bank.bank_app.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public ResponseEntity<List<ClientEntity>> showAllClients() {
        return new ResponseEntity<>(clientService.showAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> getClient(@PathVariable long id) {
        return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ClientEntity> saveClient(@Valid @RequestBody ClientEntity clientEntity) {
        return new ResponseEntity<>(clientService.saveClient(clientEntity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientEntity> updateClient(@PathVariable long id, @Valid @RequestBody ClientEntity clientEntity) {
        clientEntity.setId(id);
        return new ResponseEntity<>(clientService.updateClient(clientEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
