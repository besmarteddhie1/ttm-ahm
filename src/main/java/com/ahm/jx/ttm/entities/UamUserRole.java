package com.ahm.jx.ttm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ahmjxuam_mstusrrols")    
public class UamUserRole extends AhmBaseEntity {
    
	private static final long serialVersionUID = 2708307937115713991L;

	@ManyToOne
	@JoinColumn(name="vid_ahmjxuam_mstusers", referencedColumnName="vid")
	private UamUser user;
	
    @JoinColumn(name="vid_ahmjxuam_mstroles", referencedColumnName="vid") 
    private UamRole role;

    @Column(name="vstatus") 
    private Boolean status;    

	public UamUser getUser() {
		return user;
	}

	public void setUser(UamUser user) {
		this.user = user;
	}

	public UamRole getRole() {
		return role;
	}

	public void setRole(UamRole role) {
		this.role = role;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
