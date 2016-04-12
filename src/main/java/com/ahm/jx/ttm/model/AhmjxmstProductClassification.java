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
@Table(name="ahmjxmst_product_classification")
public class AhmjxmstProductClassification extends BaseEntity {

	private static final long serialVersionUID = -2500926500169885029L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idprodcla")
	private Integer idClassification;
		
	@ManyToOne
	@JoinColumn(name="idcategory")
	private AhmjxmstProductCategory category;
	
	@ManyToOne
	@JoinColumn(name="idproduct")
	private AhmjxmstProduct product;
	
	@Embedded
	private DataPeriod periods;
	
	public Integer getIdClassification() {
		return idClassification;
	}

	public void setIdClassification(Integer idClassification) {
		this.idClassification = idClassification;
	}

	public AhmjxmstProductCategory getCategory() {
		return category;
	}

	public void setCategory(AhmjxmstProductCategory category) {
		this.category = category;
	}

	public AhmjxmstProduct getProduct() {
		return product;
	}

	public void setProduct(AhmjxmstProduct product) {
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
		if (!(obj instanceof AhmjxmstProductClassification)) return false;
		AhmjxmstProductClassification other = (AhmjxmstProductClassification) obj;
		return new EqualsBuilder()
			.append( getIdClassification(), other.getIdClassification() )
			.isEquals();
	}		

}
