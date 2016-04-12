package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="ahmjxmst_party_classification")
public class AhmjxmstPartyClassification extends BaseEntity {

	private static final long serialVersionUID = -7335123782514036295L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idparcla")
	private Integer idClassification;
		
	@ManyToOne
	@JoinColumn(name="idcategory")
	private AhmjxmstPartyCategory category;
	
	@ManyToOne
	@JoinColumn(name="idparty")
	private AhmjxmstParty party;
	
	@Embedded
	private DataPeriod periods;
	
	public AhmjxmstParty getParty() {
		return party;
	}

	public void setParty(AhmjxmstParty party) {
		this.party = party;
	}

	public Integer getIdClassification() {
		return idClassification;
	}

	public void setIdClassification(Integer idClassification) {
		this.idClassification = idClassification;
	}

	public AhmjxmstPartyCategory getCategory() {
		return category;
	}

	public void setCategory(AhmjxmstPartyCategory category) {
		this.category = category;
	}

	
	public DataPeriod getPeriods() {
		return periods;
	}

	public void setPeriods(DataPeriod periods) {
		this.periods = periods;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdClassification())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxmstPartyClassification)) return false;
		AhmjxmstPartyClassification other = (AhmjxmstPartyClassification) obj;
		return new EqualsBuilder()
			.append( getIdClassification(), other.getIdClassification() )
			.isEquals();
	}		

}
