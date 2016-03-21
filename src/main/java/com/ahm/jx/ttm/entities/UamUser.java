
package com.ahm.jx.ttm.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;

import com.ahm.jx.ttm.config.EntityDomain;


@Entity
@Table(name = "ahmjxuam_mstusers")
public class UamUser extends AhmBaseEntity {

	private static final long serialVersionUID = -3594793515100006127L;

	@Length(max=EntityDomain.LENGTH_NAME)
	@Column(name = "VUSERNAME", length = EntityDomain.LENGTH_NAME, nullable = false, unique = true)
    private String userName;

    @Column(name = "VPASSWORD")
    private String password;    
    
    @ManyToOne
    @JoinColumn(name="VID_AHMJXUAM_MSTPARTNER", referencedColumnName="vid")    
    private AhmPartner partner;
    
    @Column(name = "vstat")
    private Boolean status;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
    private List<UamUserRole> userRoles;
    
    @Transient
    private List<UamRole> roles;
    
    @Transient
    private List<UamMenu> menus;
    
    @Transient
    private Map<String, UamMenu> hashMenus;    

	public List<UamUserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UamUserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<UamRole> getRoles() {
		if (this.roles == null) {
			this.roles = new ArrayList<UamRole>();
			for (UamUserRole u: userRoles) 
				if (u.getStatus()) this.roles.add(u.getRole());
		}
		return roles;
	}

	public void setRoles(List<UamRole> roles) {
		this.roles = roles;
	}

	public List<UamMenu> getMenus() {
		if (this.menus == null) {
			this.menus = new ArrayList<UamMenu>();
			for (UamRole u: getRoles()) 
				for (UamMenu m: u.getMenus())
					if (!this.menus.contains(m)) 
						this.menus.add(m);
		}		
		return menus;
	}

	public void setMenus(List<UamMenu> menus) {
		this.menus = menus;
	}

	public AhmPartner getPartner() {
		return partner;
	}

	public void setPartner(AhmPartner partner) {
		this.partner = partner;
	}    
    
    
}
