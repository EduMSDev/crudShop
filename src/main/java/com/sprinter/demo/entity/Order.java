package com.sprinter.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order extends GenericEntity<Order> {

    private String name;

    private String description;

    private double price;
}
