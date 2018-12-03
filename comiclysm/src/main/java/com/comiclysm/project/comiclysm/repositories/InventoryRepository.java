package com.comiclysm.project.comiclysm.repositories;

import com.comiclysm.project.comiclysm.models.Inventory;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

    @Override
    <S extends Inventory> S save(S s);

    List<Inventory> findAllByInventoryUserId(int userId);
}
