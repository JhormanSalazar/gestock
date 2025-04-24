package com.gestock.gestock.web.controller;

import com.gestock.gestock.persistence.entity.CategoryEntity;
import com.gestock.gestock.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryEntity>> getAll(){
        return ResponseEntity.ok(this.categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getById(@PathVariable("id") Integer id){
        CategoryEntity category = this.categoryService.getById(id);
        return category != null
                ? ResponseEntity.ok(category)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CategoryEntity> save(@RequestBody CategoryEntity category){
        CategoryEntity savedCategory = this.categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        CategoryEntity category = this.categoryService.getById(id);
        if (category != null) {
            this.categoryService.softDelete(category.getCategoryId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<CategoryEntity>> getByIsActive(){
        List<CategoryEntity> activeCategories = this.categoryService.getByIsActive();
        return ResponseEntity.ok(activeCategories);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryEntity> getByName(@PathVariable("name") String name){
        CategoryEntity category = this.categoryService.getByName(name);
        return category != null
                ? ResponseEntity.ok(category)
                : ResponseEntity.notFound().build();
    }
}