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

}
