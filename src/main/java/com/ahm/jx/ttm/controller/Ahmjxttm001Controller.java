package com.ahm.jx.ttm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahm.jx.ttm.model.AhmjxMstFacilityType;
import com.ahm.jx.ttm.model.AhmjxMstPartyCategory;
import com.ahm.jx.ttm.model.AhmjxMstPartyCategoryType;
import com.ahm.jx.ttm.model.AhmjxMstProductCategory;
import com.ahm.jx.ttm.model.AhmjxMstProductCategoryType;
import com.ahm.jx.ttm.model.AhmjxTtmRingType;
import com.ahm.jx.ttm.model.AhmjxTtmWeType;
import com.ahm.jx.ttm.repository.AhmjxMstFacilityTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxMstPartyCategoryRepository;
import com.ahm.jx.ttm.repository.AhmjxMstPartyCategoryTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxMstProductCategoryRepository;
import com.ahm.jx.ttm.repository.AhmjxMstProductCategoryTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxTtmRingTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxTtmWeTypeRepository;

@Controller
@RequestMapping(value="/ttm001")
public class Ahmjxttm001Controller {
	
	@Autowired
	AhmjxMstPartyCategoryRepository partyCategoryRepo;
	
	@Autowired
	AhmjxTtmRingTypeRepository ringTypeRepo;
	
	@Autowired
	AhmjxMstFacilityTypeRepository facilityTypeRepo;	
	
	@Autowired
	AhmjxMstPartyCategoryTypeRepository partyCategoryTypeRepo;	
	
	@Autowired
	AhmjxMstProductCategoryRepository productCategoryRepo;
	
	@Autowired
	AhmjxMstProductCategoryTypeRepository productCategoryTypeRepo;	
	
	@Autowired
	AhmjxTtmWeTypeRepository weTypeRepo;
	
	@RequestMapping(value="sp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public List<AhmjxMstProductCategoryType> getSegmentasiProduct() {
		List<AhmjxMstProductCategoryType> d = productCategoryTypeRepo.findByParentCategoryType(AhmjxMstProductCategoryType.TYPE_CUB);
		for (AhmjxMstProductCategoryType a: d) a.getCategories().size();		
		return d;
	}	
	
	//Product Category Update
	@RequestMapping(value="procatupd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AhmjxMstProductCategory setProductCategoryUpdate(AhmjxMstProductCategory entity) {
		return productCategoryRepo.save(entity);
	}	
	
	@RequestMapping(value="sf", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public List<AhmjxMstPartyCategoryType> getSalesForce() {
		List<AhmjxMstPartyCategoryType> d = partyCategoryTypeRepo.findByParentCategoryType(AhmjxMstPartyCategoryType.TYPE_SALES_FORCE);
		for (AhmjxMstPartyCategoryType a: d) a.getCategories().size();		
		return d;
	}
		
	
	@RequestMapping(value="dc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public List<AhmjxMstPartyCategory> getDealerClassfication() {
		List<AhmjxMstPartyCategory> d = partyCategoryRepo.queryByCategoryType(AhmjxMstPartyCategoryType.TYPE_DEALER_SALES_CLASSIFICATION);		
		return d;
	}
	
	//Party Category Update
	
	@RequestMapping(value="parcatupd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AhmjxMstPartyCategory setSalesForce(AhmjxMstPartyCategory entity) {
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
	public List<AhmjxMstFacilityType> getLocType() {
		List<AhmjxMstFacilityType> d = facilityTypeRepo.findAll();		
		return d;
	}
	
	@RequestMapping(value="loc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public AhmjxMstFacilityType setLocType(AhmjxMstFacilityType entity) {		
		return facilityTypeRepo.save(entity);
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
