package com.ahm.jx.ttm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "ahmjxmst_geo_boundary")
@Inheritance(strategy = InheritanceType.JOINED)
public class AhmjxMstGeoBoundary extends BaseEntity {

	private static final long serialVersionUID = 2883222714017631224L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "vidgeobou", nullable = false)
	private String idGeoBoundary;

	@Column(name = "idparentgeobou")
	private String idParentGeoBoundary;

	@Column(name = "idgeo")
	private String idGeo;

	@Column(name = "vname")
	private String name;

	@Column(name = "vdescription")
	private String description;

	@Column(name = "findexpotensi")
	private Float indexPotensi;

	@Column(name = "fconsumerrate")
	private Float consumerRate;

	@OneToMany(targetEntity = AhmjxMstGeoBoundary.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "idparentgeobou", referencedColumnName = "vidgeobou", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private List<AhmjxMstGeoBoundary> child;

	public String getIdGeoBoundary() {
		return idGeoBoundary;
	}

	public void setIdGeoBoundary(String idGeoBoundary) {
		this.idGeoBoundary = idGeoBoundary;
	}

	public String getIdParentGeoBoundary() {
		return idParentGeoBoundary;
	}

	public void setIdParentGeoBoundary(String idParentGeoBoundary) {
		this.idParentGeoBoundary = idParentGeoBoundary;
	}

	public String getIdGeo() {
		return idGeo;
	}

	public void setIdGeo(String idGeo) {
		this.idGeo = idGeo;
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

	public Float getIndexPotensi() {
		return indexPotensi;
	}

	public void setIndexPotensi(Float indexPotensi) {
		this.indexPotensi = indexPotensi;
	}

	public Float getConsumerRate() {
		return consumerRate;
	}

	public void setConsumerRate(Float consumerRate) {
		this.consumerRate = consumerRate;
	}

	public List<AhmjxMstGeoBoundary> getChild() {
		return child;
	}

	public void setChild(List<AhmjxMstGeoBoundary> child) {
		this.child = child;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getIdGeoBoundary()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxMstGeoBoundary))
			return false;
		AhmjxMstGeoBoundary other = (AhmjxMstGeoBoundary) obj;
		return new EqualsBuilder().append(getIdGeoBoundary(), other.getIdGeoBoundary()).isEquals();
	}

}
