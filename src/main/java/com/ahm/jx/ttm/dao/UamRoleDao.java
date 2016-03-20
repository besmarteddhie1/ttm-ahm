package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.UamRole;

@Repository
public interface UamRoleDao extends JpaRepository<UamRole, String> {
	
	UamRole findOneByIdRole(String idRole);
	
	UamRole findOneByName(String name);
	
}