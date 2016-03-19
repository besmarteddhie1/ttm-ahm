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
 * @author achmad.ha
 */
@Entity
@Table(name = "AHMDSH1C_MSTIDWHS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VIDWHS", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cMstidwhs extends BaseAuditVersioning implements Serializable{
           
    @Column(name="VIDWHS",length=6,nullable=false)
    private String vidwhs;
    
    @Column(name="VWHSDESC",length=30)
    private String vwhsdesc;
    
    @Column(name="VADDRESS",length=100)
    private String vaddress;
    
    @Column(name="VID_AHMDSH1C_MSTCITY",length=64)
    private String vidAhmdsh1cMstcity;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstcity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTCITY",referencedColumnName = "VID",insertable = false,updatable = false)
    private Ahmdsh1cMstcity ahmdsh1cMstcity;
    
    @ManyToOne(targetEntity=AhmdsbscDtlsetting.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VTYPEWHS",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscDtlsetting ahmdsbscDtlsettingVtypewhs;
    
    @Column(name="VTYPEWHS",length=64)
    private String vidAhmdsbscDtlsettingVtypewhs;
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    public String getVidwhs() {
        return vidwhs;
    }

    public void setVidwhs(String vidwhs) {
        this.vidwhs = vidwhs;
    }

    public String getVwhsdesc() {
        return vwhsdesc;
    }

    public void setVwhsdesc(String vwhsdesc) {
        this.vwhsdesc = vwhsdesc;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getVidAhmdsh1cMstcity() {
        return vidAhmdsh1cMstcity;
    }

    public void setVidAhmdsh1cMstcity(String vidAhmdsh1cMstcity) {
        this.vidAhmdsh1cMstcity = vidAhmdsh1cMstcity;
    }
    
    public Ahmdsh1cMstcity getAhmdsh1cMstcity() {
        return ahmdsh1cMstcity;
    }

    public void setAhmdsh1cMstcity(Ahmdsh1cMstcity ahmdsh1cMstcity) {
        this.ahmdsh1cMstcity = ahmdsh1cMstcity;
    }

    public AhmdsbscDtlsetting getAhmdsbscDtlsettingVtypewhs() {
        return ahmdsbscDtlsettingVtypewhs;
    }

    public void setAhmdsbscDtlsettingVtypewhs(AhmdsbscDtlsetting ahmdsbscDtlsettingVtypewhs) {
        this.ahmdsbscDtlsettingVtypewhs = ahmdsbscDtlsettingVtypewhs;
    }

    public String getVidAhmdsbscDtlsettingVtypewhs() {
        return vidAhmdsbscDtlsettingVtypewhs;
    }

    public void setVidAhmdsbscDtlsettingVtypewhs(String vidAhmdsbscDtlsettingVtypewhs) {
        this.vidAhmdsbscDtlsettingVtypewhs = vidAhmdsbscDtlsettingVtypewhs;
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
}
