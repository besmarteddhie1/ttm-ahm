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
public class AhmjxMstPartyClassification extends BaseEntity {

	private static final long serialVersionUID = -7335123782514036295L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idparcla")
	private Integer idClassification;
		
	@ManyToOne
	@JoinColumn(name="idcategory")
	private AhmjxMstPartyCategory category;
	
	@ManyToOne
	@JoinColumn(name="idparty")
	private AhmjxMstParty party;
	
	@Embedded
	private DataPeriod periods;
	
	public AhmjxMstParty getParty() {
		return party;
	}

	public void setParty(AhmjxMstParty party) {
		this.party = party;
	}

	public Integer getIdClassification() {
		return idClassification;
	}

	public void setIdClassification(Integer idClassification) {
		this.idClassification = idClassification;
	}

	public AhmjxMstPartyCategory getCategory() {
		return category;
	}

	public void setCategory(AhmjxMstPartyCategory category) {
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
		if (!(obj instanceof AhmjxMstPartyClassification)) return false;
		AhmjxMstPartyClassification other = (AhmjxMstPartyClassification) obj;
		return new EqualsBuilder()
			.append( getIdClassification(), other.getIdClassification() )
			.isEquals();
	}		

}
