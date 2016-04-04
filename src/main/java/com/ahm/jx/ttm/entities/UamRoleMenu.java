package com.ahm.jx.ttm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * @author sigit refactored by apri
 */

@Entity
@Table(name = "ahmjxuam_hdrrlaccess")
public class UamRoleMenu extends AhmBaseEntity {

	private static final long serialVersionUID = -4031508059474896902L;
	
	@Column(name = "vid_ahmjxuam_mstroles")
	private String idRole;
	
	@Column(name = "vid_ahmjxuam_mstmenus")
	private String idMenu;	
	
	@ManyToOne
	@JoinColumn(name = "vid_ahmjxuam_mstroles", referencedColumnName="vid", insertable=false, updatable=false)
	private UamRole role;
	
	@ManyToOne
	@JoinColumn(name = "vid_ahmjxuam_mstmenus", referencedColumnName="vid", insertable=false, updatable=false)
	private UamMenu menu;

	public UamRole getRole() {
		return role;
	}

	public void setRole(UamRole role) {
		this.role = role;
	}

	public UamMenu getMenu() {
		return menu;
	}

	public void setMenu(UamMenu menu) {
		this.menu = menu;
	}

}
