package com.sprinter.demo.service;

import com.sprinter.demo.model.Product;
import com.sprinter.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends GenericService<Product, ProductRepository> {

    public ProductService(ProductRepository repository) {
        super(repository);
    }

    public Product partialUpdate(Long id, Product product) {
        Product productFromDB = super.findById(id);
        productFromDB.setName(product.getName() == null ? productFromDB.getName() : product.getName());
        productFromDB.setSku(product.getSku() == null ? productFromDB.getSku() : product.getSku());
        return super.add(product);
    }
}
