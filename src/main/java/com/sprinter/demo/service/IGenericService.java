package com.sprinter.demo.service;

import com.sprinter.demo.model.GenericEntity;

import java.util.List;

public interface IGenericService<T extends GenericEntity> {

    List<T> findAll();

    T findById(Long id);

    T add(T entity);

    void delete(Long id);

    T update(Long id, T entity);

}
