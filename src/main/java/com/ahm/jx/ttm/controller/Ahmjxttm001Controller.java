package com.ahm.jx.ttm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahm.jx.ttm.dao.AhmjxmstPartyCategoryDao;
import com.ahm.jx.ttm.dao.AhmjxmstPartyCategoryTypeDao;
import com.ahm.jx.ttm.dao.AhmjxmstProductCategoryDao;
import com.ahm.jx.ttm.model.AhmjxmstPartyCategory;
import com.ahm.jx.ttm.model.AhmjxmstPartyCategoryType;

@Controller
@RequestMapping(value="/ttm001")
public class Ahmjxttm001Controller {
	
	@Autowired
	AhmjxmstPartyCategoryDao partyCategoryRepo;
	
	@Autowired
	AhmjxmstPartyCategoryTypeDao partyCategoryTypeRepo;	
	
	@Autowired
	AhmjxmstProductCategoryDao productCategoryRepo;
	
	@RequestMapping(value="sf", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AhmjxmstPartyCategoryType> getSalesForce() {
		System.out.println("TEST");
		return partyCategoryTypeRepo.queryByParentCategory(AhmjxmstPartyCategoryType.TYPE_SALES_FORCE);
	}
	
	@RequestMapping(value="sf", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AhmjxmstPartyCategory setSalesForce(AhmjxmstPartyCategory entity) {
		return partyCategoryRepo.save(entity);
	}	
	
}
