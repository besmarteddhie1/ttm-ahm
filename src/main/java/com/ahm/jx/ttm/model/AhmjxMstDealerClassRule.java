package com.ahm.jx.ttm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="ahmjxmst_dealer_class_rule")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idRule")
public class AhmjxMstDealerClassRule extends BaseEntity {

	private static final long serialVersionUID = -3241441229228177373L;
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iidDealerClassRule")
	private Integer idDealerClassRule;
		
	@Column(name="idRule")
	private String idRule;	
	
	@Column(name="vdescription")
	private String description;	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idRule", updatable=false, insertable=false)
	private AhmjxMstRule rule;
	
	public void setRule(AhmjxMstRule rule) {
		this.rule = rule;
	}

	public Integer getIdDealerClassRule() {
		return idDealerClassRule;
	}

	public void setIdDealerClassRule(Integer idDealerClassRule) {
		this.idDealerClassRule = idDealerClassRule;
	}

	public String getIdRule() {
		return idRule;
	}

	public void setIdRule(String idRule) {
		this.idRule = idRule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDealerClassRule == null) ? 0 : idDealerClassRule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AhmjxMstDealerClassRule other = (AhmjxMstDealerClassRule) obj;
		if (idDealerClassRule == null) {
			if (other.idDealerClassRule != null)
				return false;
		} else if (!idDealerClassRule.equals(other.idDealerClassRule))
			return false;
		return true;
	}
	
	
	
}

