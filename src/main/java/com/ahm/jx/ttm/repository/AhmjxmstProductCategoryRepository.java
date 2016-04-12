package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxmstProductCategory;

@Repository
public interface AhmjxmstProductCategoryRepository extends JpaRepository<AhmjxmstProductCategory, Integer> {
	
}
