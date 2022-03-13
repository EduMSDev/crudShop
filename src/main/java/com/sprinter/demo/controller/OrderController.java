package com.sprinter.demo.controller;

import com.sprinter.demo.model.Order;
import com.sprinter.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/orders")
@RestController
@Slf4j
public class OrderController extends GenericController<Order, OrderService> {

    protected OrderController(OrderService repository) {
        super(repository);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Order> partialUpdateOrder(@RequestParam @PathVariable Long id, @RequestBody @Valid Order order) {
        log.info("Actualizando parcialmente el pedido");
        return ResponseEntity.ok(this.genericService.partialUpdate(id, order));
    }


}
