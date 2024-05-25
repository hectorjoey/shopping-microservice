package com.hectordevelopers.inventory_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String skuCode;
    private int quantity;
}
