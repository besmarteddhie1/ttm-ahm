package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.ahm.jx.ttm.model.AhmjxmstPartyCategoryType;

@RepositoryRestResource(collectionResourceRel = "partycategorytype", path = "partycategorytype")
public interface AhmjxmstPartyCategoryTypeRepository extends JpaRepository<AhmjxmstPartyCategoryType, Integer> {
	
	List<AhmjxmstPartyCategoryType> findByParentCategoryType(@Param("idprntcat") Integer parentCatType);

}
