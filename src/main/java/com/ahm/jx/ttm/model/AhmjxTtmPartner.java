package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ahmjxttm_partner")
@Inheritance(strategy=InheritanceType.JOINED)
public class AhmjxTtmPartner extends BaseEntity {

	private static final long serialVersionUID = -8438400975266936737L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="vuidpartner", nullable = false)
	private String uidPartner;
		
	public String getUidPartner() {
		return uidPartner;
	}

	public void setUidPartner(String uidPartner) {
		this.uidPartner = uidPartner;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUidPartner())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxTtmPartner)) return false;
		AhmjxTtmPartner other = (AhmjxTtmPartner) obj;
		return new EqualsBuilder()
			.append( getUidPartner(), other.getUidPartner() )
			.isEquals();
	}		

}
