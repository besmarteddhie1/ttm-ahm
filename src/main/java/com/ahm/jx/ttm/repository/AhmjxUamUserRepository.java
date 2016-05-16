package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxUamUser;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface AhmjxUamUserRepository extends JpaRepository<AhmjxUamUser, String> {
	
	AhmjxUamUser findOneByUserName(String userName);
}
