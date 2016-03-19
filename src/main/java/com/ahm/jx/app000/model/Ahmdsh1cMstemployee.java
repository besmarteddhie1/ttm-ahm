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
@Table(name = "AHMDSH1C_MSTEMPLOYEE",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VIDEMPLOYEE", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cMstemployee extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VIDEMPLOYEE",length=6,nullable=false)
    private String videmployee;
    
    @Column(name="VNAME",length=30)
    private String vname;
    
    @Column(name="VSTAT",length=1)
    private String vstat;  
    
    @Column(name="VTYPEEMPLOY",length=64,nullable=false)
    private String vtypeemploy;
    
    @ManyToOne(fetch= FetchType.LAZY,targetEntity=AhmdsbscDtlsetting.class)
    @JoinColumn(name="VTYPEEMPLOY",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscDtlsetting ahmdsbscDtlsettingTypeEmploy;
    
    @Column(name="VLEVEL",length=64,nullable=false)
    private String vlevel;
    
    @ManyToOne(fetch= FetchType.LAZY,targetEntity=AhmdsbscDtlsetting.class)
    @JoinColumn(name="VLEVEL",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscDtlsetting ahmdsbscDtlsettingLevel;
    
    @Column(name="VIDFLP",length=6)    
    private String vidflp;
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VB2BID",length=40)
    private String vb2bid;
    
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    @Column(name="NPIT")
    private Integer npit;

    public AhmdsbscDtlsetting getAhmdsbscDtlsettingTypeEmploy() {
        return ahmdsbscDtlsettingTypeEmploy;
    }

    public void setAhmdsbscDtlsettingTypeEmploy(AhmdsbscDtlsetting ahmdsbscDtlsettingTypeEmploy) {
        this.ahmdsbscDtlsettingTypeEmploy = ahmdsbscDtlsettingTypeEmploy;
    }

    public String getVlevel() {
        return vlevel;
    }

    public void setVlevel(String vlevel) {
        this.vlevel = vlevel;
    }

    public AhmdsbscDtlsetting getAhmdsbscDtlsettingLevel() {
        return ahmdsbscDtlsettingLevel;
    }

    public void setAhmdsbscDtlsettingLevel(AhmdsbscDtlsetting ahmdsbscDtlsettingLevel) {
        this.ahmdsbscDtlsettingLevel = ahmdsbscDtlsettingLevel;
    }
    
    public String getVidemployee() {
        return videmployee;
    }

    public void setVidemployee(String videmployee) {
        this.videmployee = videmployee;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

    public String getVtypeemploy() {
        return vtypeemploy;
    }

    public void setVtypeemploy(String vtypeemploy) {
        this.vtypeemploy = vtypeemploy;
    }

    public String getVidflp() {
        return vidflp;
    }

    public void setVidflp(String vidflp) {
        this.vidflp = vidflp;
    }

    public String getVb2bstat() {
        return vb2bstat;
    }

    public void setVb2bstat(String vb2bstat) {
        this.vb2bstat = vb2bstat;
    }

    public String getVb2bid() {
        return vb2bid;
    }

    public void setVb2bid(String vb2bid) {
        this.vb2bid = vb2bid;
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
    
    public Integer getNpit() {
        return npit;
    }

    public void setNpit(Integer npit) {
        this.npit = npit;
    }    
    
}
