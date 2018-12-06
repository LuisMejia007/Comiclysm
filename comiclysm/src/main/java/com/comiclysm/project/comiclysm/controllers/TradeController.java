package com.comiclysm.project.comiclysm.controllers;

import com.comiclysm.project.comiclysm.models.Comic;
import com.comiclysm.project.comiclysm.models.Trade;
import com.comiclysm.project.comiclysm.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TradeController {

    @Autowired
    TradeService tradeService;
    private static final String localHost = "http://localhost:1200";

    @CrossOrigin(origins = localHost)
    @GetMapping(value = "/getComicsInTrade/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicsInTrade(@PathVariable int userId){
        return this.tradeService.getAllComicsInTrade(userId);
    }


    @CrossOrigin(origins = localHost)
    @PostMapping(value = "addComicToTrade/{comicId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void addComicToTrade(@PathVariable int comicId) {
        Trade trade = new Trade(comicId);
        this.tradeService.putComicInTrade(trade);
    }




}
