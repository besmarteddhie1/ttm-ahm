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
@Table(name="ahmjxttm_ring_type")
public class AhmjxTtmLocationType extends BaseEntity {

	private static final long serialVersionUID = 6855387447315081927L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idring")
	private Integer idRing;
		
	@Column(name="vdescription")
	private String description;
	
	public Integer getIdRing() {
		return idRing;
	}

	public void setIdRing(Integer idRing) {
		this.idRing = idRing;
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
			.append(getIdRing())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxTtmLocationType)) return false;
		AhmjxTtmLocationType other = (AhmjxTtmLocationType) obj;
		return new EqualsBuilder()
			.append( getIdRing(), other.getIdRing() )
			.isEquals();
	}		

}
