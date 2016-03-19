package com.ahm.jx.ttm.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(AbstractPartner.type_dealer)
public class AhmDealer extends AbstractPartner {

	private static final long serialVersionUID = 4450935122713205998L;
		
	@Column(name="VMDDLRCODE")
	private String dealerCode;
	
	@ManyToOne
	@JoinColumn(name="vmdcode")
	private AhmMainDealer mainDealer;

	public AhmMainDealer getMainDealer() {
		return mainDealer;
	}

	public void setMainDealer(AhmMainDealer mainDealer) {
		this.mainDealer = mainDealer;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}	

}
