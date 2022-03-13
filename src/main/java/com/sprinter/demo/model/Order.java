package com.sprinter.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order extends GenericEntity {

    @JsonBackReference
    @NotNull(message = "El campo cliente no puede estar vacio")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Client client;

    @Min(value = 3, message = "El precio no puede ser inferior a 3 euros")
    private double price;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Product> products;
}

