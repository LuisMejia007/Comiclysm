package com.comiclysm.project.comiclysm.repositories;

import com.comiclysm.project.comiclysm.models.Comic;
import com.comiclysm.project.comiclysm.models.Trade;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TradeRepository extends CrudRepository<Trade, Integer> {

    @Override
    <S extends Trade> S save(S s);


    @Query(value = "SELECT DISTINCT c FROM Comic c, Trade t, User u, Inventory i WHERE t.tradeComicToTradeId = c.comicId  AND c.comicInventoryId = i.inventoryId AND i.inventoryUserId <> :myUserId")
    List<Comic> getComicsSetForTrade(@Param("myUserId") int myUserId);



    @Modifying
    @Transactional
    @Query(value = "UPDATE Comic c SET c.comicInventoryId = :comicNewInventoryId WHERE c.comicId = :myComicId AND c.comicInventoryId = :comicOldInventoryId")
    int switchInventoryIds(@Param("comicOldInventoryId") int comicOldInventoryId, @Param("comicNewInventoryId") int comicNewInventoryId, @Param("myComicId") int myComicId);

    // Delete a tuple from the trade table
    @Override
    void delete(Trade trade);


    @Query(value = "DELETE FROM Trade t WHERE t.tradeComicToTradeId = :comicToTradeId")
    int removeFromTrade(@Param("comicToTradeId") int comicToTradeId);
}
