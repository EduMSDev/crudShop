package com.sprinter.demo.service;

import com.sprinter.demo.model.Category;
import com.sprinter.demo.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends GenericService<Category> {

    public CategoryService(GenericRepository<Category> repository) {
        super(repository);
    }

    public Category partialUpdate(Long id, Category catego) {
        Category catergoryFromDB = super.findById(id);
        catergoryFromDB.setName(catego.getName() == null ? catergoryFromDB.getName() : catego.getName());
        catergoryFromDB.setDescription(catego.getDescription() == null ? catergoryFromDB.getDescription() : catego.getDescription());
        return super.add(catego);
    }
}
