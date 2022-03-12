package com.sprinter.demo.controller;

import com.sprinter.demo.entity.GenericEntity;
import com.sprinter.demo.repository.GenericRepository;
import com.sprinter.demo.service.GenericService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
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
        List<T> allEntities = service.findAll();
        if (allEntities.isEmpty()) {
            return new ResponseEntity<>(allEntities, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allEntities, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@RequestParam @PathVariable Long id) {
        log.info("Tener por id");
        T entity = service.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado ninguna entidad con id: " + id));
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<T> add(@RequestBody T entity) {
        log.info("Incluyendo entidad");
        return new ResponseEntity<>(service.add(entity), HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<T> delete(@RequestParam Long id) {
        log.info("Borrando entidad");
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    //todo terminar la actualizacion total
    @PutMapping("/")
    public ResponseEntity<T> update(@RequestParam Long id, @RequestBody T entity) {
        log.info("Actulizando entidad");
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    //todo terminar la actualizacion total partial
    @PatchMapping("/")
    public ResponseEntity<T> partialUpdate(@RequestParam Long id, @RequestBody T entity) {
        log.info("Actualizando parcialmente la entidad");
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
