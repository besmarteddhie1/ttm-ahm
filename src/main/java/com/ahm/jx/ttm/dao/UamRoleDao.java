package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.UamRole;

@Repository
@RepositoryRestResource(path = "uamroles")
public interface UamRoleDao extends JpaRepository<UamRole, String> {
	
	UamRole findOneByIdRole(@Param("role") String idRole);
	
	UamRole findOneByName(@Param("name") String name);
	
}