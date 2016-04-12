package com.ahm.jx.ttm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxUamRole;

@Repository
@RepositoryRestResource(path = "uamroles")
public interface UamRoleDao extends JpaRepository<AhmjxUamRole, String> {
	
	AhmjxUamRole findOneByIdRole(@Param("role") String idRole);
	
	AhmjxUamRole findOneByName(@Param("name") String name);
	
	List<AhmjxUamRole> findByName(@Param("name") String name);
	
}