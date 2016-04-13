package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="AhmjxMst_motor")
public class AhmjxMstMotor extends AhmjxMstProduct {

	private static final long serialVersionUID = -3122944560658360341L;
	
	@Column(name="norangka")
	private String noRangka;

	public String getNoRangka() {
		return noRangka;
	}

	public void setNoRangka(String noRangka) {
		this.noRangka = noRangka;
	}

}
