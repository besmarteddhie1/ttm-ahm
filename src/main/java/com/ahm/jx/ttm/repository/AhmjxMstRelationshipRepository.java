package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxMstPartyRelationship;

@RepositoryRestResource(collectionResourceRel = "partyrelationship", path = "partyrelationship")
public interface AhmjxMstRelationshipRepository extends JpaRepository<AhmjxMstPartyRelationship, String> {
	
}
