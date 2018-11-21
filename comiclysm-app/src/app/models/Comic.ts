export class Comic {
    comicName: string;
    comicWriter: string;
    comicArtist: string;
    comicPublicationDate: string;
    comicCoverImg: string;
    comicVolumeName: string;
    comicTradeId: number;
    comicInventoryId: number;

    constructor() {}

    getComicName(): string {
        return this.comicName;
    }

    getComicWriter(): string {
        return this.comicWriter;
    }

    getComicArtist(): string {
        return this.comicArtist;
    }

    getComicPublicationDate(): string {
        return this.comicPublicationDate;
    }

    getComicCoverImg(): string {
        return this.comicCoverImg;
    }

    getComicVolumeName(): string {
        return this.comicVolumeName;
    }

    getComicTradeId(): number {
        return this.comicTradeId;
    }

    getComicInventoryId(): number {
        return this.comicInventoryId;
    }
}
