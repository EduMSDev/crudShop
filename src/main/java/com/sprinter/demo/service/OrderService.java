package com.sprinter.demo.service;

import com.sprinter.demo.model.Order;
import com.sprinter.demo.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends GenericService<Order> {

    public OrderService(GenericRepository<Order> repository) {
        super(repository);
    }

    public Order partialUpdate(Long id, Order order) {
        Order orderFromDB = super.findById(id);
        orderFromDB.setName(order.getName() == null ? orderFromDB.getName() : order.getName());
        orderFromDB.setPrice(order.getPrice() == 0 ? orderFromDB.getPrice() : order.getPrice());
        return super.add(order);
    }
}
