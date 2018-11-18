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

    @CrossOrigin(origins = "http://localhost:1200")
    @GetMapping(value = "/getComics")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicNames() {
        return this.comiclysmService.getComic();
    }


    @CrossOrigin(origins = "http://localhost:1200")
    @GetMapping(value="/getComics/{comic_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicByName(@PathVariable String comic_name) {
        comic_name = comic_name.replace("_", " ");
        return this.comiclysmService.getComicByComicName(comic_name);
    }

    @CrossOrigin(origins = "http://localhost:1200")
    @GetMapping(value="/getComics2/{comic_name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Comic> getComicByName2(@PathVariable String comic_name) {
        return this.comiclysmService.testComicByName(comic_name);
    }
}
