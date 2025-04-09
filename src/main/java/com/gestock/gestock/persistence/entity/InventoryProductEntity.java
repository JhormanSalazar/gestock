package com.gestock.gestock.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventories_products")
@IdClass(InventoryProductId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryProductEntity {
    @Id
    @Column(name = "inventory_id", insertable = false, updatable = false)
    private Integer inventoryId;

    @Id
    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;

    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @Builder.Default
    @Column(name = "is_active", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean isActive = true;

    // Relación Many-to-One con Inventory
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private InventoryEntity inventory;

    // Relación Many-to-One con Product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;
}
