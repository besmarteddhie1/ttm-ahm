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
@Table(name="ahmjxmst_facility_type")
public class AhmjxMstFacilityType extends BaseEntity {

	private static final long serialVersionUID = 6855387447315081927L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idfactype")
	private Integer idFacilityType;
	
	@Column(name="vcategory")
	private String category;	
		
	@Column(name="vdescription")
	private String description;	

	public Integer getIdFacilityType() {
		return idFacilityType;
	}

	public void setIdFacilityType(Integer idLocationType) {
		this.idFacilityType = idLocationType;
	}	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdFacilityType())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxMstFacilityType)) return false;
		AhmjxMstFacilityType other = (AhmjxMstFacilityType) obj;
		return new EqualsBuilder()
			.append( getIdFacilityType(), other.getIdFacilityType() )
			.isEquals();
	}		

}
