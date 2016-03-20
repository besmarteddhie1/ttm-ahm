package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.UamMenu;

@Repository
public interface UamMenuDao extends JpaRepository<UamMenu, String> {
	
	UamMenu findOneByIdMenu(String idMenu);
	
	UamMenu findOneByIdApplication(String idApplication);	
}