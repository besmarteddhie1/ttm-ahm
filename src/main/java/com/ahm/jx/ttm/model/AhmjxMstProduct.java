package com.ahm.jx.ttm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

@Entity
@Table(name="AhmjxMst_product")
@Inheritance(strategy=InheritanceType.JOINED)
public class AhmjxMstProduct extends BaseEntity {

	private static final long serialVersionUID = -2500926500169885028L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="vidproduct", nullable = false)
	private String idProduct;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="product")
	@Where(clause="current_timestamp between dtfrom and dtthru")
	private List<AhmjxMstProductClassification> classification = new ArrayList<AhmjxMstProductClassification>();
	
	public AhmjxMstProductClassification setCategory(AhmjxMstProductCategory c) {
		for (AhmjxMstProductClassification o: classification) {
			if (o.getCategory().getCategoryType().equals(c.getCategoryType())) {
				if (o.getCategory().equals(c)) return o;
				o.getPeriods().endPeriod();
			}
		}
		
		AhmjxMstProductClassification o = new AhmjxMstProductClassification();
		o.setProduct(this);
		o.setCategory(c);
		o.setPeriods(new DataPeriod());
		return o;
	}
	
	public AhmjxMstProductCategory getCategory(Integer typeCat) {
		for (AhmjxMstProductClassification o: classification) 
			if (o.getCategory().getCategoryType().getIdCategoryType().equals(typeCat))
				return o.getCategory();		
		return null;
	}	

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
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
	
	public List<AhmjxMstProductClassification> getClassification() {
		return classification;
	}

	public void setClassification(List<AhmjxMstProductClassification> classification) {
		this.classification = classification;
	}	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdProduct())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxMstProduct)) return false;
		AhmjxMstProduct other = (AhmjxMstProduct) obj;
		return new EqualsBuilder()
			.append( getIdProduct(), other.getIdProduct() )
			.isEquals();
	}		

}
