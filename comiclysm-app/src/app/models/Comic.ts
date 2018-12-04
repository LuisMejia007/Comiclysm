export class Comic {
    comicId: number;
    comicName: string;
    comicWriter: string;
    comicArtist: string;
    comicPublicationDate: string;
    comicCoverImg: string;
    comicVolumeName: string;


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

    getComicId(): number {
        return this.comicId;
    }

}
