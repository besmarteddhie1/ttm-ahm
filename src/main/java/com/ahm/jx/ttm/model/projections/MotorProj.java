package com.ahm.jx.ttm.model.projections;

import org.springframework.data.rest.core.config.Projection;

import com.ahm.jx.ttm.model.AhmjxMstMotor;
import com.ahm.jx.ttm.model.AhmjxMstProduct;
import com.ahm.jx.ttm.model.AhmjxMstProductCategory;
import com.ahm.jx.ttm.model.DataPeriod;

@Projection(name = "MotorProj", types = {AhmjxMstMotor.class})
public interface MotorProj {
	
	public String getIsActive();
	public String getIdMotor();
	public String getSegment();
	public AhmjxMstProductCategory getDescriptionSeri();
//	public AhmjxMstProductCategory getSegment();
	public String getCategory(); 
}	
