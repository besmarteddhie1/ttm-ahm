package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Table(name="ahmjxmst_party_category_type")
public class AhmjxmstPartyCategoryType extends AhmMappedEntity {

	private static final long serialVersionUID = -2500926500169885028L;
	
	public static final int TYPE_SALES_FORCE = 50;
	
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
		if (!(obj instanceof AhmjxmstPartyCategoryType)) return false;
		AhmjxmstPartyCategoryType other = (AhmjxmstPartyCategoryType) obj;
		return new EqualsBuilder()
			.append( getIdCategoryType(), other.getIdCategoryType() )
			.isEquals();
	}		

}
