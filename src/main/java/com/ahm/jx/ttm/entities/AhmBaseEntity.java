package com.ahm.jx.ttm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

import com.ahm.jx.ttm.config.EntityDomain;

@MappedSuperclass
@Audited
public class AhmBaseEntity implements Serializable {

	private static final long serialVersionUID = 5621497326705047937L;

	@Id
	@Length(max = EntityDomain.LENGTH_ID)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="VID", length=EntityDomain.LENGTH_ID)
	private String id;
	
	@Column(name="VCREABY")
	private String createBy;
	
	@Column(name="VMODIBY")
	private String modiBy;		
	
	@Version
	@Column(name="IVER")
	private Integer lockVersion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DCREA")
	private Date dateCreate;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DMODI")
	private Date dateModi;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModiBy() {
		return modiBy;
	}

	public void setModiBy(String modiBy) {
		this.modiBy = modiBy;
	}

	public Integer getLockVersion() {
		return lockVersion;
	}

	public void setLockVersion(Integer lockVersion) {
		this.lockVersion = lockVersion;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateModi() {
		return dateModi;
	}

	public void setDateModi(Date dateModi) {
		this.dateModi = dateModi;
	}
	
	@PrePersist
	@PreUpdate
	protected void preUpdate() {
		if (dateCreate == null) dateCreate = new Date();
		dateModi = new Date();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmBaseEntity)) return false;
		AhmBaseEntity other = (AhmBaseEntity) obj;
		return new EqualsBuilder()
			.append( getId(), other.getId() )
			.isEquals();
	}	
	
}
