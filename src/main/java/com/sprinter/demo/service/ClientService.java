package com.sprinter.demo.service;

import com.sprinter.demo.model.Client;
import com.sprinter.demo.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends GenericService<Client> {

    public ClientService(GenericRepository<Client> repository) {
        super(repository);
    }

    public Client partialUpdate(Long id, Client client) {
        Client clientFromDB = super.findById(id);
        clientFromDB.setName(client.getName() == null ? clientFromDB.getName() : client.getName());
        clientFromDB.setSurname(client.getSurname() == null ? clientFromDB.getSurname() : client.getSurname());
        return super.add(client);
    }

}
