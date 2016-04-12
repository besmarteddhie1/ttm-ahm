package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxmstPartyCategoryType;
import com.ahm.jx.ttm.model.AhmjxmstProductCategoryType;

@Repository
public interface AhmjxmstProductCategoryTypeRepository extends JpaRepository<AhmjxmstProductCategoryType, Integer> {
	
	List<AhmjxmstPartyCategoryType> findByParentCategoryType(@Param("idprntcat") Integer parentCatType);

}
