package com.ahm.jx.ttm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxmstPartyCategory;

@Repository
public interface AhmjxmstPartyCategoryDao extends JpaRepository<AhmjxmstPartyCategory, Integer> {
	
	@Query("select r from AhmjxmstPartyCategory r where r.categoryType.parentCategoryType = :idprntcat")
	List<AhmjxmstPartyCategory> queryByParentCategory(@Param("idprntcat") Integer parentCatType);

}
