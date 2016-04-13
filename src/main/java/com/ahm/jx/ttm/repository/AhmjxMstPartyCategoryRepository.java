package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxMstPartyCategory;

@RepositoryRestResource(collectionResourceRel = "partycategory", path = "partycategory")
public interface AhmjxMstPartyCategoryRepository extends JpaRepository<AhmjxMstPartyCategory, Integer> {
		
	List<AhmjxMstPartyCategory> findByIdCategoryType(@Param("idcat") Integer idcat);
	
}
