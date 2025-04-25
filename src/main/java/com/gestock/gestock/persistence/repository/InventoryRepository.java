package com.gestock.gestock.persistence.repository;

import com.gestock.gestock.persistence.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
    @Modifying
    @Query("UPDATE InventoryEntity i SET i.isActive = false WHERE i.inventoryId = :id")
    void softDelete(@Param("id") Integer id);

    List<InventoryEntity> findByUser_UserId(Integer userId);
}
