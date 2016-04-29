package com.ahm.jx.ttm.model.projections;

import org.springframework.data.rest.core.config.Projection;

import com.ahm.jx.ttm.model.AhmjxMstPartyCategory;
import com.ahm.jx.ttm.model.AhmjxMstPartyCategoryType;

@Projection(name = "partyCategoryP", types = {AhmjxMstPartyCategory.class})
public interface PartyCategoryP {
	
	public Integer getIdCategory();
	
	public Integer getIdParentCategory();

	public String getDescription();
	
	public Integer getIdCategoryType();
	
	public AhmjxMstPartyCategoryType getCategoryType();

}
