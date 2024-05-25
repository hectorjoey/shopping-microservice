package com.hectordevelopers.inventory_service.dto;

import lombok.Data;

@Data
public class InventoryDto {
    private long id;
    private String skuCode;
    private int quantity;
}
