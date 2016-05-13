package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ahmjxmst_brand_category")
public class AhmjxMstBrandCategory extends BaseEntity {

	private static final long serialVersionUID = 2291989247985328368L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idBrandCategory")
	private Integer idBrandCategory;
	
	@Column(name="isequence")
	private Integer sequence;
	
	@Column(name="vstatus")
	private String status;
	
	@Column(name="idcattype")
	private Integer idCategoryType;	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idcattype", updatable=false, insertable=false)
	private AhmjxMstProductCategoryType categoryType;

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	
	
	public Integer getIdCategoryType() {
		return idCategoryType;
	}

	public void setIdCategoryType(Integer idCategoryType) {
		this.idCategoryType = idCategoryType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIdBrandCategory() {
		return idBrandCategory;
	}

	public void setIdBrandCategory(Integer idBrandCategory) {
		this.idBrandCategory = idBrandCategory;
	}

	public AhmjxMstProductCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(AhmjxMstProductCategoryType categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((idBrandCategory == null) ? 0 : idBrandCategory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AhmjxMstBrandCategory other = (AhmjxMstBrandCategory) obj;
		if (idBrandCategory == null) {
			if (other.idBrandCategory != null)
				return false;
		} else if (!idBrandCategory.equals(other.idBrandCategory))
			return false;
		return true;
	}
	
	
}
