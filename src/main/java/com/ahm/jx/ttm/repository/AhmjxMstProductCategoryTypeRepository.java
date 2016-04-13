package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxMstProductCategoryType;

@RepositoryRestResource(collectionResourceRel = "productcategorytype", path = "productcategorytype")
public interface AhmjxMstProductCategoryTypeRepository extends JpaRepository<AhmjxMstProductCategoryType, Integer> {
	
	List<AhmjxMstProductCategoryType> findByParentCategoryType(@Param("idprntcat") Integer parentCatType);

}
