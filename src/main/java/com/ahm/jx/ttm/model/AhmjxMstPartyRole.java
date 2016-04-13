package com.ahm.jx.ttm.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="AhmjxMst_party_role")
public class AhmjxMstPartyRole extends BaseEntity {
	
	private static final long serialVersionUID = -4908805860847567141L;
	
	@EmbeddedId
	private PartyRoleId idPartyRole;
			
	@MapsId("idParty")
	@ManyToOne
    @JoinColumn(name="idparty")
    private AhmjxMstParty party;
	
	public PartyRoleId getIdPartyRole() {
		return idPartyRole;
	}

	public void setIdPartyRole(PartyRoleId idPartyRole) {
		this.idPartyRole = idPartyRole;
	}

	public void setParty(AhmjxMstParty party) {
		this.party = party;
	}

	public AhmjxMstPartyRole() {
	}
	

	@Override
	public boolean equals(Object obj) {		
		if (!(obj instanceof AhmjxMstPartyRole)) return false;
		AhmjxMstPartyRole other = (AhmjxMstPartyRole) obj;
		return new EqualsBuilder()
			.append(getIdPartyRole(), other.getIdPartyRole())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(getIdPartyRole())
				.toHashCode();
	}		
}