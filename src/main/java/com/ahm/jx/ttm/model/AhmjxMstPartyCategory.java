package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="ahmjxmst_party_category")
@Inheritance(strategy=InheritanceType.JOINED)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idCategory")
public class AhmjxMstPartyCategory extends BaseEntity {

	private static final long serialVersionUID = -2500926500169885029L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcategory")
	private Integer idCategory;
	
	@Column(name="idprncat")
	private Integer idParentCategory;
		
	@Column(name="vdescription")
	private String description;
	
	@Column(name="idcattype")
	private Integer idCategoryType;	

	@Column(name="isalesqty")
	private Integer salesQty;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idcattype", updatable=false, insertable=false)
	private AhmjxMstPartyCategoryType categoryType;
		
	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}	

	public Integer getIdParentCategory() {
		return idParentCategory;
	}

	public void setIdParentCategory(Integer idParentCategory) {
		this.idParentCategory = idParentCategory;
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

	public AhmjxMstPartyCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(AhmjxMstPartyCategoryType categoryType) {
		this.categoryType = categoryType;
	}	

	public Integer getSalesQty() {
		return salesQty;
	}

	public void setSalesQty(Integer salesQty) {
		this.salesQty = salesQty;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdCategory())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxMstPartyCategory)) return false;
		AhmjxMstPartyCategory other = (AhmjxMstPartyCategory) obj;
		return new EqualsBuilder()
			.append( getIdCategory(), other.getIdCategory() )
			.isEquals();
	}		

}
