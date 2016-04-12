package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ahmjxuam_mstservices")
public class AhmjxUamService extends AhmBaseEntity {

	private static final long serialVersionUID = -2243681982762120954L;
	
	@Column(name = "vurl")
    private String url;

    @Column(name = "vsvcname")
    private String serviceName;

    @Column(name = "vsvdesc")
    private String serviceDesc;

    @Column(name = "vstat", length = 1)
    private String status;

    @ManyToOne
    @JoinColumn(name = "vid_ahmjxuam_mstapps", referencedColumnName = "vid")
    private AhmjxUamApps apps;

}