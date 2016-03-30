
package com.ahm.jx.ttm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.ahm.jx.ttm.config.EntityDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

/**
 *
 * @author sigit, refactoring by apri
 */

@Entity
@Table(name = "ahmjxuam_mstmenus")
public class UamMenu extends AhmBaseEntity {

	private static final long serialVersionUID = 5743125358008818944L;

	@Column(name = "vmenu_id", length = 16, nullable = false)
    private String idMenu;

    @Column(name = "vtitle", length = EntityDomain.LENGTH_NAME, nullable = false)
    private String title;

    @Column(name = "vurl", length = 128, nullable = true)
    private String url;

    @Column(name = "vapplication_id", length = 16, unique = true)
    private String idApplication;

    @Column(name = "vstat", length = 1)
    private Boolean status;

    @Column(name = "vicon", length = 128)
    private String icon;

    @Column(name = "iorder", length = 3)
    private Integer iorder;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vparent")
    private UamMenu parent;

    /*
    @OneToMany(cascade=CascadeType.ALL, mappedBy="parent")
    private List<UamMenu> child = new ArrayList<UamMenu>();
    */

	public String getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(String idApplication) {
		this.idApplication = idApplication;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getIorder() {
		return iorder;
	}

	public void setIorder(Integer iorder) {
		this.iorder = iorder;
	}

	public UamMenu getParent() {
		return parent;
	}
	
	public String getParentIdMenu() {
		if (this.parent != null) return parent.idMenu;
		return null;
	}	

	public void setParent(UamMenu parent) {
		this.parent = parent;
	}

}
