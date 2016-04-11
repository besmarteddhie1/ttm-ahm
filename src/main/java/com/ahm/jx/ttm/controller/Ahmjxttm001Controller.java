package com.ahm.jx.ttm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="sf", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AhmjxmstPartyCategory> getSalesForce() {
		return partyCategoryRepo.findByParentCategoryType(AhmjxmstPartyCategoryType.TYPE_SALES_FORCE);
	}
	
	@RequestMapping(value="sf", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public AhmjxmstPartyCategory setSalesForce(AhmjxmstPartyCategory entity) {
		return partyCategoryRepo.save(entity);
	}	
	
}
