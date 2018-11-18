package com.comiclysm.project.comiclysm.services;

import com.comiclysm.project.comiclysm.models.Comic;
import com.comiclysm.project.comiclysm.repositories.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

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
       return this.comicRepository.findAllByComicNameLikeIgnoreCase('%' + comic_name + '%');
    }

    public List<Comic> testComicByName(String comicName) {
        return this.comicRepository.findByComicName('%' + comicName + '%');
    }




}
