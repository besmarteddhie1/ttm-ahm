package com.ahm.jx.ttm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;


@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Table(name = "AHMDSUAM_MSTUSRROLS")    
public class SecurityUserRole extends AhmBaseEntity {
    
	private static final long serialVersionUID = 2708307937115713991L;

	@ManyToOne
	@JoinColumn(name="vid_ahmdsuam_mstusers", referencedColumnName="vid")
	private SecurityUser user;
	
    @JoinColumn(name="vid_ahmdsuam_mstroles", referencedColumnName="vid") 
    private SecurityRole role;

    @Column(name="status") 
    private Boolean status;

	public SecurityUser getUser() {
		return user;
	}

	public void setUser(SecurityUser user) {
		this.user = user;
	}

	public SecurityRole getRole() {
		return role;
	}

	public void setRole(SecurityRole role) {
		this.role = role;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
    
}
