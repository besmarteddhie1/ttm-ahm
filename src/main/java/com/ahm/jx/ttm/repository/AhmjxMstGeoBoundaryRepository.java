package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxMstGeoBoundary;

@RepositoryRestResource(collectionResourceRel = "geoboundary", path = "geoboundary")
public interface AhmjxMstGeoBoundaryRepository extends JpaRepository<AhmjxMstGeoBoundary, Integer> {
	
}
