package com.comiclysm.project.comiclysm.services;

import com.comiclysm.project.comiclysm.models.Inventory;
import com.comiclysm.project.comiclysm.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public void addInventory(Inventory inventory){
        System.out.println("Adding Inventory:" + inventory.getInventoryName());
        this.inventoryRepository.save(inventory);
    }


}
