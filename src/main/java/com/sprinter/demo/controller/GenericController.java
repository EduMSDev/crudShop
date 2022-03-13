package com.sprinter.demo.controller;

import com.sprinter.demo.model.GenericEntity;
import com.sprinter.demo.service.IGenericService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Permite usar la  potencia de la herencia
 * y asi evitar la duplicidad de codigo. Se
 * encarga de unificar los principales metodos del
 * CRUD en una sola clase. Aqui se gestionan las comunicaciones
 * que son similares para todos los controladres de
 * la api Rest
 * @param <T> Entidad con la que se quiere trabajar
 * @param <R> Servicio con el que se quiere trabajar
 *
 */
@Slf4j
public abstract class GenericController<T extends GenericEntity, R extends IGenericService<T>> {

    public final R genericService;

    @Autowired
    public GenericController(R service) {
        this.genericService = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<T>> findAll() {
        log.info("Tener todos ");
        final List<T> allEntities = genericService.findAll();
        if (allEntities.isEmpty()) {
            return new ResponseEntity<>(allEntities, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allEntities, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@RequestParam @PathVariable final Long id) {
        log.info("Tener por id");
        return ResponseEntity.ok(genericService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<T> add(@RequestBody @Valid final T entity) {
        log.info("Incluyendo entidad");
        return new ResponseEntity<>(genericService.add(entity), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<T> delete(@RequestParam @PathVariable final Long id) {
        log.info("Borrando entidad");
        genericService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestParam @PathVariable Long id, @RequestBody @Valid final T entity) {
        log.info("Actulizando entidad");
        return ResponseEntity.ok(genericService.update(id, entity));
    }
}
