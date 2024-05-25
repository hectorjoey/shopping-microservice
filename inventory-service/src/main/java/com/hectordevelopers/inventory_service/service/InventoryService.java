package com.hectordevelopers.inventory_service.service;

import com.hectordevelopers.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
         return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

}
