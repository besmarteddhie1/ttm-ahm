package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxMstOrganization;

@RepositoryRestResource(collectionResourceRel = "organization", path = "organization")
public interface AhmjxMstOrganizationRepository extends JpaRepository<AhmjxMstOrganization, String> {
	
}
