package com.ahm.jx.ttm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AHMJXUAM_MSTSERVICES")
public class UamService extends AhmBaseEntity {

	private static final long serialVersionUID = -2243681982762120954L;
	
	@Column(name = "VURL")
    private String url;

    @Column(name = "VSVCNAME")
    private String serviceName;

    @Column(name = "VSVCDESC")
    private String serviceDesc;

    @Column(name = "VSTAT", length = 1)
    private String status;

    @ManyToOne
    @JoinColumn(name = "VID_AHMJXUAM_MSTAPPS", referencedColumnName = "VID")
    private UamApps apps;


}