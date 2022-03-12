package com.sprinter.demo.controller;

import com.sprinter.demo.model.Category;
import com.sprinter.demo.repository.GenericRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/categories")
@RestController
public class CategoryController extends GenericController<Category> {

    protected CategoryController(GenericRepository<Category> repository) {
        super(repository);
    }

}
