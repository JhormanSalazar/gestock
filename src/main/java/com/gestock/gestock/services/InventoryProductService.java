package com.gestock.gestock.services;

import com.gestock.gestock.persistence.entity.InventoryEntity;
import com.gestock.gestock.persistence.entity.InventoryProductEntity;
import com.gestock.gestock.persistence.repository.InventoryProductRepository;
import com.gestock.gestock.persistence.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryProductService {
    private final InventoryProductRepository inventoryProductRepository;

    @Autowired
    public InventoryProductService(InventoryProductRepository inventoryProductRepository){
        this.inventoryProductRepository = inventoryProductRepository;
    }

    public List<InventoryProductEntity> findAll(){
        return this.inventoryProductRepository.findAll();
    }

    @Transactional
    public InventoryProductEntity save(InventoryProductEntity inventoryProduct){
        return this.inventoryProductRepository.save(inventoryProduct);
    }

    @Transactional
    public void delete(InventoryProductEntity inventoryProduct){
        this.inventoryProductRepository.delete(inventoryProduct);
    }

    public  List<InventoryProductEntity> getByInventoryId(Integer inventoryId){
        return this.inventoryProductRepository.findByInventoryId(inventoryId);
    }

    public List<InventoryProductEntity> getByProductId(Integer productId){
        return this.inventoryProductRepository.findByProductId(productId);
    }

    @Transactional
    public void deleteByInventoryIdAndProductId(Integer inventoryId, Integer productId){
        this.inventoryProductRepository.deleteByInventoryIdAndProductId(inventoryId, productId);
    }

    public List<InventoryProductEntity> getByInventoryIdAndProductQuantityLessThan(Integer inventoryId, Integer minQuantity){
        return this.inventoryProductRepository.findByInventoryIdAndProductQuantityLessThan(inventoryId, minQuantity);
    }
}
