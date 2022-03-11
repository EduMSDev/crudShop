package com.sprinter.demo.controller;

import com.sprinter.demo.entity.Client;
import com.sprinter.demo.repository.GenericRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController extends GenericController<Client> {

    protected ClientController(GenericRepository<Client> repository) {
        super(repository);
    }

    @GetMapping("/obtenerTodo")
    public List<Client> findAll() {
        System.out.println("Pasando or aqui");
        return service.findAll();
    }

}
