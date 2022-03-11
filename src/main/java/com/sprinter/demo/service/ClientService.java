package com.sprinter.demo.service;

import com.sprinter.demo.entity.Client;
import com.sprinter.demo.repository.GenericRepository;

public class ClientService extends GenericService<Client> {

    public ClientService(GenericRepository<Client> repository) {
        super(repository);
    }
}
