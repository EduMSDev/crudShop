package com.sprinter.demo.controller;

import com.sprinter.demo.model.Category;
import com.sprinter.demo.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/categories")
@RestController
@Slf4j
public class CategoryController extends GenericController<Category, CategoryService> {

    protected CategoryController(CategoryService repository) {
        super(repository);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Category> partialUpdateCategory(@RequestParam @PathVariable Long id, @RequestBody @Valid Category category) {
        log.info("Actualizando parcialmente la categoria");
        return ResponseEntity.ok(this.genericService.partialUpdate(id, category));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Category> getAllProducts(@PathVariable Long id) {
        return null;
    }


}
