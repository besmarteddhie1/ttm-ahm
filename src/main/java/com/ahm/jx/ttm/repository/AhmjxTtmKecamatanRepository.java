package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxttmKecamatan;

@RepositoryRestResource(collectionResourceRel = "kecamatan", path = "kecamatan")
public interface AhmjxTtmKecamatanRepository extends JpaRepository<AhmjxttmKecamatan, Integer> {

}
