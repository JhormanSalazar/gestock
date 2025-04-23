package com.gestock.gestock.services;

import com.gestock.gestock.persistence.entity.CategoryEntity;
import com.gestock.gestock.persistence.entity.InventoryEntity;
import com.gestock.gestock.persistence.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> findAll(){
        return this.categoryRepository.findAll();
    }

    @Transactional
    public CategoryEntity save(CategoryEntity category){
        return this.categoryRepository.save(category);
    }

    @Transactional
    public void delete(CategoryEntity category){
        this.categoryRepository.delete(category);
    }

    public List<CategoryEntity> getByIsActive(){
        return this.categoryRepository.findByIsActiveTrue();
    }

    public CategoryEntity getByName(String name){
        return this.categoryRepository.findByName(name);
    }
}
