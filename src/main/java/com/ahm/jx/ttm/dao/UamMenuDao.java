package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxUamMenu;

@RepositoryRestResource(path = "uammenus")
public interface UamMenuDao extends JpaRepository<AhmjxUamMenu, String> {
	
	AhmjxUamMenu findOneByIdMenu(@Param("idmenu") String idMenu);
	
	AhmjxUamMenu findOneByIdApplication(@Param("idapps") String idApplication);	
}