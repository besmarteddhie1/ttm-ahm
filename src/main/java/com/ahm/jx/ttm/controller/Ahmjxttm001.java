package com.ahm.jx.ttm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahm.jx.ttm.dao.AhmjxmstPartyCategoryDao;
import com.ahm.jx.ttm.dao.AhmjxmstProductCategoryDao;
import com.ahm.jx.ttm.model.AhmjxmstPartyCategory;
import com.ahm.jx.ttm.model.AhmjxmstPartyCategoryType;

@RestController
@RequestMapping(value="/ttm001")
public class Ahmjxttm001 {
	
	@Autowired
	AhmjxmstPartyCategoryDao partyCategoryRepo;
	
	@Autowired
	AhmjxmstProductCategoryDao productCategoryRepo;
	
	@RequestMapping(value="sf")
	public List<AhmjxmstPartyCategory> getSalesForce() {
		return partyCategoryRepo.findByParentCategoryType(AhmjxmstPartyCategoryType.TYPE_SALES_FORCE);
	}
	
}
