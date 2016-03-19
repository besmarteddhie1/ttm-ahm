package com.ahm.jx.ttm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.ahm.jx.ttm.config.EntityDomain;

@Entity
@Table(name="geo_boundary")
public class GeographicBoundary extends BaseEntity {

	private static final long serialVersionUID = 5621497326705047937L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idgeo")
    private Integer idGeo;
	
	@Max(99999)
    @Column(name="longitude")
    private Integer longitude;
    
	@Max(99999)
    @Column(name="latitude")
    private Integer latitude;
    
    @NotNull
    @Column(name="name", length=EntityDomain.LENGTH_NAME)
    private String name;
    
    public GeographicBoundary() {
	}
    
    public GeographicBoundary(String name, Integer lati, Integer longi) {
    	this.name = name;
    	this.latitude = lati;
    	this.longitude = longi;
	}    
	
	public Integer getIdGeo() {
		return idGeo;
	}

	public void setIdGeo(Integer idGeo) {
		this.idGeo = idGeo;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
		.append(getIdGeo())
		.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof GeographicBoundary)) return false;
		GeographicBoundary other = (GeographicBoundary) obj;
		return new EqualsBuilder()
			.append(getIdGeo(), other.getIdGeo())
			.isEquals();
	}		

}
