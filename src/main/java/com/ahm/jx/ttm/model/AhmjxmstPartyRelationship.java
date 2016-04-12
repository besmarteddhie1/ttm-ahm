package com.ahm.jx.ttm.model;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ahmjxmst_party_relationship") 
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(name="seq_party_relationship", 
		sequenceName="seq_party_relationship", 
		initialValue=1, allocationSize=1)
@Where(clause = "current_timestamp between dtfrom and dtthru")
@Cacheable(true)
public class AhmjxmstPartyRelationship extends AhmMappedEntity {
	
	private static final long serialVersionUID = 349047101370812998L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_party_relationship")
    @Column(name="idrelation")	
	private Integer idRelation;
	
    @Column(name="idreltype")
	private Integer idRelationType;
    
    @Column(name="idstatustype")
	private Integer idStatusType;
    
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumns({
		@JoinColumn(name="idpartyfrom", referencedColumnName="idparty"),
		@JoinColumn(name="idroletypefrom", referencedColumnName="idroletype")})
	@JsonBackReference
	private AhmjxmstPartyRole roleFrom;
    
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumns({
		@JoinColumn(name="idpartyto", referencedColumnName="idparty"),
		@JoinColumn(name="idroletypeto", referencedColumnName="idroletype")})
	@JsonBackReference
	private AhmjxmstPartyRole roleTo;
	
	@Embedded
    private DataPeriod dataPeriod;	
	
    public AhmjxmstPartyRole getRoleFrom() {
		return roleFrom;
	}

	public void setRoleFrom(AhmjxmstPartyRole partyRoleFrom) {
		this.roleFrom = partyRoleFrom;
	}

	public AhmjxmstPartyRole getRoleTo() {
		return roleTo;
	}

	public void setRoleTo(AhmjxmstPartyRole roleTo) {
		this.roleTo = roleTo;
	}

	public AhmjxmstPartyRelationship() {
    }

	public Integer getIdRelation() {
		return idRelation;
	}

	public void setIdRelation(Integer idRelation) {
		this.idRelation = idRelation;
	}

	public Integer getIdRelationType() {
		return idRelationType;
	}

	public void setIdRelationType(Integer idRelationType) {
		this.idRelationType = idRelationType;
	}

	public Integer getIdStatusType() {
		return idStatusType;
	}

	public void setIdStatusType(Integer idStatusType) {
		this.idStatusType = idStatusType;
	}

	public DataPeriod getdataPeriod() {
		return dataPeriod;
	}

	public void setdataPeriod(DataPeriod period) {
		this.dataPeriod = period;
	}

	@Override
	protected void preUpdate() {
		super.preUpdate();
		if (dataPeriod == null) dataPeriod = new DataPeriod();
	}	

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
		.append( getIdRelation() )
		.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxmstPartyRelationship)) return false;
		AhmjxmstPartyRelationship other = (AhmjxmstPartyRelationship) obj;
		return new EqualsBuilder()
			.append( getIdRelation(), other.getIdRelation() )
			.isEquals();
	}	
}

