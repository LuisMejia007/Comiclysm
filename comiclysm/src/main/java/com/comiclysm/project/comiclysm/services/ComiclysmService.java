package com.comiclysm.project.comiclysm.services;

import com.comiclysm.project.comiclysm.models.Comic;
import com.comiclysm.project.comiclysm.repositories.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComiclysmService {


    @Autowired
   private ComicRepository comicRepository;


    public List<Comic> getComic() {
        List<Comic> comics = new ArrayList<>();
        comicRepository.findAll().forEach(comics::add);
        return comics;
    }

    public List<Comic> getComicByComicName(String comic_name) {
        comic_name = comic_name.replace("_", " ");
       return this.comicRepository.findAllByComicNameLikeIgnoreCase('%' + comic_name + '%');
    }

    public List<Comic> testComicByName(String comicName) {
        return this.comicRepository.findByComicName('%' + comicName + '%');
    }

//    public List<Comic> getComicsByVolumeName(String volumeName) {
//        volumeName = volumeName.replace("_", " ");
//        return this.comicRepository.findAllByComicVolumeNameLikeIgnoreCase('%' + volumeName + '%');
//    }

    public List<Comic> getComicsByWriter(String comicWriter) {
        comicWriter = comicWriter.replace("_", " ");
        return this.comicRepository.findAllByComicWriterLikeIgnoreCase('%' + comicWriter + '%');
    }

    public List<Comic> getComicsByArtist(String comicArtist) {
        comicArtist = comicArtist.replace("_", " ");
        return this.comicRepository.findAllByComicArtistLikeIgnoreCase('%' + comicArtist + '%');
    }


    public List<Comic> getFeaturedComics() {
        return this.comicRepository.getFeaturedComics(new PageRequest(0,10, Sort.Direction.ASC, "comicName"));
    }

   public Page<Comic> showPage(@RequestParam(defaultValue = "0") int page){
        return this.comicRepository.findAll(new PageRequest(page, 30));
   }

   public Page<Comic> showPagesWithComicName(@RequestParam String name, @RequestParam(defaultValue = "0") int page) {
        return this.comicRepository.getComicsByComicNameLike(name, new PageRequest(page, 30));
   }

   public Page<Comic> showPagesWithComicWriter(@RequestParam String writer, @RequestParam(defaultValue = "0") int page) {
        return this.comicRepository.findAllByComicWriter(writer, new PageRequest(page, 30));
   }

   public Page<Comic> showPagesWithComicArtist(@RequestParam String artist, @RequestParam(defaultValue = "0") int page) {
        return this.comicRepository.findAllByComicArtist(artist, new PageRequest(page, 30));
   }

    public Page<Comic> showPagesWithComicDate(@RequestParam String date, @RequestParam(defaultValue = "0") int page) {
        return this.comicRepository.findAllByComicPublicationDate(date, new PageRequest(page, 30));
    }


    public Comic getAComicBook(@RequestParam String comicName) {
        return this.comicRepository.findComicByComicName(comicName);
    }

    public boolean updateComicInventoryId(@RequestParam int comicId, @RequestParam int userInventoryId){
        System.out.println("Comic:" + comicId + " " + " Inventory: " + userInventoryId);
        int c = this.comicRepository.updateComicInventoryId(comicId, userInventoryId);
        System.out.println("C: " + c);
        if(c == 0) {
            return false;
        } else {
            return true;
        }
    }

    public List<Comic> getComicsFromInventory(@RequestParam int comicInventoryId){
        return this.comicRepository.getComicsFromInventory(comicInventoryId);
    }


    public Comic getComicByInventoryId(@RequestParam int inventoryId, @RequestParam int comicId){
        return this.comicRepository.getThatComicByInventoryIdAndComicId(inventoryId, comicId);
    }

    public List<Comic> getComicsFromYourInventory(@RequestParam int userId){
        return this.comicRepository.getComicsFromYourInventories(userId);
    }

}
