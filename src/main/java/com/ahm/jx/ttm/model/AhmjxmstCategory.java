package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Table(name="ahmjxmst_product_category")
public class AhmjxmstCategory extends AhmMappedEntity {

	private static final long serialVersionUID = -2500926500169885029L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcategory")
	private Integer idCategory;
		
	@Column(name="description")
	private String description;

	@ManyToOne
	@JoinColumn(name="idcattype")
	private AhmjxmstCategoryType categoryType;

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


	public AhmjxmstCategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(AhmjxmstCategoryType categoryType) {
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
		if (!(obj instanceof AhmjxmstCategory)) return false;
		AhmjxmstCategory other = (AhmjxmstCategory) obj;
		return new EqualsBuilder()
			.append( getIdCategory(), other.getIdCategory() )
			.isEquals();
	}		

}
