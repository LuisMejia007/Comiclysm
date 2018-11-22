package com.comiclysm.project.comiclysm.services;

import com.comiclysm.project.comiclysm.models.Comic;
import com.comiclysm.project.comiclysm.repositories.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

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

    public List<Comic> getComicsByVolumeName(String volumeName) {
        volumeName = volumeName.replace("_", " ");
        return this.comicRepository.findAllByComicVolumeNameLikeIgnoreCase('%' + volumeName + '%');
    }

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





}
