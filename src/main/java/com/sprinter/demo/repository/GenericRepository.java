package com.sprinter.demo.repository;

import com.sprinter.demo.model.GenericEntity;
import org.springframework.data.repository.CrudRepository;

public interface GenericRepository<T extends GenericEntity> extends CrudRepository<T, Long> {

}
