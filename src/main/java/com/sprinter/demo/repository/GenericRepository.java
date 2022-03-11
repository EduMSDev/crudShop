package com.sprinter.demo.repository;

import com.sprinter.demo.entity.GenericEntity;
import org.springframework.data.repository.CrudRepository;

public interface GenericRepository<T extends GenericEntity<T>> extends CrudRepository<T, Long> {

}
