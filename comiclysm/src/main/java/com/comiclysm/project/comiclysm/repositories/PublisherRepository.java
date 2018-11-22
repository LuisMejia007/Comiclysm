package com.comiclysm.project.comiclysm.repositories;

import com.comiclysm.project.comiclysm.models.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}
