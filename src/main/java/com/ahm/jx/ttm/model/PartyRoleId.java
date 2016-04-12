package com.ahm.jx.ttm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

@Embeddable
public class PartyRoleId implements Serializable {
	
	private static final long serialVersionUID = -1995914680443809221L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="idparty")
	private String idParty;
	
	@Column(name="idroletype")
	private Integer idRoleType;
	
	public PartyRoleId(int idR, String idP) {
		this.idParty = idP;
		this.idRoleType = idR;
	}
	
	public PartyRoleId() {
	}	
	
	public int getIdRoleType() {
		return idRoleType;
	}
	
	public void setIdRoleType(int idRoleType) {
		this.idRoleType = idRoleType;
	}
	
	public String getIdParty() {
		return idParty;
	}

	public void setIdParty(String idParty) {
		this.idParty = idParty;
	}	
	
	@Override
	public boolean equals(Object obj) {		
		if (!(obj instanceof PartyRoleId)) return false;
		PartyRoleId other = (PartyRoleId) obj;
		return new EqualsBuilder()
			.append(getIdParty(), other.getIdParty())
			.append(getIdRoleType(), other.getIdRoleType())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getIdParty())
				.append(this.idRoleType)
				.toHashCode();
	}
		
}
