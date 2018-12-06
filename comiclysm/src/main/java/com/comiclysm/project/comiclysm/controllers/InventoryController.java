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

    public static final String ipAdd = "http://10.35.46.112:4200";
    public static final String localHostClient = "http://localhost:1200";

    @CrossOrigin(origins = localHostClient)
    @PostMapping(value = "addInventory/{inventoryName}_{inventoryUserId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void addInventory(@PathVariable String inventoryName, @PathVariable int inventoryUserId){
        Inventory inventory = new Inventory(inventoryName, inventoryUserId);
        this.inventoryService.addInventory(inventory);
    }



    @CrossOrigin(origins = localHostClient)
    @GetMapping(value = "getMyInventories/{inventoryUserId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Inventory> getMyInventories(@PathVariable int inventoryUserId) {
        return this.inventoryService.getInventoriesByUserId(inventoryUserId);
    }


}
