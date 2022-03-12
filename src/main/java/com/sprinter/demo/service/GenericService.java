package com.sprinter.demo.service;

import com.sprinter.demo.exceptions.ResourceNotFoundException;
import com.sprinter.demo.model.GenericEntity;
import com.sprinter.demo.repository.GenericRepository;

import java.util.List;


public class GenericService<T extends GenericEntity<T>> {


    private final GenericRepository<T> genericRepository;

    public GenericService(GenericRepository<T> repository) {
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
