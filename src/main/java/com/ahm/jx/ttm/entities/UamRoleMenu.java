package com.ahm.jx.ttm.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sigit refactored by apri
 */

@Entity
@Table(name = "AHMJXUAM_HDRRLACCESS")
public class UamRoleMenu extends AhmBaseEntity {

	private static final long serialVersionUID = -4031508059474896902L;
	
	@ManyToOne
	@JoinColumn(name = "VID_AHMJXUAM_MSTROLES", referencedColumnName="vid")
	private UamRole role;
	
	@ManyToOne
	@JoinColumn(name = "VID_AHMJXUAM_MSTMENUS", referencedColumnName="vid")
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
