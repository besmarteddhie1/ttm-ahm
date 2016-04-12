package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxmstProductCategory;

@RepositoryRestResource(collectionResourceRel = "productcategory", path = "productcategory")
public interface AhmjxmstProductCategoryRepository extends JpaRepository<AhmjxmstProductCategory, Integer> {
	
	List<AhmjxmstProductCategory> findByIdCategoryType(@Param("idprntcat") Integer parentCatType);
	
}
