package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxTtmWeType;

@RepositoryRestResource(collectionResourceRel = "wetype", path = "wetype")
public interface AhmjxTtmWeTypeRepository extends JpaRepository<AhmjxTtmWeType, Integer> {
	
}
