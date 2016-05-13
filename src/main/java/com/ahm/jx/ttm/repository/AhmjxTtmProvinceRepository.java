package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxttmProvince;

@RepositoryRestResource(collectionResourceRel = "province", path = "province")
public interface AhmjxTtmProvinceRepository extends JpaRepository<AhmjxttmProvince, Integer> {

}
