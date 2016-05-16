package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxTtmPartnerCalendar;

@RepositoryRestResource(collectionResourceRel = "partnerCalendar", path = "partnerCalendar")
public interface AhmjxTtmPartnerCalendarRepository extends JpaRepository<AhmjxTtmPartnerCalendar, String> {
	
//	
	
}
