package com.sprinter.demo.service;

import com.sprinter.demo.exceptions.ResourceNotFoundException;
import com.sprinter.demo.model.GenericEntity;
import com.sprinter.demo.repository.GenericRepository;

import java.util.List;


/**
 Permite usar la  potencia de la herencia
 * y asi evitar la duplicidad de codigo. Se
 * encarga de unificar los principales metodos del
 * CRUD en una sola clase. Se encarga de manejar toda
 * la logica de la aplicacion
 * @param <T> Entidad que se quiere usar
 * @param <R> Repositorio que se quiere usar.
 */
public class GenericService<T extends GenericEntity, R extends GenericRepository<T>> implements IGenericService<T> {

    protected R genericRepository;

    public GenericService(R repository) {
        this.genericRepository = repository;
    }

    public List<T> findAll() {
        return (List<T>) genericRepository.findAll();
    }

    public T findById(Long id) {
        return genericRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado ninguna entidad con id: " + id));
    }

    public T add(T entity) {
        return genericRepository.save(entity);
    }

    public T update(Long id, T entity) {
        T entityFromDB = this.findById(id);
        entity.setId(entityFromDB.getId());
        return genericRepository.save(entity);
    }

    public void delete(Long id) {
        genericRepository.deleteById(id);
    }

}
