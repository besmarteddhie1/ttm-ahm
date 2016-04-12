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
@Table(name="ahmjxmst_party_role")
public class AhmjxmstPartyRole extends BaseEntity {
	
	private static final long serialVersionUID = -4908805860847567141L;
	
	@EmbeddedId
	private PartyRoleId idPartyRole;
			
	@MapsId("idParty")
	@ManyToOne
    @JoinColumn(name="idparty")
    private AhmjxmstParty party;
	
	public PartyRoleId getIdPartyRole() {
		return idPartyRole;
	}

	public void setIdPartyRole(PartyRoleId idPartyRole) {
		this.idPartyRole = idPartyRole;
	}

	public void setParty(AhmjxmstParty party) {
		this.party = party;
	}

	public AhmjxmstPartyRole() {
	}
	

	@Override
	public boolean equals(Object obj) {		
		if (!(obj instanceof AhmjxmstPartyRole)) return false;
		AhmjxmstPartyRole other = (AhmjxmstPartyRole) obj;
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