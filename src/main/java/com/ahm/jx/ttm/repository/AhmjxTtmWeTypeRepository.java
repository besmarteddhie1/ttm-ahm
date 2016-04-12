package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxTtmWeType;

@Repository
public interface AhmjxTtmWeTypeRepository extends JpaRepository<AhmjxTtmWeType, Integer> {
	
}
