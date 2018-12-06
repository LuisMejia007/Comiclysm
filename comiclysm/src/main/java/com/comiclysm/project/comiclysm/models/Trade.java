package com.comiclysm.project.comiclysm.models;

import javax.persistence.*;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id")
    int tradeId;


    @Column(name = "trade_comic_to_trade_id")
    int tradeComicToTradeId;

    public Trade() {}

    public Trade(int tradeComicToTradeId) {
        this.tradeComicToTradeId = tradeComicToTradeId;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public int getTradeComicToTradeId() {
        return tradeComicToTradeId;
    }

    public void setTradeComicToTradeId(int tradeComicToTradeId) {
        this.tradeComicToTradeId = tradeComicToTradeId;
    }
}
