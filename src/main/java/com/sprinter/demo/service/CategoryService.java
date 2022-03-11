package com.sprinter.demo.service;

import com.sprinter.demo.entity.Category;
import com.sprinter.demo.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends GenericService<Category> {

    public CategoryService(GenericRepository<Category> repository) {
        super(repository);
    }
}
