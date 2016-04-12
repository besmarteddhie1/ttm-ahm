package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxmstProductCategoryType;

@RepositoryRestResource(collectionResourceRel = "productcategorytype", path = "productcategorytype")
public interface AhmjxmstProductCategoryTypeRepository extends JpaRepository<AhmjxmstProductCategoryType, Integer> {
	
	List<AhmjxmstProductCategoryType> findByParentCategoryType(@Param("idprntcat") Integer parentCatType);

}
