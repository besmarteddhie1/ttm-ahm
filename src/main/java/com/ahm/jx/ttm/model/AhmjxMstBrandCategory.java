package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ahmjxmst_brand_category")
public class AhmjxMstBrandCategory extends AhmjxMstProductCategory {

	private static final long serialVersionUID = 2291989247985328368L;
	
	@Column(name="isequence")
	private Integer sequence;
	
	@Column(name="vstatus")
	private String status;

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
