package com.gestock.gestock.persistence.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InventoryProductId implements Serializable {
    private Integer inventoryId;
    private Integer productId;
}
