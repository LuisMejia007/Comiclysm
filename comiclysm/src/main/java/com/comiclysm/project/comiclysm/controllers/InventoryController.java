package com.comiclysm.project.comiclysm.controllers;

import com.comiclysm.project.comiclysm.models.Inventory;
import com.comiclysm.project.comiclysm.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @CrossOrigin(origins = "http://localhost:1200")
    @PostMapping(value = "addInventory/{inventoryName}_{inventoryUserId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void addInventory(@PathVariable String inventoryName, @PathVariable int inventoryUserId){
        Inventory inventory = new Inventory(inventoryName, inventoryUserId);
        this.inventoryService.addInventory(inventory);
    }


   // public List<Inventory>
    
}
