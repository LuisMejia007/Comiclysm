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

//    @Column(name = "comic_volume_id")
//    int comicVolumeId;
//
//    @Column(name = "comic_inventory_id")
//    int comicInventoryId;


    @ManyToOne
    @JoinColumn(name="comic_volume_id")
    private Volume volume;

    @ManyToOne
    @JoinColumn(name= "comic_inventory_id")
    private Inventory inventory;

    public Comic() { }

    public Comic(String comicName, String comicWriter, String comicArtist, String comicPublicationDate, String comicCoverImg, String comicVolumeName, String comicTradeId, String comicInventoryId) {
        this.comicName = comicName;
        this.comicWriter = comicWriter;
        this.comicArtist = comicArtist;
        this.comicPublicationDate = comicPublicationDate;
        this.comicCoverImg = comicCoverImg;

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

//    public int getComicVolumeId() {
//        return comicVolumeId;
//    }
//
//    public void setComicVolumeId(int comicVolumeId) {
//        this.comicVolumeId = comicVolumeId;
//    }
//
//    public int getComicInventoryId() {
//        return comicInventoryId;
//    }
//
//    public void setComicInventoryId(int comicInventoryId) {
//        this.comicInventoryId = comicInventoryId;
//    }
}
