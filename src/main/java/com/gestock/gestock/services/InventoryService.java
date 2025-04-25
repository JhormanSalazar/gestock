package com.gestock.gestock.services;

import com.gestock.gestock.persistence.entity.InventoryEntity;
import com.gestock.gestock.persistence.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryEntity> getAll(){
        return this.inventoryRepository.findAll();
    }

    public InventoryEntity getById(Integer id){
        return this.inventoryRepository.findById(id).orElse(null);
    }

    @Transactional
    public InventoryEntity save(InventoryEntity inventory){
        return this.inventoryRepository.save(inventory);
    }

    @Transactional
    public void softDelete(Integer id){
        this.inventoryRepository.softDelete(id);
    }

    // Este metodo trae la lista de usuarios incluyendo los No activos.
    public List<InventoryEntity> getByUserId(Integer userId){
        return this.inventoryRepository.findByUser_UserId(userId);
    }
}
