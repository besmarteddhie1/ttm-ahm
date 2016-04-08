package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="ahmjxmst_motor")
public class AhmjxmstMotor extends AhmjxmstProduct {

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
