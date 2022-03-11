package com.sprinter.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Getter
@Setter
@Entity
public class Product extends GenericEntity<Product> {

    private String name;

    @ManyToOne
    private Category category;

}
