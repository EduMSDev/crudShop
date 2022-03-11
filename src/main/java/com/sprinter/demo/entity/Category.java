package com.sprinter.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


@Getter
@Setter
@Entity
public class Category extends GenericEntity<Category> {

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
