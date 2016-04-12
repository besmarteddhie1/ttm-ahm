package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxmstOrganization;

@Repository
public interface AhmjxmstOrganizationRepository extends JpaRepository<AhmjxmstOrganization, String> {
	
}
