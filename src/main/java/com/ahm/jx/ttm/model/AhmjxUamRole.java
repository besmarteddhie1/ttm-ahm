package com.ahm.jx.ttm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ahm.jx.ttm.model.AhmBaseEntity;
import com.ahm.jx.ttm.model.AhmjxUamMenu;

@Entity
@Table(name="ahmjxuam_mstroles")
public class AhmjxUamRole extends AhmBaseEntity {
    
	private static final long serialVersionUID = 4847222996650784545L;

	@Column(name="vroles_id",length = 20, nullable = false, unique = true) 
    private String idRole;
    
    @Column(name="vroles_name", length = 30) 
    private String name;
    
    @Column(name="vroles_desc",length = 255) 
    private String description;    
    
    @Column(name="vrole_status",length = 1) 
    private Boolean status;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="role")
    @OrderBy("menu.iorder")
    private List<AhmjxUamRoleMenu> roleMenu;
    
    @Transient
    private List<AhmjxUamMenu> menus;    

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<AhmjxUamRoleMenu> getRoleMenu() {
		return roleMenu;
	}

	public void setRoleMenu(List<AhmjxUamRoleMenu> roleMenu) {
		this.roleMenu = roleMenu;
	}

	public List<AhmjxUamMenu> getMenus() {
		if (this.menus == null) {
			this.menus = new ArrayList<AhmjxUamMenu>();
			for (AhmjxUamRoleMenu u: getRoleMenu()) 
				this.menus.add(u.getMenu());
		}		
		return menus;
	}

	public void setMenus(List<AhmjxUamMenu> menus) {
		this.menus = menus;
	}
    
}
