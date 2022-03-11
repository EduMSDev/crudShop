package com.sprinter.demo.controller;

import com.sprinter.demo.entity.GenericEntity;
import com.sprinter.demo.repository.GenericRepository;
import com.sprinter.demo.service.GenericService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
    public T add(@RequestBody T entity) {
        System.out.println("Incluyendo entidad");
        return service.add(entity);
    }

    @DeleteMapping("/")
    public void delete(@RequestParam Long id) {
        System.out.println("Borrando entidad");
        service.delete(id);
    }

    //todo terminar la actualizacion total
    @PutMapping("/")
    public void update(@RequestParam Long id, @RequestBody T entity) {
        System.out.println("Actulizando entitdad");
        service.delete(id);
    }

    //todo terminar la actualizacion total partial
    @PatchMapping("/")
    public void partialUpdate(@RequestParam Long id, @RequestBody T entity) {
        System.out.println("Actualizando parcialmente la entidad");
        service.delete(id);
    }
}
