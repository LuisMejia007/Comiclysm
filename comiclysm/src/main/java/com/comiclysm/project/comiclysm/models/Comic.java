package com.comiclysm.project.comiclysm.models;



import javax.persistence.*;

@Entity
@Table(name = "comic")
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comic_id")
    int comicId;

    @Column(name = "comic_name")
    String comicName;
    @Column(name = "comic_writer")
    String comicWriter;
    @Column(name = "comic_artist")
    String comicArtist;
    @Column(name = "comic_publication_date")
    String comicPublicationDate;
    @Column(name = "comic_cover_img")
    String comicCoverImg;
    @Column(name = "comic_volume_name")
    String comicVolumeName;
    @Column(name = "comic_trade_id")
    String comicTradeId;
    @Column(name = "comic_inventory_id")
    String comicInventoryId;


    public Comic() { }

    public Comic(String comicName, String comicWriter, String comicArtist, String comicPublicationDate, String comicCoverImg, String comicVolumeName, String comicTradeId, String comicInventoryId) {
        this.comicName = comicName;
        this.comicWriter = comicWriter;
        this.comicArtist = comicArtist;
        this.comicPublicationDate = comicPublicationDate;
        this.comicCoverImg = comicCoverImg;
        this.comicVolumeName = comicVolumeName;
        this.comicTradeId = comicTradeId;
        this.comicInventoryId = comicInventoryId;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public String getComicWriter() {
        return comicWriter;
    }

    public void setComicWriter(String comicWriter) {
        this.comicWriter = comicWriter;
    }

    public String getComicArtist() {
        return comicArtist;
    }

    public void setComicArtist(String comicArtist) {
        this.comicArtist = comicArtist;
    }

    public String getComicPublicationDate() {
        return comicPublicationDate;
    }

    public void setComicPublicationDate(String comicPublicationDate) {
        this.comicPublicationDate = comicPublicationDate;
    }

    public String getComicCoverImg() {
        return comicCoverImg;
    }

    public void setComicCoverImg(String comicCoverImg) {
        this.comicCoverImg = comicCoverImg;
    }

    public String getComicVolumeName() {
        return comicVolumeName;
    }

    public void setComicVolumeName(String comicVolumeName) {
        this.comicVolumeName = comicVolumeName;
    }

    public String getComicTradeId() {
        return comicTradeId;
    }

    public void setComicTradeId(String comicTradeId) {
        this.comicTradeId = comicTradeId;
    }

    public String getComicInventoryId() {
        return comicInventoryId;
    }

    public void setComicInventoryId(String comicInventoryId) {
        this.comicInventoryId = comicInventoryId;
    }
}
