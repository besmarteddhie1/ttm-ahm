package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxmstOrganization;

@RepositoryRestResource(collectionResourceRel = "organization", path = "organization")
public interface AhmjxmstOrganizationRepository extends JpaRepository<AhmjxmstOrganization, String> {
	
}
