package com.comiclysm.project.comiclysm.controllers;

import java.util.List;

import com.comiclysm.project.comiclysm.models.Comic;
import com.comiclysm.project.comiclysm.services.ComiclysmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;



@Controller
public class ComiclysmController {

    @Autowired
    ComiclysmService comiclysmService;

    public static final String ipAdd = "http://10.35.46.112:4200";
    public static final String localHostClient = "http://localhost:1200";

    // Get A Comic
    @CrossOrigin(origins = localHostClient)
    @GetMapping(value = "/comicDetails/{comic_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Comic getAComicBook(@PathVariable String comic_name) {
        return this.comiclysmService.getAComicBook(comic_name);
    }


    // Getting all Comics
    @CrossOrigin(origins = localHostClient)
    @GetMapping(value = "/getComics")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicNames() {
        return this.comiclysmService.getComic();
    }


    // Getting Comics by Name
    @CrossOrigin(origins = localHostClient)
    @GetMapping(value="/getComics/{comic_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicByName(@PathVariable String comic_name) {
        return this.comiclysmService.getComicByComicName(comic_name);
    }

    // Getting Comics by Volume Name



    // Getting Comics By Writer
    @CrossOrigin(origins = localHostClient)
    @GetMapping(value="/getComicsByWriter/{writer_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicsByWriter(@PathVariable String writer_name) {
        return this.comiclysmService.getComicsByWriter(writer_name);
    }

    // Getting Comics by Artist
    @CrossOrigin(origins = localHostClient)
    @GetMapping(value="/getComicsByArtist/{artist_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicsByArtist(@PathVariable String artist_name) {
        return this.comiclysmService.getComicsByArtist(artist_name);
    }



    @CrossOrigin(origins = localHostClient)
    @GetMapping(value="/getFeaturedComics")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getFeaturedComics() {
        return this.comiclysmService.getFeaturedComics();
    }


    @CrossOrigin(origins = localHostClient)
    @GetMapping(value ="/showComics/page={pageNum}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Page<Comic> showComics(@PathVariable int pageNum) {
        return this.comiclysmService.showPage(pageNum);
    }


    @CrossOrigin(origins = localHostClient)
    @GetMapping(value ="/showComicsByName/{name}/page={pageNum}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Page<Comic> showComicsByName(@PathVariable String name, @PathVariable int pageNum) {
        System.out.println("Filter By Comic Name: " + name);

        Page<Comic> bullshit = this.comiclysmService.showPagesWithComicName(name, pageNum);
        System.out.println("********TOTAL ELEMENTS: " + bullshit.getTotalElements());
        System.out.println("********TOTAL Pages: " + bullshit.getTotalElements());
        if(bullshit.getTotalElements() != 0) {
            for(Comic comic: bullshit) {
                System.out.println("Comic Name: "  + comic.getComicName());
            }
        }
        return this.comiclysmService.showPagesWithComicName(name, pageNum);
    }

    @CrossOrigin(origins = localHostClient)
    @GetMapping(value ="/showComicsByWriter/{writer}/page={pageNum}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Page<Comic> showComicsByWriter(@PathVariable String writer, @PathVariable int pageNum) {
        System.out.println("Filter By Writer: " + writer);
        Page<Comic> bullshit = this.comiclysmService.showPagesWithComicWriter(writer, pageNum);
        System.out.println("********TOTAL ELEMENTS: " + bullshit.getTotalElements());
        System.out.println("********TOTAL Pages: " + bullshit.getTotalElements());
        if(bullshit.getTotalElements() != 0) {
            for(Comic comic: bullshit) {
                System.out.println("Comic Name: "  + comic.getComicName());
            }
        }
        return this.comiclysmService.showPagesWithComicWriter(writer, pageNum);
    }

    @CrossOrigin(origins = localHostClient)
    @GetMapping(value ="/showComicsByArtist/{artist}/page={pageNum}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Page<Comic> showComicsByArtist(@PathVariable String artist, @PathVariable int pageNum) {
        System.out.println("Filter By Comic Artist: " + artist);
        Page<Comic> bullshit = this.comiclysmService.showPagesWithComicArtist(artist, pageNum);
        System.out.println("********TOTAL ELEMENTS: " + bullshit.getTotalElements());
        System.out.println("********TOTAL Pages: " + bullshit.getTotalElements());
        if(bullshit.getTotalElements() != 0) {
            for(Comic comic: bullshit) {
                System.out.println("Comic Name: "  + comic.getComicName());
            }
        }
        return this.comiclysmService.showPagesWithComicArtist(artist, pageNum);
    }

    @CrossOrigin(origins = localHostClient)
    @GetMapping(value ="/showComicsByDate/{date}/page={pageNum}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Page<Comic> showComicsByDate(@PathVariable String date, @PathVariable int pageNum) {
        Page<Comic> bullshit = this.comiclysmService.showPagesWithComicDate(date, pageNum);
        System.out.println("********TOTAL ELEMENTS: " + bullshit.getTotalElements());
        System.out.println("********TOTAL Pages: " + bullshit.getTotalElements());
        if(bullshit.getTotalElements() != 0) {
            for(Comic comic: bullshit) {
                System.out.println("Comic Name: "  + comic.getComicName());
            }
        }
        return this.comiclysmService.showPagesWithComicDate(date, pageNum);
    }


    // Updating a Comic's Inventory Id:
    @CrossOrigin(origins = localHostClient)
    @PutMapping(value = "/addComicToInventory/{inventoryId}/{comicId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void addComicToInventory(@PathVariable int inventoryId, @PathVariable int comicId){
        this.comiclysmService.updateComicInventoryId(comicId, inventoryId);
    }



    // Getting Comics From a User's Inventory
    @CrossOrigin(origins = localHostClient)
    @GetMapping(value = "/getComicsFromInventory/inventory={inventoryId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicsFromInventory(@PathVariable int inventoryId){
        return this.comiclysmService.getComicsFromInventory(inventoryId);
    }


    // Getting a Comic by Inventory Id
    @CrossOrigin(origins = localHostClient)
    @GetMapping(value = "/getComicByInventoryId/inventory={inventoryId}/comic={comicId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Comic getComicByInventoryId(@PathVariable int inventoryId, @PathVariable int comicId){
        return this.comiclysmService.getComicByInventoryId(inventoryId, comicId);
    }


    // Getting Comics From a User's Inventory
    @CrossOrigin(origins = localHostClient)
    @GetMapping(value = "/getComicsFromYourInventories/user={userId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicsFromYourInventories(@PathVariable int userId){
        return this.comiclysmService.getComicsFromYourInventory(userId);
    }
}
