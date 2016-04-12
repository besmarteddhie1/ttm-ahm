package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ahm.jx.ttm.model.AhmBaseEntity;
import com.ahm.jx.ttm.model.AhmjxUamMenu;

/*
 * @author sigit refactored by apri
 */

@Entity
@Table(name = "ahmjxuam_hdrrlaccess")
public class AhmjxUamRoleMenu extends AhmBaseEntity {

	private static final long serialVersionUID = -4031508059474896902L;
	
	@Column(name = "vid_ahmjxuam_mstroles")
	private String idRole;
	
	@Column(name = "vid_ahmjxuam_mstmenus")
	private String idMenu;	
	
	@ManyToOne
	@JoinColumn(name = "vid_ahmjxuam_mstroles", referencedColumnName="vid", insertable=false, updatable=false)
	private AhmjxUamRole role;
	
	@ManyToOne
	@JoinColumn(name = "vid_ahmjxuam_mstmenus", referencedColumnName="vid", insertable=false, updatable=false)
	private AhmjxUamMenu menu;

	public AhmjxUamRole getRole() {
		return role;
	}

	public void setRole(AhmjxUamRole role) {
		this.role = role;
	}

	public AhmjxUamMenu getMenu() {
		return menu;
	}

	public void setMenu(AhmjxUamMenu menu) {
		this.menu = menu;
	}

}
