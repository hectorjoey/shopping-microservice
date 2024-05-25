package com.hectordevelopers.inventory_service;

import com.hectordevelopers.inventory_service.model.Inventory;
import com.hectordevelopers.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("Iphone");
            inventory.setQuantity(25);

            Inventory inventory2 = new Inventory();
            inventory2.setSkuCode("Apple");
            inventory2.setQuantity(10);

            Inventory inventory3 = new Inventory();
            inventory3.setSkuCode("Microsoft");
            inventory3.setQuantity(5);

            Inventory inventory4 = new Inventory();
            inventory4.setSkuCode("Google");
            inventory4.setQuantity(10);


            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory2);
            inventoryRepository.save(inventory3);
            inventoryRepository.save(inventory4);
        };
    }
}