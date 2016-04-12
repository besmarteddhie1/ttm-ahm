package com.ahm.jx.ttm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ahmjxuam_mstapps")
public class AhmjxUamApps extends AhmBaseEntity {
	
	private static final long serialVersionUID = -2830096505388982211L;

	@Column(name = "vname")
    private String appName;

    @Column(name = "vdesc")
    private String appDesc;

    @Column(name = "vstat", length = 1)
    private String status;

    @OneToMany(mappedBy = "apps", cascade=CascadeType.ALL)
    private List<AhmjxUamService> services;
        
}
