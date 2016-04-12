package com.ahm.jx.ttm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

@Entity
@Table(name="ahmjxmst_party")
@Inheritance(strategy=InheritanceType.JOINED)
public class AhmjxmstParty extends BaseEntity {

	private static final long serialVersionUID = -8438400975266936737L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="vidparty", nullable = false)
	private String idParty;
	
	public String getIdParty() {
		return idParty;
	}

	public void setIdParty(String idParty) {
		this.idParty = idParty;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="party")
	@Where(clause="current_timestamp between dtfrom and dtthru")
	private List<AhmjxmstPartyClassification> classification = new ArrayList<AhmjxmstPartyClassification>();
	
	public AhmjxmstPartyClassification setCategory(AhmjxmstPartyCategory c) {
		for (AhmjxmstPartyClassification o: classification) {
			if (o.getCategory().getCategoryType().equals(c.getCategoryType())) {
				if (o.getCategory().equals(c)) return o;
				o.getPeriods().endPeriod();
			}
		}
		
		AhmjxmstPartyClassification o = new AhmjxmstPartyClassification();
		o.setParty(this);
		o.setCategory(c);
		o.setPeriods(new DataPeriod());
		return o;
	}
	
	public AhmjxmstPartyCategory getCategory(Integer typeCat) {
		for (AhmjxmstPartyClassification o: classification) 
			if (o.getCategory().getCategoryType().getIdCategoryType().equals(typeCat))
				return o.getCategory();		
		return null;
	}	


	public void setClassification(List<AhmjxmstPartyClassification> classification) {
		this.classification = classification;
	}	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdParty())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmjxmstParty)) return false;
		AhmjxmstParty other = (AhmjxmstParty) obj;
		return new EqualsBuilder()
			.append( getIdParty(), other.getIdParty() )
			.isEquals();
	}		

}
