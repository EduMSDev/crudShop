package com.sprinter.demo.controller;

import com.sprinter.demo.model.Product;
import com.sprinter.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/products")
@RestController
@Slf4j
public class ProductController extends GenericController<Product, ProductService> {

    protected ProductController(ProductService repository) {
        super(repository);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> partialUpdateProduct(@RequestParam @PathVariable Long id, @RequestBody @Valid Product product) {
        log.info("Actualizando parcialmente el producto");
        return ResponseEntity.ok(this.genericService.partialUpdate(id, product));
    }

}
