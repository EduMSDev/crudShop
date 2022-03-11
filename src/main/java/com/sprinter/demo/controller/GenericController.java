package com.sprinter.demo.controller;

import com.sprinter.demo.entity.GenericEntity;
import com.sprinter.demo.repository.GenericRepository;
import com.sprinter.demo.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public abstract class GenericController<T extends GenericEntity<T>> {


    protected final GenericService<T> service;

    protected GenericController(GenericRepository<T> repository) {
        this.service = new GenericService<T>(repository);
    }

    @GetMapping("/obtenerTodo")
    public List<T> findAll() {
        System.out.println("Pasando or aqui");
        return service.findAll();
    }

}
