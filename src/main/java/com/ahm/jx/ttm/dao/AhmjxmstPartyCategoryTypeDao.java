package com.ahm.jx.ttm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxmstPartyCategoryType;

@Repository
public interface AhmjxmstPartyCategoryTypeDao extends JpaRepository<AhmjxmstPartyCategoryType, Integer> {
	
	@Query("select r from AhmjxmstPartyCategoryType r where r.parentCategoryType = :idprntcat")
	List<AhmjxmstPartyCategoryType> queryByParentCategory(@Param("idprntcat") Integer parentCatType);

}
