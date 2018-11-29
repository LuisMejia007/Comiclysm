package com.comiclysm.project.comiclysm.repositories;

import com.comiclysm.project.comiclysm.models.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
}
