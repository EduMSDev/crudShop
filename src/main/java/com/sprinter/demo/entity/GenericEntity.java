package com.sprinter.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Date;
import java.sql.Timestamp;


@Getter
@Setter
@MappedSuperclass
public abstract class GenericEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date modifiedAt;

    private Date createdAT;
}
