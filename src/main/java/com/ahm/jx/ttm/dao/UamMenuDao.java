package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.UamMenu;

@Repository
@RepositoryRestResource(path = "uammenus")
public interface UamMenuDao extends JpaRepository<UamMenu, String> {
	
	UamMenu findOneByIdMenu(String idMenu);
	
	UamMenu findOneByIdApplication(String idApplication);	
}