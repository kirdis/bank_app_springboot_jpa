package com.bank.bank_app.service;

import com.bank.bank_app.model.entity.ClientEntity;

import java.util.List;

public interface ClientService {
    public List<ClientEntity> showAllClients();

    public ClientEntity getClient(long id);

    public ClientEntity saveClient(ClientEntity clientEntity);

    public ClientEntity updateClient(ClientEntity clientEntity);

    public long deleteClient(long id);
}
