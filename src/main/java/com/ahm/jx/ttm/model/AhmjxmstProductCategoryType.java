package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


@Entity
@Table(name="ahmjxmst_product_category_type")
public class AhmjxmstProductCategoryType extends AhmMappedEntity {

	private static final long serialVersionUID = -2500926500169885028L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCategoryType;
		
	@Column(name="vdescription")
	private String description;
	
	@Column(name="idprncattyp")
	private Integer parentCategoryType;	
	
	public Integer getIdCategoryType() {
		return idCategoryType;
	}

	public void setIdCategoryType(Integer idCategoryType) {
		this.idCategoryType = idCategoryType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentCategoryType() {
		return parentCategoryType;
	}

	public void setParentCategoryType(Integer parentCategoryType) {
		this.parentCategoryType = parentCategoryType;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdCategoryType())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxmstProductCategoryType)) return false;
		AhmjxmstProductCategoryType other = (AhmjxmstProductCategoryType) obj;
		return new EqualsBuilder()
			.append( getIdCategoryType(), other.getIdCategoryType() )
			.isEquals();
	}		

}
