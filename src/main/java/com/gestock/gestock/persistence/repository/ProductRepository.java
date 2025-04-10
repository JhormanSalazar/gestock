package com.gestock.gestock.persistence.repository;

import com.gestock.gestock.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategory_CategoryId(Integer categoryId);
    List<ProductEntity> findByNameContainingIgnoreCase(String name);
    List<ProductEntity> findByPriceLessThanEqual(Integer maxPrice);
}
