package com.ahm.jx.ttm.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AHMJXUAM_MSTAPPS")
public class UamApps extends AhmBaseEntity {
	
	private static final long serialVersionUID = -2830096505388982211L;

	@Column(name = "VNAME")
    private String appName;

    @Column(name = "VDESC")
    private String appDesc;

    @Column(name = "VSTAT", length = 1)
    private String status;

    @OneToMany(mappedBy = "apps", cascade=CascadeType.ALL)
    private List<UamService> services;
    
    

}
