package com.comiclysm.project.comiclysm.repositories;

import com.comiclysm.project.comiclysm.models.Comic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

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

    @Query(value = "SELECT c FROM Comic c WHERE UPPER(c.comicName) LIKE UPPER(CONCAT('%', :myComicName, '%'))")
    Page<Comic> getComicsByComicNameLike(@Param("myComicName") String myComicName, Pageable pageable);

    @Query(value = "SELECT c FROM Comic c WHERE UPPER(c.comicWriter) LIKE UPPER(CONCAT('%', :myComicWriter, '%'))")
    Page<Comic> findAllByComicWriter(@Param("myComicWriter") String myComicWriter, Pageable pageable);

    @Query(value = "SELECT c FROM Comic c WHERE UPPER(c.comicArtist) LIKE UPPER(CONCAT('%', :myComicArtist, '%'))")
    Page<Comic> findAllByComicArtist(@Param("myComicArtist") String myComicArtist, Pageable pageable);

    @Query(value = "SELECT c FROM Comic c WHERE c.comicPublicationDate LIKE CONCAT('%', :myComicPbDate, '%')")
    Page<Comic> findAllByComicPublicationDate(@Param("myComicPbDate") String myComicPbDate, Pageable pageable);

    @Query(value = "SELECT c FROM Comic c WHERE c.comicName LIKE CONCAT('%', :myComicName, '%')")
    Comic findComicByComicName(@Param("myComicName") String myComicName);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Comic c SET c.comicInventoryId = :userInventoryId WHERE c.comicId = :comicId")
    int updateComicInventoryId(@Param("comicId") int comicId, @Param("userInventoryId") Integer userInventoryId);

    @Query(value = "SELECT c FROM Comic c WHERE c.comicInventoryId = :inventoryId")
    List<Comic> getComicsFromInventory(@Param("inventoryId") Integer inventoryId);



    @Query(value = "SELECT c FROM Comic c WHERE c.comicInventoryId = :inventoryId AND c.comicId = :myComicId")
    Comic getThatComicByInventoryIdAndComicId(@Param("inventoryId") int inventoryId, @Param("myComicId") int myComicId);



    @Query(value = "SELECT DISTINCT c FROM Comic c, Inventory i, User u WHERE c.comicInventoryId = i.inventoryId AND i.inventoryUserId = :userId")
    List<Comic> getComicsFromYourInventories(@Param("userId") int userId);

}
