package com.sprinter.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order extends GenericEntity<Order> {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Client client;

    private double price;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Product> products;
}

