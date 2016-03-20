package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.AhmPartner;

@Repository
public interface AhmPartnerDao extends JpaRepository<AhmPartner, String> {
	
	AhmPartner findOneByDealerCode(String dealerCode);
	
	AhmPartner findOneByAhmCode(String dealerCode);
	
	AhmPartner findOneByPartnerCode(String dealerCode);
	
}