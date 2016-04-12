package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="ahmjxmst_party_category")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idCategory")
public class AhmjxmstPartyCategory extends BaseEntity {

	private static final long serialVersionUID = -2500926500169885029L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcategory")
	private Integer idCategory;
		
	@Column(name="vdescription")
	private String description;
	
	@Column(name="idcattype", updatable=false, insertable=false)
	private Integer idCategoryType;			

	@ManyToOne
	@JoinColumn(name="idcattype")
	private AhmjxmstPartyCategoryType categoryType;
		
	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIdCategoryType() {
		return idCategoryType;
	}

	public void setIdCategoryType(Integer idCategoryType) {
		this.idCategoryType = idCategoryType;
	}

	public AhmjxmstPartyCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(AhmjxmstPartyCategoryType categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdCategory())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxmstPartyCategory)) return false;
		AhmjxmstPartyCategory other = (AhmjxmstPartyCategory) obj;
		return new EqualsBuilder()
			.append( getIdCategory(), other.getIdCategory() )
			.isEquals();
	}		

}
