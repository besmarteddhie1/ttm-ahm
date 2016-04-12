package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxmstPartyRelationship;

@RepositoryRestResource(collectionResourceRel = "partyrelationship", path = "partyrelationship")
public interface AhmjxmstRelationshipRepository extends JpaRepository<AhmjxmstPartyRelationship, String> {
	
}
