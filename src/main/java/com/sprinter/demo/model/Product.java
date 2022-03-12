package com.sprinter.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class Product extends GenericEntity<Product> {

    private String description;

    private String sku;

    @ManyToOne
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_order",
            joinColumns = @JoinColumn(name = "prder_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Order> orders;


}
