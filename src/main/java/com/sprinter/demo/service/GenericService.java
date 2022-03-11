package com.sprinter.demo.service;

import com.sprinter.demo.entity.GenericEntity;
import com.sprinter.demo.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class GenericService<T extends GenericEntity<T>> {

    private final GenericRepository<T> genericRepository;

    public GenericService(GenericRepository<T> repository) {
        this.genericRepository = repository;
    }

    public List<T> findAll() {
        return (List<T>) genericRepository.findAll();
    }
}
