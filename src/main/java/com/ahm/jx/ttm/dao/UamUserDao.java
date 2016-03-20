package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.UamUser;

@Repository
public interface UamUserDao extends JpaRepository<UamUser, String> {
	
	UamUser findOneByUserName(String userName);
	
}