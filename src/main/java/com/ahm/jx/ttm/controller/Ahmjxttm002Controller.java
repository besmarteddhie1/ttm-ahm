package com.ahm.jx.ttm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahm.jx.ttm.model.AhmjxMstFacilityType;
import com.ahm.jx.ttm.model.AhmjxMstMotor;
import com.ahm.jx.ttm.model.AhmjxMstPartyCategory;
import com.ahm.jx.ttm.model.AhmjxMstPartyCategoryType;
import com.ahm.jx.ttm.model.AhmjxMstProduct;
import com.ahm.jx.ttm.model.AhmjxMstProductCategory;
import com.ahm.jx.ttm.model.AhmjxMstProductCategoryType;
import com.ahm.jx.ttm.model.AhmjxTtmRingType;
import com.ahm.jx.ttm.model.AhmjxTtmWeType;
import com.ahm.jx.ttm.repository.AhmjxMstFacilityTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxMstPartyCategoryRepository;
import com.ahm.jx.ttm.repository.AhmjxMstPartyCategoryTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxMstProductCategoryRepository;
import com.ahm.jx.ttm.repository.AhmjxMstProductCategoryTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxMstMotorRepository;
import com.ahm.jx.ttm.repository.AhmjxTtmRingTypeRepository;
import com.ahm.jx.ttm.repository.AhmjxTtmWeTypeRepository;

@Controller
@RequestMapping(value="/api/ttm002")
public class Ahmjxttm002Controller {
	
	@Autowired
	AhmjxMstMotorRepository motorRepo;
	
	@RequestMapping(value="motor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
	public List<AhmjxMstMotor> getMotor() {
		List<AhmjxMstMotor> d = motorRepo.findAll();		
		return d;
	}
	
	
  
	
	
	
}
