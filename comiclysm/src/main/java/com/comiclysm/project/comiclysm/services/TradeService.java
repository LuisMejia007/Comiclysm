package com.comiclysm.project.comiclysm.services;


import com.comiclysm.project.comiclysm.models.Comic;
import com.comiclysm.project.comiclysm.models.Trade;
import com.comiclysm.project.comiclysm.repositories.TradeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TradeService {

    @Autowired
    TradeRepository tradeRepository;

    public List<Comic> getAllComicsInTrade(int userId){

        return this.tradeRepository.getComicsSetForTrade(userId);
    }


    public void putComicInTrade(Trade trade){
        this.tradeRepository.save(trade);
    }

}
