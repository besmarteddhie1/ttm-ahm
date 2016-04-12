package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxTtmLocationType;

@Repository
public interface AhmjxTtmLocationTypeRepository extends JpaRepository<AhmjxTtmLocationType, Integer> {
	
}
