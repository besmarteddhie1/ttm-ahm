package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="ahmjxmst_rule_type")
@Inheritance(strategy=InheritanceType.JOINED)
public class AhmJxMstRuleType extends BaseEntity {


	private static final long serialVersionUID = -1316364201198350943L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idruletype", nullable = false)
	private Integer idRuleType;

	@Column(name="idprnrultyp")
	private String idParentRuleType;	
	
	@Column(name="vdescription")
	private String description;	
		
	public Integer getIdRuleType() {
		return idRuleType;
	}

	public String getIdParentRuleType() {
		return idParentRuleType;
	}

	public void setIdParentRuleType(String idParentRuleType) {
		this.idParentRuleType = idParentRuleType;
	}

	public void setIdRuleType(Integer idRuleType) {
		this.idRuleType = idRuleType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdRuleType())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmJxMstRuleType)) return false;
		AhmJxMstRuleType other = (AhmJxMstRuleType) obj;
		return new EqualsBuilder()
			.append( getIdRuleType(), other.getIdRuleType() )
			.isEquals();
	}		

}
