package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.UamMenu;

@Repository
@RepositoryRestResource(path = "v1/uammenus")
public interface UamMenuDao extends JpaRepository<UamMenu, String> {
	
	UamMenu findOneByIdMenu(@Param("idmenu") String idMenu);
	
	UamMenu findOneByIdApplication(@Param("idapps") String idApplication);	
}