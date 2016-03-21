
package com.ahm.jx.ttm.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.ahm.jx.ttm.config.EntityDomain;

/**
 *
 * @author sigit, refactoring by apri
 */

@Entity
@Table(name = "ahmjxuam_mstmenus")
public class UamMenu extends AhmBaseEntity {

	private static final long serialVersionUID = 5743125358008818944L;

	@Column(name = "VMENU_ID", length = 16, nullable = false)
    private String idMenu;

    @Column(name = "VTITLE", length = EntityDomain.LENGTH_NAME, nullable = false)
    private String tittle;

    @Column(name = "VURL", length = 128, nullable = true)
    private String url;

    @Column(name = "VAPPLICATION_ID", length = 16, unique = true)
    private String idApplication;

    @Column(name = "VSTAT", length = 1)
    private Boolean status;

    @Column(name = "VICON", length = 128)
    private String icon;

    @Column(name = "IORDER", length = 3)
    private Integer iorder;

    @ManyToOne
    @JoinColumn(name = "vparent", referencedColumnName = "vid")
    @NotFound(action = NotFoundAction.IGNORE)
    private UamMenu parent;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="parent")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<UamMenu> child;

	public String getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
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

	public void setParent(UamMenu parent) {
		this.parent = parent;
	}

	public List<UamMenu> getChild() {
		return child;
	}

	public void setChild(List<UamMenu> child) {
		this.child = child;
	}


}
