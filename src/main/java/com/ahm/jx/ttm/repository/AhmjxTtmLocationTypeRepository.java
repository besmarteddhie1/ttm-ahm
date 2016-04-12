package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxTtmLocationType;

@RepositoryRestResource(collectionResourceRel = "locationtype", path = "locationtype")
public interface AhmjxTtmLocationTypeRepository extends JpaRepository<AhmjxTtmLocationType, Integer> {
	
}
