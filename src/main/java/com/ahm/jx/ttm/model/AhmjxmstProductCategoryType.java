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

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="ahmjxmst_product_category_type")
public class AhmjxmstProductCategoryType extends BaseEntity {

	private static final long serialVersionUID = -2500926500169885028L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcattype")
	private Integer idCategoryType;
		
	@Column(name="vdescription")
	private String description;
	
	@Column(name="idprncattyp")
	private Integer parentCategoryType;
	
	@OneToMany
	@JoinColumn(name="idcattype")
	@JsonManagedReference
	private List<AhmjxmstProductCategory> categories = new ArrayList<AhmjxmstProductCategory>();	
	
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

	public List<AhmjxmstProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<AhmjxmstProductCategory> categories) {
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
		if (!(obj instanceof AhmjxmstProductCategoryType)) return false;
		AhmjxmstProductCategoryType other = (AhmjxmstProductCategoryType) obj;
		return new EqualsBuilder()
			.append( getIdCategoryType(), other.getIdCategoryType() )
			.isEquals();
	}		

}
