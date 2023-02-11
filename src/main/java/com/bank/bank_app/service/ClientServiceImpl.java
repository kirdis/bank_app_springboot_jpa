package com.bank.bank_app.service;

import com.bank.bank_app.model.entity.ClientEntity;
import com.bank.bank_app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static com.bank.bank_app.utils.Base64Converter.decodeFromBase64;
import static com.bank.bank_app.utils.Base64Converter.encodeToBase64;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientEntity> showAllClients() {
        List<ClientEntity> clients = clientRepository.findAll();
        clients.forEach(ClientServiceImpl::decodePassportNumber);
        return clients;
    }

    @Override
    public ClientEntity getClient(long id) {
        ClientEntity client = clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
        decodePassportNumber(client);
        return client;
    }

    @Override
    public ClientEntity saveClient(ClientEntity clientEntity) {
        encodePassportNumber(clientEntity);
        return clientRepository.save(clientEntity);
    }

    @Override
    public ClientEntity updateClient(ClientEntity clientEntity) {
        return saveClient(clientEntity);
    }

    @Override
    public long deleteClient(long id) {
        clientRepository.deleteById(id);
        return id;
    }

    private static void encodePassportNumber(ClientEntity clientEntity) {
        String encodedPassportNumber = encodeToBase64(clientEntity.getPassportNumber());
        clientEntity.setPassportNumber(encodedPassportNumber);
    }

    private static void decodePassportNumber(ClientEntity client) {
        String decodedPassportNumber = decodeFromBase64(client.getPassportNumber());
        client.setPassportNumber(decodedPassportNumber);
    }
}
