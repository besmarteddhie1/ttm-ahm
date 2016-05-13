package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxttmKabupaten;

@RepositoryRestResource(collectionResourceRel = "kabupaten", path = "kabupaten")
public interface AhmjxTtmKabupatenRepository extends JpaRepository<AhmjxttmKabupaten, Integer> {

}
