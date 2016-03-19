package com.ahm.jx.ttm.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.*;

@Entity
@DiscriminatorValue(AbstractPartner.type_main_dealer)
public class AhmMainDealer extends AbstractPartner {
	
	private static final long serialVersionUID = 4450935122713205998L;
	
	@Column(name="VMDCODE")
	private String mainDealerCode;
	
	@OneToMany(mappedBy="mainDealer")
	private List<AhmDealer> dealers = new ArrayList<AhmDealer>();

	public String getMainDealerCode() {
		return mainDealerCode;
	}

	public void setMainDealerCode(String mainDealerCode) {
		this.mainDealerCode = mainDealerCode;
	}

	public List<AhmDealer> getDealers() {
		return dealers;
	}

	public void setDealers(List<AhmDealer> dealers) {
		this.dealers = dealers;
	} 

}
