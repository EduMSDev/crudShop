package com.sprinter.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product extends GenericEntity {

    private String description;

    @NotBlank(message = "El campo sku no puede estar vacio")
    private String sku;

    @ManyToOne
    @JsonBackReference
    @NotNull(message = "El campo categoria es obligatorio")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_order",
            joinColumns = @JoinColumn(name = "prder_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Order> orders;


}
