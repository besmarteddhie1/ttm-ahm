
package com.ahm.jx.ttm.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.hibernate.validator.constraints.Length;

import com.ahm.jx.ttm.config.EntityDomain;


@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Table(name = "ahmdsuam_mstusers")
public class SecurityUser extends AhmBaseEntity {

	private static final long serialVersionUID = -3594793515100006127L;

	@Length(max=EntityDomain.LENGTH_NAME)
	@Column(name = "VUSERNAME", length = EntityDomain.LENGTH_NAME, nullable = false, unique = true)
    private String userName;

    @Column(name = "VPASSWORD")
    private String password;    
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE")    
    private String dealerCode;
    
    @Column(name = "vstat")
    private Boolean status;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
    private List<SecurityUserRole> roles;

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

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}    
    
    /*
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class, fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE", referencedColumnName="VID", insertable=false, updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
 
    @OneToMany(mappedBy = "ahmdsuamMstusers")    
    private List<AhmdsuamMstusrrols> listAhmdsuamMstusrrolses;
    */    
    
}
