package com.sprinter.demo.controller;

import com.sprinter.demo.model.Order;
import com.sprinter.demo.repository.GenericRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/orders")
@RestController
public class OrderController extends GenericController<Order> {

    protected OrderController(GenericRepository<Order> repository) {
        super(repository);
    }

}
