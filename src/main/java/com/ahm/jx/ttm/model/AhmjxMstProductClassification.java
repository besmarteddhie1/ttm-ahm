package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="AhmjxMst_product_classification")
public class AhmjxMstProductClassification extends BaseEntity {

	private static final long serialVersionUID = -2500926500169885029L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idprodcla")
	private Integer idClassification;
		
	@ManyToOne
	@JoinColumn(name="idcategory")
	private AhmjxMstProductCategory category;
	
	@ManyToOne
	@JoinColumn(name="idproduct")
	private AhmjxMstProduct product;
	
	@Embedded
	private DataPeriod periods;
	
	public Integer getIdClassification() {
		return idClassification;
	}

	public void setIdClassification(Integer idClassification) {
		this.idClassification = idClassification;
	}

	public AhmjxMstProductCategory getCategory() {
		return category;
	}

	public void setCategory(AhmjxMstProductCategory category) {
		this.category = category;
	}

	public AhmjxMstProduct getProduct() {
		return product;
	}

	public void setProduct(AhmjxMstProduct product) {
		this.product = product;
	}
	
	public DataPeriod getPeriods() {
		return periods;
	}

	public void setPeriods(DataPeriod periods) {
		this.periods = periods;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdClassification())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxMstProductClassification)) return false;
		AhmjxMstProductClassification other = (AhmjxMstProductClassification) obj;
		return new EqualsBuilder()
			.append( getIdClassification(), other.getIdClassification() )
			.isEquals();
	}		

}
