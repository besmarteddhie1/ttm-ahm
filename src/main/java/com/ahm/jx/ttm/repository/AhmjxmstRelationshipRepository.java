package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxmstPartyRelationship;

@Repository
public interface AhmjxmstRelationshipRepository extends JpaRepository<AhmjxmstPartyRelationship, String> {
	
}
