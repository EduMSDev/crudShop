package com.sprinter.demo.service;

import com.sprinter.demo.model.Category;
import com.sprinter.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends GenericService<Category, CategoryRepository> {

    public CategoryService(CategoryRepository repository) {
        super(repository);
    }

    public Category partialUpdate(Long id, Category category) {
        Category catergoryFromDB = super.findById(id);
        catergoryFromDB.setName(category.getName() == null ? catergoryFromDB.getName() : category.getName());
        catergoryFromDB.setDescription(category.getDescription() == null ? catergoryFromDB.getDescription() : category.getDescription());
        return super.add(catergoryFromDB);
    }
}
