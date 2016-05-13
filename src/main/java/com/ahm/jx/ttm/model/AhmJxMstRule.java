package com.ahm.jx.ttm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="ahmjxmst_rules")
@Inheritance(strategy=InheritanceType.JOINED)
public class AhmJxMstRule extends BaseEntity {



	private static final long serialVersionUID = 3446937428286212535L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idrule", nullable = false)
	private Integer idRule;
	
	@Column(name="vdescription")
	private String description;	
		
	@OneToMany(cascade=CascadeType.ALL, mappedBy="rule")
	private List<AhmjxMstDealerClassRule> rule = new ArrayList<AhmjxMstDealerClassRule>();
	
	public Integer getIdRule() {
		return idRule;
	}

	public void setIdRule(Integer idRule) {
		this.idRule = idRule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<AhmjxMstDealerClassRule> getRule() {
		return rule;
	}

	public void setRule(List<AhmjxMstDealerClassRule> rule) {
		this.rule = rule;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdRule())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmJxMstRule)) return false;
		AhmJxMstRule other = (AhmJxMstRule) obj;
		return new EqualsBuilder()
			.append( getIdRule(), other.getIdRule() )
			.isEquals();
	}		

}
