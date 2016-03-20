package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.AhmPartner;

@Repository
@RepositoryRestResource(path = "partners")
public interface AhmPartnerDao extends JpaRepository<AhmPartner, String> {
	
	AhmPartner findOneByIdDealer(@Param("iddealer") String idDealer);
	
	AhmPartner findOneByIdMainDealer(@Param("idmd") String mdCode);
	
	AhmPartner findOneByMdDealerCode(@Param("dealercode") String dealerCode);
	
}