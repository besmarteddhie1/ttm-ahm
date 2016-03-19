/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author george
 */
@Entity
@Table(name="AHMDSH1C_MSTACCESSORIES",
        uniqueConstraints=@UniqueConstraint(columnNames={"VACCSCODE","VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cMstaccessories extends BaseAuditVersioning implements Serializable{
    @Column(name="VACCSCODE",length=20,nullable=false)
    private String vaccscode;
    
    @Column(name="VACCSDESC",length=30)
    private String vaccsdesc;
    
    @Column(name="VTYPE",length=1)
    private String vtype;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",length=64,nullable=false)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    @Column(name = "VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name = "VIDB2B",length=40)
    private String vidb2b;

    public String getVaccscode() {
        return vaccscode;
    }

    public void setVaccscode(String vaccscode) {
        this.vaccscode = vaccscode;
    }

    public String getVaccsdesc() {
        return vaccsdesc;
    }

    public void setVaccsdesc(String vaccsdesc) {
        this.vaccsdesc = vaccsdesc;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getVidAhmdsbscMstdlrcode() {
        return vidAhmdsbscMstdlrcode;
    }

    public void setVidAhmdsbscMstdlrcode(String vidAhmdsbscMstdlrcode) {
        this.vidAhmdsbscMstdlrcode = vidAhmdsbscMstdlrcode;
    }

    public String getVb2bstat() {
        return vb2bstat;
    }

    public void setVb2bstat(String vb2bstat) {
        this.vb2bstat = vb2bstat;
    }

    public String getVidb2b() {
        return vidb2b;
    }

    public void setVidb2b(String vidb2b) {
        this.vidb2b = vidb2b;
    }

    public AhmdsbscMstdlrcode getAhmdsbscMstdlrcode() {
        return ahmdsbscMstdlrcode;
    }

    public void setAhmdsbscMstdlrcode(AhmdsbscMstdlrcode ahmdsbscMstdlrcode) {
        this.ahmdsbscMstdlrcode = ahmdsbscMstdlrcode;
    }
    
}
