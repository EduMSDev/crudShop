package com.sprinter.demo.repository;

import com.sprinter.demo.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GenericRepository<Product> {
}
