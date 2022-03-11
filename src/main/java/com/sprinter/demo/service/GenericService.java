package com.sprinter.demo.service;

import com.sprinter.demo.entity.GenericEntity;
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
        return genericRepository.findById(id).orElse(null);
    }

    public T add(T entity) {
        return genericRepository.save(entity);
    }

    public T update(T id) {
        return null;
        //return genericRepository.sa(T);
    }

    public T partialUpdate(T id) {
        return null;
        //return genericRepository.save(T);
    }

    public void delete(Long id) {
        genericRepository.deleteById(id);
    }
}
