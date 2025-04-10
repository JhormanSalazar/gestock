package com.gestock.gestock.persistence.repository;

import com.gestock.gestock.persistence.entity.InventoryProductEntity;
import com.gestock.gestock.persistence.entity.InventoryProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryProductRepository extends JpaRepository<InventoryProductEntity, InventoryProductId> {
    List<InventoryProductEntity> findByInventoryId(Integer inventoryId);
    List<InventoryProductEntity> findByProductId(Integer productId);
    void deleteByInventoryIdAndProductId(Integer inventoryId, Integer productId);

    // Consulta para productos con bajo stock (ejemplo)
    List<InventoryProductEntity> findByInventoryIdAndProductQuantityLessThan(Integer inventoryId, Integer minQuantity);
}
