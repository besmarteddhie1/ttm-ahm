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
@Table(name="ahmjxttm_location_type")
public class AhmjxTtmRingType extends BaseEntity {

	private static final long serialVersionUID = 6855387447315081927L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idloctype")
	private Integer idLocationType;
		
	@Column(name="vdescription")
	private String description;
	
	public Integer getIdLocationType() {
		return idLocationType;
	}

	public void setIdLocationType(Integer idLocationType) {
		this.idLocationType = idLocationType;
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
			.append(getIdLocationType())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxTtmRingType)) return false;
		AhmjxTtmRingType other = (AhmjxTtmRingType) obj;
		return new EqualsBuilder()
			.append( getIdLocationType(), other.getIdLocationType() )
			.isEquals();
	}		

}
