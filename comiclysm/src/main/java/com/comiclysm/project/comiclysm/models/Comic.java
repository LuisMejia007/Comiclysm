package com.comiclysm.project.comiclysm.models;



import javax.persistence.*;

@Entity
@Table(name = "comic")
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int comic_id;

    @Column(name = "comic_name")
    String comic_name;
    @Column(name = "comic_writer")
    String comic_writer;
    @Column(name = "comic_artist")
    String comic_artist;
    @Column(name = "comic_publication_date")
    String comic_publication_date;
    @Column(name = "comic_cover_img")
    String comic_cover_img;
    @Column(name = "comic_volume_name")
    String comic_volume_name;
    @Column(name = "comic_trade_id")
    String comic_trade_id;
    @Column(name = "comic_inventory_id")
    String comic_inventory_id;


    public Comic() { }
    public Comic(String comic_name, String comic_writer, String comic_artist, String comic_publication_date, String comic_cover_img, String comic_volume_name, String comic_trade_id, String comic_inventory_id) {
        this.comic_name = comic_name;
        this.comic_writer = comic_writer;
        this.comic_artist = comic_artist;
        this.comic_publication_date = comic_publication_date;
        this.comic_cover_img = comic_cover_img;
        this.comic_volume_name = comic_volume_name;
        this.comic_trade_id = comic_trade_id;
        this.comic_inventory_id = comic_inventory_id;
    }

    public int getComic_id() {
        return comic_id;
    }

    public void setComic_id(int comic_id) {
        this.comic_id = comic_id;
    }

    public String getComic_name() {
        return comic_name;
    }

    public void setComic_name(String comic_name) {
        this.comic_name = comic_name;
    }

    public String getComic_writer() {
        return comic_writer;
    }

    public void setComic_writer(String comic_writer) {
        this.comic_writer = comic_writer;
    }

    public String getComic_artist() {
        return comic_artist;
    }

    public void setComic_artist(String comic_artist) {
        this.comic_artist = comic_artist;
    }

    public String getComic_publication_date() {
        return comic_publication_date;
    }

    public void setComic_publication_date(String comic_publication_date) {
        this.comic_publication_date = comic_publication_date;
    }

    public String getComic_cover_img() {
        return comic_cover_img;
    }

    public void setComic_cover_img(String comic_cover_img) {
        this.comic_cover_img = comic_cover_img;
    }

    public String getComic_volume_name() {
        return comic_volume_name;
    }

    public void setComic_volume_name(String comic_volume_name) {
        this.comic_volume_name = comic_volume_name;
    }

    public String getComic_trade_id() {
        return comic_trade_id;
    }

    public void setComic_trade_id(String comic_trade_id) {
        this.comic_trade_id = comic_trade_id;
    }

    public String getComic_inventory_id() {
        return comic_inventory_id;
    }

    public void setComic_inventory_id(String comic_inventory_id) {
        this.comic_inventory_id = comic_inventory_id;
    }
}
