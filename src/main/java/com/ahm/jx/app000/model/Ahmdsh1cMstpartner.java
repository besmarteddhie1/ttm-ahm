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
@Table(name = "AHMDSH1C_MSTPARTNER",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VIDPRTNCODE", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cMstpartner extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VIDPRTNCODE",length=6,nullable=false)
    private String vidprtncode;
    
    @Column(name="VPARTNERDESC",length=30)
    private String vpartnerdesc;
        
    @Column(name="VTYPEPRT",length=64)
    private String vidAhmdsbscDtlsettingVtypeprt;
        
    @ManyToOne(targetEntity=AhmdsbscDtlsetting.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VTYPEPRT",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscDtlsetting ahmdsbscDtlsettingVtypeprt;
    
    @Column(name="VPICNAME",length=255,nullable=false)
    private String vpicname;
    
    @Column(name="VSTAT",length=1)
    private String vstat;
    
    @Column(name="VIDAHMPRTNCODE",length=10)
    private String vidahmprtncode;
    
    @Column(name="VADDRESS",length=100)
    private String vaddress;
    
    @Column(name="VID_AHMDSH1C_MSTKELURAHAN",length=64,nullable=false)
    private String vidAhmdsh1cMstkelurahan;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstkelurahan.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTKELURAHAN",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstkelurahan ahmdsh1cMstkelurahan;
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
        
    @Column(name="VIDB2B",length=40)
    private String vidb2b;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;

    public String getVidprtncode() {
        return vidprtncode;
    }

    public void setVidprtncode(String vidprtncode) {
        this.vidprtncode = vidprtncode;
    }

    public String getVpartnerdesc() {
        return vpartnerdesc;
    }

    public void setVpartnerdesc(String vpartnerdesc) {
        this.vpartnerdesc = vpartnerdesc;
    }

    public String getVidAhmdsbscDtlsettingVtypeprt() {
        return vidAhmdsbscDtlsettingVtypeprt;
    }

    public void setVidAhmdsbscDtlsettingVtypeprt(String vidAhmdsbscDtlsettingVtypeprt) {
        this.vidAhmdsbscDtlsettingVtypeprt = vidAhmdsbscDtlsettingVtypeprt;
    }

    public AhmdsbscDtlsetting getAhmdsbscDtlsettingVtypeprt() {
        return ahmdsbscDtlsettingVtypeprt;
    }

    public void setAhmdsbscDtlsettingVtypeprt(AhmdsbscDtlsetting ahmdsbscDtlsettingVtypeprt) {
        this.ahmdsbscDtlsettingVtypeprt = ahmdsbscDtlsettingVtypeprt;
    }

    public String getVpicname() {
        return vpicname;
    }

    public void setVpicname(String vpicname) {
        this.vpicname = vpicname;
    }

    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

    public String getVidahmprtncode() {
        return vidahmprtncode;
    }

    public void setVidahmprtncode(String vidahmprtncode) {
        this.vidahmprtncode = vidahmprtncode;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getVidAhmdsh1cMstkelurahan() {
        return vidAhmdsh1cMstkelurahan;
    }

    public void setVidAhmdsh1cMstkelurahan(String vidAhmdsh1cMstkelurahan) {
        this.vidAhmdsh1cMstkelurahan = vidAhmdsh1cMstkelurahan;
    }

    public Ahmdsh1cMstkelurahan getAhmdsh1cMstkelurahan() {
        return ahmdsh1cMstkelurahan;
    }

    public void setAhmdsh1cMstkelurahan(Ahmdsh1cMstkelurahan ahmdsh1cMstkelurahan) {
        this.ahmdsh1cMstkelurahan = ahmdsh1cMstkelurahan;
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
