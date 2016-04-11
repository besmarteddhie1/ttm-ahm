package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxmstProductCategory;

@Repository
public interface AhmjxmstProductCategoryDao extends JpaRepository<AhmjxmstProductCategory, Integer> {

}
