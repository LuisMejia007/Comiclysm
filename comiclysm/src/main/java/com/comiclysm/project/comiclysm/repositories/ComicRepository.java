package com.comiclysm.project.comiclysm.repositories;

import com.comiclysm.project.comiclysm.models.Comic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepository extends CrudRepository<Comic, Integer> {

    @Query(value="SELECT comic_name FROM Comic c WHERE c.comic_name = :comicName", nativeQuery = true)
    List<Comic> findByComicName(@Param("comicName") String comicName);
    /* List<Comic> findAllByComic_volume_name(String comicVolumeName); */

    @Query(value = "SELECT DISTINCT c FROM Comic c ORDER BY c.comicWriter ASC")
   // @Query(value = "SELECT DISTINCT c FROM Comic c WHERE c.comicWriter = (SELECT DISTINCT cg.comicWriter FROM Comic cg)")
    //@Query(value = "SELECT DISTINCT c.comicWriter FROM Comic c ORDER BY c.comicWriter")
    List<Comic> getFeaturedComics(Pageable pageable);


    List<Comic> findAllByComicNameLikeIgnoreCase(String comicName);
   // List<Comic> findComicsByVolume();
   // List<Comic> findAllByComicVolumeNameLikeIgnoreCase(String comicVolumeName);
    List<Comic> findAllByComicWriterLikeIgnoreCase(String comicWriter);
    List<Comic> findAllByComicArtistLikeIgnoreCase(String comicArtist);

    Page<Comic> findAll(Pageable pageable);
}
