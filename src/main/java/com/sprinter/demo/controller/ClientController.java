package com.sprinter.demo.controller;

import com.sprinter.demo.entity.Client;
import com.sprinter.demo.repository.GenericRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/clients")
@RestController
public class ClientController extends GenericController<Client> {

    protected ClientController(GenericRepository<Client> repository) {
        super(repository);
    }

}
