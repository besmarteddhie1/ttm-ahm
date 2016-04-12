package com.ahm.jx.ttm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahm.jx.ttm.model.AhmjxTtmLocationType;
import com.ahm.jx.ttm.model.AhmjxTtmRingType;
import com.ahm.jx.ttm.model.AhmjxTtmWeType;
import com.ahm.jx.ttm.model.AhmjxmstPartyCategory;
import com.ahm.jx.ttm.model.AhmjxmstPartyCategoryType;
import com.ahm.jx.ttm.model.AhmjxmstProductCategory;
import com.ahm.jx.ttm.model.AhmjxmstProductCategoryType;
import com.ahm.jx.ttm.repository.AhmjxTtmLocationTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxTtmRingTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxTtmWeTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxmstPartyCategoryRepository;
import com.ahm.jx.ttm.repository.AhmjxmstPartyCategoryTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxmstProductCategoryRepository;

@Controller
@RequestMapping(value="/ttm001")
public class Ahmjxttm001Controller {
	
	@Autowired
	AhmjxmstPartyCategoryRepository partyCategoryRepo;
	
	@Autowired
	AhmjxTtmRingTypeRepository ringTypeRepo;
	
	@Autowired
	AhmjxTtmLocationTypeRepository locTypeRepo;	
	
	@Autowired
	AhmjxmstPartyCategoryTypeRepository partyCategoryTypeRepo;	
	
	@Autowired
	AhmjxmstProductCategoryRepository productCategoryRepo;
	
	@Autowired
	AhmjxTtmWeTypeRepository weTypeRepo;
	
	@RequestMapping(value="sp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public List<AhmjxmstProductCategoryType> getSegmentasiProduct() {
		List<AhmjxmstProductCategoryType> d = productCategoryRepo.findByParentCategoryType(AhmjxmstPartyCategoryType.TYPE_SALES_FORCE);
		for (AhmjxmstProductCategoryType a: d) a.getCategories().size();		
		return d;
	}	
	
	//Product Category Update
	@RequestMapping(value="procatupd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AhmjxmstProductCategory setProductCategoryUpdate(AhmjxmstProductCategory entity) {
		return productCategoryRepo.save(entity);
	}	
	
	@RequestMapping(value="sf", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public List<AhmjxmstPartyCategoryType> getSalesForce() {
		List<AhmjxmstPartyCategoryType> d = partyCategoryTypeRepo.findByParentCategoryType(AhmjxmstPartyCategoryType.TYPE_SALES_FORCE);
		for (AhmjxmstPartyCategoryType a: d) a.getCategories().size();		
		return d;
	}
	
	@RequestMapping(value="dc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public List<AhmjxmstPartyCategory> getDealerClassfication() {
		List<AhmjxmstPartyCategory> d = partyCategoryRepo.queryByCategoryType(AhmjxmstPartyCategoryType.TYPE_DEALER_SALES_CLASSIFICATION);		
		return d;
	}
	
	//Party Category Update
	
	@RequestMapping(value="parcatupd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AhmjxmstPartyCategory setSalesForce(AhmjxmstPartyCategory entity) {
		return partyCategoryRepo.save(entity);
	}
	
	@RequestMapping(value="ring", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public List<AhmjxTtmRingType> getRingType() {
		List<AhmjxTtmRingType> d = ringTypeRepo.findAll();		
		return d;
	}
	
	@RequestMapping(value="ring", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public AhmjxTtmRingType setRingType(AhmjxTtmRingType entity) {		
		return ringTypeRepo.save(entity);
	}	
	
	@RequestMapping(value="loc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public List<AhmjxTtmLocationType> getLocType() {
		List<AhmjxTtmLocationType> d = locTypeRepo.findAll();		
		return d;
	}
	
	@RequestMapping(value="loc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public AhmjxTtmLocationType setLocType(AhmjxTtmLocationType entity) {		
		return locTypeRepo.save(entity);
	}
	
	@RequestMapping(value="wet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public List<AhmjxTtmWeType> getWeType() {
		List<AhmjxTtmWeType> d = weTypeRepo.findAll();		
		return d;
	}
	
	@RequestMapping(value="wet", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public AhmjxTtmWeType setWeType(AhmjxTtmWeType entity) {		
		return weTypeRepo.save(entity);
	}	
	
}
