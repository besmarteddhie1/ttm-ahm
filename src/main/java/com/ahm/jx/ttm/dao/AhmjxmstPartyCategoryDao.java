package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.model.AhmjxmstPartyCategory;

@Repository
public interface AhmjxmstPartyCategoryDao extends JpaRepository<AhmjxmstPartyCategory, Integer> {

}
