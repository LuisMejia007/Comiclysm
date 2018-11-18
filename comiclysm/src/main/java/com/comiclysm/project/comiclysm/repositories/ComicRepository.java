package com.comiclysm.project.comiclysm.repositories;

import com.comiclysm.project.comiclysm.models.Comic;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepository extends CrudRepository<Comic, Integer> {

}
