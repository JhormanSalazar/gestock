package com.gestock.gestock.persistence.repository;

import com.gestock.gestock.persistence.entity.InventoryProductEntity;
import com.gestock.gestock.persistence.entity.InventoryProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryProductRepository extends JpaRepository<InventoryProductEntity, InventoryProductId> {
    @Modifying
    @Query("UPDATE InventoryProductEntity ip SET ip.isActive = false WHERE  ip.inventoryId = :iId AND ip.productId = :pId")
    void softDelete(@Param("inventoryId") Integer iId, @Param("productId") Integer pId);

    List<InventoryProductEntity> findByInventoryId(Integer inventoryId);
    List<InventoryProductEntity> findByProductId(Integer productId);
    void deleteByInventoryIdAndProductId(Integer inventoryId, Integer productId);

    // Consulta para productos con bajo stock (ejemplo)
    List<InventoryProductEntity> findByInventoryIdAndProductQuantityLessThan(Integer inventoryId, Integer minQuantity);
}
