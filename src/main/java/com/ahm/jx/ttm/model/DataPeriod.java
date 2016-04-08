package com.ahm.jx.ttm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

@Embeddable
public class DataPeriod implements Serializable {
	
	private static final long serialVersionUID = 721872476808289116L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dtfrom")
	private Date dateFrom;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dtthru")
	private Date dateThru;
	
	public DataPeriod() {
	}
	
	public DataPeriod(Date start) {
		this.setDateFrom(start);
		this.setDateThru(new DateTime(9999, 12, 31, 23, 59, 59, 999).toDate());
	}
	
	public void endPeriod() {
		this.setDateThru(new Date());
	}
	
	public Boolean isValid() {
		Date d = new Date();
		return d.after(dateFrom) && d.before(dateThru);
	}	
	
	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateThru() {
		return dateThru;
	}

	public void setDateThru(Date dateThru) {
		this.dateThru = dateThru;
	}	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getDateFrom())
			.append(getDateThru())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DataPeriod)) return false;
		DataPeriod other = (DataPeriod) obj;
		return new EqualsBuilder()
			.append( getDateFrom(), other.getDateFrom() )
			.append( getDateThru(), other.getDateThru() )
			.isEquals();
	}		

}
