package com.comiclysm.project.comiclysm.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    int inventoryId;

    @Column(name = "inventory_name")
    String inventoryName;

    @Column(name = "inventory_user_id")
    int inventoryUserId;


//    @ManyToOne
//    @JoinColumn(name = "inventory_user_id")
//    private User user;
//
//    @OneToMany(mappedBy = "inventory")
//    private List<Comic> comicsInInventory;

    public Inventory() {}

    public Inventory(String inventoryName, int inventoryUserId) {
        this.inventoryName = inventoryName;
        this.inventoryUserId = inventoryUserId;
    }


    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public int getInventoryUserId() {
        return inventoryUserId;
    }

    public void setInventoryUserId(int inventoryUserId) {
        this.inventoryUserId = inventoryUserId;
    }
}
