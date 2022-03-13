package com.sprinter.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order extends GenericEntity {

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Client client;

    @Min(value = 3, message = "El precio no puede ser inferior a 3 euros")
    private double price;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Product> products;
}

