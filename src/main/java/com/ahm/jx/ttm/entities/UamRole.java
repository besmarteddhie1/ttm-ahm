package com.ahm.jx.ttm.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Table(name="ahmdsuam_mstroles")
public class UamRole extends AhmBaseEntity {
    
	private static final long serialVersionUID = 4847222996650784545L;

	@Column(name="VROLES_ID",length = 20, nullable = false, unique = true) 
    private String idRole;
    
    @Column(name="VROLES_NAME",length = 30) 
    private String name;
    
    @Column(name="VROLES_DESC",length = 255) 
    private String description;    
    
    @Column(name="VROLES_STATUS",length = 1) 
    private Boolean status;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="role")
    private List<UamRoleMenu> roleMenu;
    
    @Transient
    private List<UamMenu> menus;    

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

	public List<UamRoleMenu> getRoleMenu() {
		return roleMenu;
	}

	public void setRoleMenu(List<UamRoleMenu> roleMenu) {
		this.roleMenu = roleMenu;
	}

	public List<UamMenu> getMenus() {
		if (this.menus == null) {
			this.menus = new ArrayList<UamMenu>();
			for (UamRoleMenu u: roleMenu) 
				this.menus.add(u.getMenu());
		}		
		return menus;
	}

	public void setMenus(List<UamMenu> menus) {
		this.menus = menus;
	}
    
}
