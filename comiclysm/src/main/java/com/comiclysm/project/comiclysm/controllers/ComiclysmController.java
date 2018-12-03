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


    // Get A Comic
    @CrossOrigin(origins = "http://localhost:1200")
    @GetMapping(value = "/comicDetails/{comic_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Comic getAComicBook(@PathVariable String comic_name) {
        return this.comiclysmService.getAComicBook(comic_name);
    }


    // Getting all Comics
    @CrossOrigin(origins = "http://localhost:1200")
    @GetMapping(value = "/getComics")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicNames() {
        return this.comiclysmService.getComic();
    }


    // Getting Comics by Name
    @CrossOrigin(origins = "http://localhost:1200")
    @GetMapping(value="/getComics/{comic_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicByName(@PathVariable String comic_name) {
        return this.comiclysmService.getComicByComicName(comic_name);
    }

    // Getting Comics by Volume Name



    // Getting Comics By Writer
    @CrossOrigin(origins = "http://localhost:1200")
    @GetMapping(value="/getComicsByWriter/{writer_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicsByWriter(@PathVariable String writer_name) {
        return this.comiclysmService.getComicsByWriter(writer_name);
    }

    // Getting Comics by Artist
    @CrossOrigin(origins = "http://localhost:1200")
    @GetMapping(value="/getComicsByArtist/{artist_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicsByArtist(@PathVariable String artist_name) {
        return this.comiclysmService.getComicsByArtist(artist_name);
    }



    @CrossOrigin(origins = "http://localhost:1200")
    @GetMapping(value="/getFeaturedComics")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getFeaturedComics() {
        return this.comiclysmService.getFeaturedComics();
    }


    @CrossOrigin(origins = "http://localhost:1200")
    @GetMapping(value ="/showComics/page={pageNum}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Page<Comic> showComics(@PathVariable int pageNum) {
        return this.comiclysmService.showPage(pageNum);
    }


    @CrossOrigin(origins = "http://localhost:1200")
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

    @CrossOrigin(origins = "http://localhost:1200")
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

    @CrossOrigin(origins = "http://localhost:1200")
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

    @CrossOrigin(origins = "http://localhost:1200")
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
}
