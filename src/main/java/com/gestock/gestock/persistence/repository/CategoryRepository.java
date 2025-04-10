package com.gestock.gestock.persistence.repository;

import com.gestock.gestock.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findByIsActiveTrue();
    CategoryEntity findByName(String name);
}
