package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.ahm.jx.ttm.model.AhmBaseEntity;

@Entity
@Table(name = "ahmjxuam_mstusrrols")    
public class AhmjxUamUserRole extends AhmBaseEntity {
    
	private static final long serialVersionUID = 2708307937115713991L;

	@ManyToOne
	@JoinColumn(name="vid_ahmjxuam_mstusers", referencedColumnName="vid")
	@NotFound(action = NotFoundAction.IGNORE)
	private AhmjxUamUser user;
	
	@ManyToOne
    @JoinColumn(name="vid_ahmjxuam_mstroles", referencedColumnName="vid")
	@NotFound(action = NotFoundAction.IGNORE)
    private AhmjxUamRole role;

    @Column(name="vstatus") 
    private Boolean status;    

	public AhmjxUamUser getUser() {
		return user;
	}

	public void setUser(AhmjxUamUser user) {
		this.user = user;
	}

	public AhmjxUamRole getRole() {
		return role;
	}

	public void setRole(AhmjxUamRole role) {
		this.role = role;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
