package com.ahm.jx.ttm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxmstPartyCategory;

@Repository
public interface AhmjxmstPartyCategoryDao extends JpaRepository<AhmjxmstPartyCategory, Integer> {
	
	List<AhmjxmstPartyCategory> findByParentCategoryType(@Param("idprntcat") Integer parentCatType);

}
