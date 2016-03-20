package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.AhmPartner;

@Repository
@RepositoryRestResource(path = "partners")
public interface AhmPartnerDao extends JpaRepository<AhmPartner, String> {
	
	AhmPartner findOneByIdDealer(String idDealer);
	
	AhmPartner findOneByIdMainDealer(String mdCode);
	
	AhmPartner findOneByMdDealerCode(String dealerCode);
	
}