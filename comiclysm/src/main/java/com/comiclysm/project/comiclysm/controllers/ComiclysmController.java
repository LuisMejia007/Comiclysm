package com.comiclysm.project.comiclysm.controllers;

import java.util.List;

import com.comiclysm.project.comiclysm.models.Comic;
import com.comiclysm.project.comiclysm.services.ComiclysmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ComiclysmController {

    @Autowired
    ComiclysmService comiclysmService;

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
    @CrossOrigin(origins ="http://localhost:1200")
    @GetMapping(value="/getComicsByVol/{volume_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicsByVolumeName(@PathVariable String volume_name) {
        return this.comiclysmService.getComicsByVolumeName(volume_name);
    }


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





}
