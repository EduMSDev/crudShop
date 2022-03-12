package com.sprinter.demo.controller;

import com.sprinter.demo.model.Product;
import com.sprinter.demo.repository.GenericRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/products")
@RestController
public class ProductController extends GenericController<Product> {

    protected ProductController(GenericRepository<Product> repository) {
        super(repository);
    }

}
