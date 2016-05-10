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
@Table(name="ahmjxmst_dealer_calendar")
@Inheritance(strategy=InheritanceType.JOINED)
public class AhmJxMstCalendar extends BaseEntity {
		
	private static final long serialVersionUID = -1395780620483866551L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="vidcalendar", nullable = false)
	private String idCalendar;
	
	@Column(name="vdescription")
	private String description;
	
	@Column(name="iseq")
	private Integer sequence;
	
	@Column(name="visworkday")
	private String isWorkDay;
	
	private DataPeriod period;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getIsWorkDay() {
		return isWorkDay;
	}

	public void setIsWorkDay(String isWorkDay) {
		this.isWorkDay = isWorkDay;
	}

	public DataPeriod getPeriod() {
		return period;
	}

	public void setPeriod(DataPeriod period) {
		this.period = period;
	}

	public String getIdCalendar() {
		return idCalendar;
	}

	public void setIdCalendar(String idCalendar) {
		this.idCalendar = idCalendar;
	}
	
	@Override
	protected void preUpdate() {
		super.preUpdate();
		if (period == null) period = new DataPeriod();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdCalendar())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmJxMstCalendar)) return false;
		AhmJxMstCalendar other = (AhmJxMstCalendar) obj;
		return new EqualsBuilder()
			.append( getIdCalendar(), other.getIdCalendar() )
			.isEquals();
	}		

}
