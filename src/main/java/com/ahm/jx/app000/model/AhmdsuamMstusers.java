/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.ahm.jx.common.model.BaseAuditVersioning;

/**
 *
 * @author AFI
 */

@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Table(name = "AHMDSUAM_MSTUSERS")
public class AhmdsuamMstusers extends BaseAuditVersioning {

	private static final long serialVersionUID = -3594793515100006127L;

	@Column(name = "VUSERNAME", length = 30, nullable = false, unique = true)
    private String vusername;

    @Column(name = "VPASSWORD")
    private String vpassword;    
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE")    
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class, fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE", referencedColumnName="VID", insertable=false, updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
 
    @OneToMany(mappedBy = "ahmdsuamMstusers")    
    private List<AhmdsuamMstusrrols> listAhmdsuamMstusrrolses;
    
    @Column(name = "VSTAT", length=1)
    private String vstat;

    public String getVusername() {
        return vusername;
    }

    public void setVusername(String vusername) {
        this.vusername = vusername;
    }

    public String getVpassword() {
        return vpassword;
    }

    public void setVpassword(String vpassword) {
        this.vpassword = vpassword;
    }
    
    public List<AhmdsuamMstusrrols> getListAhmdsuamMstusrrolses() {
        return listAhmdsuamMstusrrolses;
    }

    public void setListAhmdsuamMstusrrolses(List<AhmdsuamMstusrrols> listAhmdsuamMstusrrolses) {
        this.listAhmdsuamMstusrrolses = listAhmdsuamMstusrrolses;
    }

    public String getVidAhmdsbscMstdlrcode() {
        return vidAhmdsbscMstdlrcode;
    }

    public void setVidAhmdsbscMstdlrcode(String vidAhmdsbscMstdlrcode) {
        this.vidAhmdsbscMstdlrcode = vidAhmdsbscMstdlrcode;
    }

    public AhmdsbscMstdlrcode getAhmdsbscMstdlrcode() {
        return ahmdsbscMstdlrcode;
    }

    public void setAhmdsbscMstdlrcode(AhmdsbscMstdlrcode ahmdsbscMstdlrcode) {
        this.ahmdsbscMstdlrcode = ahmdsbscMstdlrcode;
    }

    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }
}
