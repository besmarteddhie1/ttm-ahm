package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ahmjxmst_motor")
public class AhmjxMstMotor extends AhmjxMstProduct {

	private static final long serialVersionUID = -3122944560658360341L;
	
	@Column(name="idmotor")
	private String idMotor;
	
	@Column(name="vstatus")
	private String isActive;

	public String getIdMotor() {
		return idMotor;
	}

	public void setIdMotor(String idMotor) {
		this.idMotor = idMotor;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public String getDescriptionSegment() {
		AhmjxMstProductCategory g = getCategory(AhmjxMstProductCategoryType.TYPE_SEGMENT);
		if (g != null) return g.getDescription();
		return null;
	}
	
	public String getDescriptionSeri() {
		AhmjxMstProductCategory g = getCategory(AhmjxMstProductCategoryType.TYPE_SERI);
		if (g != null) return g.getDescription();
		return null;
	}	

}
