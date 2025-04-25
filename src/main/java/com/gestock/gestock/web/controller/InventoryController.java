package com.gestock.gestock.web.controller;

import com.gestock.gestock.persistence.entity.InventoryEntity;
import com.gestock.gestock.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryEntity>> getAll(){
        return ResponseEntity.ok(this.inventoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryEntity> getById(@PathVariable("id") Integer id){
        InventoryEntity inventory = this.inventoryService.getById(id);
        return inventory != null
                ? ResponseEntity.ok(inventory)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<InventoryEntity>> getByUserId(@PathVariable("id") Integer id){
        List<InventoryEntity> inventories = this.inventoryService.getByUserId(id);
        return ResponseEntity.ok(inventories);
    }

    @PostMapping
    public ResponseEntity<InventoryEntity> save(@RequestBody InventoryEntity inventory){
        InventoryEntity inventorySaved = this.inventoryService.save(inventory);
        return ResponseEntity.status(HttpStatus.CREATED).body(inventorySaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        InventoryEntity inventory = this.inventoryService.getById(id);
        if (inventory != null){
            this.inventoryService.softDelete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
