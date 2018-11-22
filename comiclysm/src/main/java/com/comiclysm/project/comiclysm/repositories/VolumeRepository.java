package com.comiclysm.project.comiclysm.repositories;

import com.comiclysm.project.comiclysm.models.Volume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeRepository extends CrudRepository<Volume, Integer> {
}
