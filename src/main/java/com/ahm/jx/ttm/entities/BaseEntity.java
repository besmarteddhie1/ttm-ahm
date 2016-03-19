package com.ahm.jx.ttm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 5621497326705047937L;
	
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="lastupdate")
	private Date lastUpdate;

}
