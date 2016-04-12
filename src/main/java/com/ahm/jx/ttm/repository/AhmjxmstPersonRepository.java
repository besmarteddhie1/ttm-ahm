package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxmstPerson;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface AhmjxmstPersonRepository extends JpaRepository<AhmjxmstPerson, String> {
	
}
