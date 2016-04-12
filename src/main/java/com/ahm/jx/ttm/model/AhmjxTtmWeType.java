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
@Table(name="ahmjxttm_work_effort_type")
public class AhmjxTtmWeType extends BaseEntity {

	private static final long serialVersionUID = 6855387447315081927L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idwetype")
	private Integer idWeType;
		
	@Column(name="vdescription")
	private String description;
	
	public Integer getIdWeType() {
		return idWeType;
	}

	public void setIdWeType(Integer idWeType) {
		this.idWeType = idWeType;
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
			.append(getIdWeType())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxTtmWeType)) return false;
		AhmjxTtmWeType other = (AhmjxTtmWeType) obj;
		return new EqualsBuilder()
			.append( getIdWeType(), other.getIdWeType() )
			.isEquals();
	}		

}
