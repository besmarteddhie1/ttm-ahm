package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ahmjxmst_facility")
@Inheritance(strategy=InheritanceType.JOINED)
public class AhmjxMstFacility extends BaseEntity {

	private static final long serialVersionUID = 3446937428286212535L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="vidfacility", nullable = false)
	private String idFacility;
	
	@Column(name="vdescription")
	private String description;	
		

	public String getIdFacility() {
		return idFacility;
	}

	public void setIdFacility(String idFacility) {
		this.idFacility = idFacility;
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
			.append(getIdFacility())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxMstFacility)) return false;
		AhmjxMstFacility other = (AhmjxMstFacility) obj;
		return new EqualsBuilder()
			.append( getIdFacility(), other.getIdFacility() )
			.isEquals();
	}		

}
