package com.gestock.gestock.persistence.repository;

import com.gestock.gestock.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    @Modifying
    @Query("UPDATE CategoryEntity c SET c.isActive = false WHERE c.categoryId = :id")
    void softDelete(@Param("id") Integer id);

    List<CategoryEntity> findByIsActiveTrue();
    CategoryEntity findByName(String name);
}
