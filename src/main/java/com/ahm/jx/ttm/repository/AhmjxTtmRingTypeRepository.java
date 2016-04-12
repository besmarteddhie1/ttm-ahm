package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxTtmRingType;

@RepositoryRestResource(collectionResourceRel = "ringtype", path = "ringtype")
public interface AhmjxTtmRingTypeRepository extends JpaRepository<AhmjxTtmRingType, Integer> {
	
}
