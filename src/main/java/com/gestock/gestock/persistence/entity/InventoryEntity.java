package com.gestock.gestock.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inventories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer inventoryId;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(length = 150, nullable = true)
    private String description;

    @Column(name = "inventory_image", length = 255)
    private String inventoryImage;

    @Builder.Default
    @Column(name = "is_active", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean isActive = true;

    // Relacion Uno a Muchos, inventories a inventories_products
    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InventoryProductEntity> inventoryProducts = new ArrayList<>();

    // Relacion Muchos a Uno, inventories a users
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
