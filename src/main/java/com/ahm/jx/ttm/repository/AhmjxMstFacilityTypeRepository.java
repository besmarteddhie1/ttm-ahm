package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxMstFacilityType;

@RepositoryRestResource(collectionResourceRel = "facilitytype", path = "facilitytype")
public interface AhmjxMstFacilityTypeRepository extends JpaRepository<AhmjxMstFacilityType, Integer> {
	
}
