package com.hectordevelopers.inventory_service.controller;

import com.hectordevelopers.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inventory/")
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping("/{skuCode}")
    public boolean getBySkuCode(@PathVariable("skuCode") String skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
