package com.ahm.jx.ttm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahm.jx.ttm.model.AhmjxmstPartyCategory;
import com.ahm.jx.ttm.model.AhmjxmstPartyCategoryType;
import com.ahm.jx.ttm.repository.AhmjxmstPartyCategoryRepository;
import com.ahm.jx.ttm.repository.AhmjxmstPartyCategoryTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxmstProductCategoryRepository;

@Controller
@RequestMapping(value="/ttm001")
public class Ahmjxttm001Controller {
	
	@Autowired
	AhmjxmstPartyCategoryRepository partyCategoryRepo;
	
	@Autowired
	AhmjxmstPartyCategoryTypeRepository partyCategoryTypeRepo;	
	
	@Autowired
	AhmjxmstProductCategoryRepository productCategoryRepo;
	
	@RequestMapping(value="sf", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public List<AhmjxmstPartyCategoryType> getSalesForce() {
		List<AhmjxmstPartyCategoryType> d = partyCategoryTypeRepo.findByParentCategoryType(AhmjxmstPartyCategoryType.TYPE_SALES_FORCE);
		for (AhmjxmstPartyCategoryType a: d) a.getCategories().size();
		return d;
	}
	
	@RequestMapping(value="sf", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AhmjxmstPartyCategory setSalesForce(AhmjxmstPartyCategory entity) {
		return partyCategoryRepo.save(entity);
	}	
	
}
