package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxUamPartner;

@Repository
@RepositoryRestResource(path = "ahmpartners")
public interface AhmjxUamPartnerDao extends JpaRepository<AhmjxUamPartner, String> {
	
	AhmjxUamPartner findOneByIdDealer(@Param("iddealer") String idDealer);
	
	AhmjxUamPartner findOneByIdMainDealer(@Param("idmd") String mdCode);
	
	AhmjxUamPartner findOneByMdDealerCode(@Param("dealercode") String dealerCode);
	
}