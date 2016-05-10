package com.ahm.jx.ttm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="ahmjxmst_product_category_type")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idCategoryType")
public class AhmjxMstProductCategoryType extends BaseEntity {

	private static final long serialVersionUID = -2500926500169885028L;
	
	public static final int TYPE_CUB = 50;
	public static final int TYPE_SEGMENT = 100;
	public static final int TYPE_SERI = 110;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcattype")
	private Integer idCategoryType;
		
	@Column(name="vdescription")
	private String description;
	
	@Column(name="idprncattyp")
	private Integer parentCategoryType;
	
	@OneToMany
	@JoinColumn(name="idcattype")
	private List<AhmjxMstProductCategory> categories = new ArrayList<AhmjxMstProductCategory>();	
	
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

	public List<AhmjxMstProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<AhmjxMstProductCategory> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdCategoryType())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxMstProductCategoryType)) return false;
		AhmjxMstProductCategoryType other = (AhmjxMstProductCategoryType) obj;
		return new EqualsBuilder()
			.append( getIdCategoryType(), other.getIdCategoryType() )
			.isEquals();
	}		

}
