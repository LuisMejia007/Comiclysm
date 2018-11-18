package com.comiclysm.project.comiclysm.services;

import com.comiclysm.project.comiclysm.models.Comic;
import com.comiclysm.project.comiclysm.repositories.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("GOT HERE!!!!!!!!!!!!!!!");
        return comics;
    }




}
