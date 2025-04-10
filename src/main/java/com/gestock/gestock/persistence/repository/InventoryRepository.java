package com.gestock.gestock.persistence.repository;

import com.gestock.gestock.persistence.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
    List<InventoryEntity> findByUser_UserId(Integer userId);
    List<InventoryEntity> findByUser_UserIdAndIsActiveTrue(Integer userId);
}
