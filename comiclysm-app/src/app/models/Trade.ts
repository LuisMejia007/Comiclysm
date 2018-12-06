export class Trade {

    tradeId: number;
    tradeComicToTradeId: number;

    constructor() {}


    setTradeComicToTradeId( comicToTradeId: number) {
        this.tradeComicToTradeId = comicToTradeId;
    }

    getTradeId() {
        return this.tradeId;
    }
    getTradeComicToTradeId() {
        return this.tradeComicToTradeId;
    }
}
