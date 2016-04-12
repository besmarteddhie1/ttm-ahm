package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxUamUser;

@RepositoryRestResource(collectionResourceRel = "uamusers", path = "uamusers")
public interface UamUserDao extends JpaRepository<AhmjxUamUser, String> {
	
	AhmjxUamUser findOneByUserName(@Param("name") String userName);
	
}