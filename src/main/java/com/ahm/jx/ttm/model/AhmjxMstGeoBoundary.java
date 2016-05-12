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
@Table(name="ahmjxmst_geo_boundary")
@Inheritance(strategy=InheritanceType.JOINED)
public class AhmjxMstGeoBoundary extends BaseEntity {

	private static final long serialVersionUID = 2883222714017631224L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="vidgeobou", nullable = false)
	private String idGeoBoundary;
	
	@Column(name="vname")
	private String name;
	
	@Column(name="vdescription")
	private String description;
	
	public String getIdGeoBoundary() {
		return idGeoBoundary;
	}

	public void setIdGeoBoundary(String idGeoBoundary) {
		this.idGeoBoundary = idGeoBoundary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
			.append(getIdGeoBoundary())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxMstGeoBoundary)) return false;
		AhmjxMstGeoBoundary other = (AhmjxMstGeoBoundary) obj;
		return new EqualsBuilder()
			.append( getIdGeoBoundary(), other.getIdGeoBoundary() )
			.isEquals();
	}		

}
