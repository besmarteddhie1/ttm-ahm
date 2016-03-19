package com.ahm.jx.ttm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Table(name="ahmdsuam_mstroles")

public class SecurityRole extends AhmBaseEntity {
    
	private static final long serialVersionUID = 4847222996650784545L;

	@Column(name="VROLES_ID",length = 20, nullable = false, unique = true) 
    private String idRole;
    
    @Column(name="VROLES_NAME",length = 30) 
    private String name;
    
    @Column(name="VROLES_DESC",length = 255) 
    private String description;    
    
    @Column(name="VROLES_STATUS",length = 1) 
    private Boolean status;

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
    
    /*
    @OneToMany(mappedBy = "ahmdsuamMstroles")    
    private List<AhmdsuamMstusrrols> listAhmdsuamMstusrrolses;
    
    @OneToMany(mappedBy = "ahmdsuamMstroles")    
    private List<AhmdsuamHdrrlaccess> listAhmdsuamHdrrlaccesses;
    */

}
