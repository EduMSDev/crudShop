package com.sprinter.demo.controller;

import com.sprinter.demo.entity.GenericEntity;
import com.sprinter.demo.exceptions.ResourceNotFoundException;
import com.sprinter.demo.repository.GenericRepository;
import com.sprinter.demo.service.GenericService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
public abstract class GenericController<T extends GenericEntity<T>> {

    protected final GenericService<T> service;

    protected GenericController(GenericRepository<T> repository) {
        this.service = new GenericService<T>(repository);
    }

    @GetMapping("/")
    public ResponseEntity<List<T>> findAll() {
        log.info("Tener todos");
        final List<T> allEntities = service.findAll();
        if (allEntities.isEmpty()) {
            return new ResponseEntity<>(allEntities, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allEntities, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@RequestParam @PathVariable final Long id) {
        log.info("Tener por id");
        T entity = service.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado ninguna entidad con id: " + id));
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/")
    public ResponseEntity<T> add(@RequestBody final T entity) {
        log.info("Incluyendo entidad");
        return ResponseEntity.ok(service.add(entity));
    }

    @DeleteMapping("/")
    public ResponseEntity<T> delete(@RequestParam final Long id) {
        log.info("Borrando entidad");
        service.delete(id);
        return ResponseEntity.ok(null);
    }

    //todo terminar la actualizacion total
    @PutMapping("/")
    public ResponseEntity<T> update(@RequestParam Long id, @RequestBody final T entity) {
        log.info("Actulizando entidad");
        service.delete(id);
        return ResponseEntity.ok(null);
    }

    //todo terminar la actualizacion total partial
    @PatchMapping("/")
    public ResponseEntity<T> partialUpdate(@RequestParam Long id, @RequestBody final T entity) {
        log.info("Actualizando parcialmente la entidad");
        service.delete(id);
        return ResponseEntity.ok(null);
    }
}
