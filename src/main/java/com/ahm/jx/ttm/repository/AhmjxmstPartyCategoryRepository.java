package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxmstPartyCategory;

@RepositoryRestResource(collectionResourceRel = "partycategory", path = "partycategory")
public interface AhmjxmstPartyCategoryRepository extends JpaRepository<AhmjxmstPartyCategory, Integer> {
	
	@Query("select r from AhmjxmstPartyCategory r where r.categoryType.idCategoryType = :idcat")
	List<AhmjxmstPartyCategory> queryByCategoryType(@Param("idcat") Integer idcat);	
	
	List<AhmjxmstPartyCategory> findByIdCategoryType(@Param("idcat") Integer idcat);
	
}
