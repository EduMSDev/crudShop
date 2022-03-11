package com.sprinter.demo.controller;

import com.sprinter.demo.entity.GenericEntity;
import com.sprinter.demo.repository.GenericRepository;
import com.sprinter.demo.service.GenericService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<T extends GenericEntity<T>> {

    protected final GenericService<T> service;

    protected GenericController(GenericRepository<T> repository) {
        this.service = new GenericService<T>(repository);
    }

    @GetMapping("/")
    public List<T> findAll() {
        System.out.println("Tener todos");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@RequestParam @PathVariable Long id) {
        System.out.println("Tener por id");
        return service.findById(id);
    }

    @PostMapping("/")
    public T add(@RequestParam Long id) {
        System.out.println("Incluyendo entidad");
        return service.findById(id);
    }

    @DeleteMapping("/")
    public void delete(@RequestParam Long id) {
        System.out.println("Borrando entidad");
        service.delete(id);
    }

    //PUT /tickets/12- Actualiza el ticket #12
    //PATCH /tickets/12- Actualiza parcialmente el ticket #12

}
