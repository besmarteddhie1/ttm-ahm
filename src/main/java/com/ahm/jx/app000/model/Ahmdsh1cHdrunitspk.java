/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author laurentinus
 */
@Entity
@Table(name = "AHMDSH1C_HDRUNITSPK",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VNOSPK", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cHdrunitspk extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VNOSPK",length=50, nullable=false)
    private String vnospk;  
    
    @Column(name="DSPKDATE",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dspkdate;
    
    @Column(name="VSALESTYPE",length=64, nullable=false)
    private String vidAhmdsbscDtlsettingVsalestype;
    
    @ManyToOne(targetEntity=AhmdsbscDtlsetting.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VSALESTYPE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscDtlsetting ahmdsbscDtlsettingVsalestype;
    
    @Column(name="VDEFPAYMENT",length=1, nullable=false)
    private String vdefpayment; 
    
    @Column(name="VID_AHMDSPIM_MSTFINCOY",length=64, nullable=false)
    private String vidAhmdspimMstfincoy;
    
    @ManyToOne(targetEntity=AhmdspimMstfincoy.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSPIM_MSTFINCOY",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdspimMstfincoy ahmdspimMstfincoy;
    
    @Column(name="VID_AHMDSH1C_MSTEMPLOYEE",length=64, nullable=false)
    private String vidAhmdsh1cMstemployee;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstemployee.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTEMPLOYEE",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstemployee ahmdsh1cMstemployee;
    
    @Column(name="VID_AHMDSH1C_MSTIDWHS",length=64, nullable=false)
    private String vidAhmdsh1cMstidwhs;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstidwhs.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTIDWHS",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstidwhs ahmdsh1cMstidwhs;
    
    @Column(name="VID_AHMDSH1C_MSTPROSPEK",length=64, nullable=false)
    private String vidAhmdsh1cMstprospek;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstprospek.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTPROSPEK",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstprospek ahmdsmunMstprospek;
    
    @Column(name="VSTATCANCEL",length=1)
    private String vstatcancel; 
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;

    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="ahmdsh1cHdrunitspk")    
    private List<Ahmdsh1cDtlunitspk> listAhmdsh1cDtlunitspk;
    
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="ahmdsh1cHdrunitspk")    
    private List<Ahmdsh1cDtlunitspkso> listAhmdsh1cDtlunitspkso;

    public String getVnospk() {
        return vnospk;
    }

    public void setVnospk(String vnospk) {
        this.vnospk = vnospk;
    }

    public Date getDspkdate() {
        return dspkdate;
    }

    public void setDspkdate(Date dspkdate) {
        this.dspkdate = dspkdate;
    }

    public String getVidAhmdsbscDtlsettingVsalestype() {
        return vidAhmdsbscDtlsettingVsalestype;
    }

    public void setVidAhmdsbscDtlsettingVsalestype(String vidAhmdsbscDtlsettingVsalestype) {
        this.vidAhmdsbscDtlsettingVsalestype = vidAhmdsbscDtlsettingVsalestype;
    }

    public AhmdsbscDtlsetting getAhmdsbscDtlsettingVsalestype() {
        return ahmdsbscDtlsettingVsalestype;
    }

    public void setAhmdsbscDtlsettingVsalestype(AhmdsbscDtlsetting ahmdsbscDtlsettingVsalestype) {
        this.ahmdsbscDtlsettingVsalestype = ahmdsbscDtlsettingVsalestype;
    }

    public String getVdefpayment() {
        return vdefpayment;
    }

    public void setVdefpayment(String vdefpayment) {
        this.vdefpayment = vdefpayment;
    }

    public String getVidAhmdspimMstfincoy() {
        return vidAhmdspimMstfincoy;
    }

    public void setVidAhmdspimMstfincoy(String vidAhmdspimMstfincoy) {
        this.vidAhmdspimMstfincoy = vidAhmdspimMstfincoy;
    }

    public AhmdspimMstfincoy getAhmdspimMstfincoy() {
        return ahmdspimMstfincoy;
    }

    public void setAhmdspimMstfincoy(AhmdspimMstfincoy ahmdspimMstfincoy) {
        this.ahmdspimMstfincoy = ahmdspimMstfincoy;
    }

    

    public String getVidAhmdsh1cMstemployee() {
        return vidAhmdsh1cMstemployee;
    }

    public void setVidAhmdsh1cMstemployee(String vidAhmdsh1cMstemployee) {
        this.vidAhmdsh1cMstemployee = vidAhmdsh1cMstemployee;
    }

    public Ahmdsh1cMstemployee getAhmdsh1cMstemployee() {
        return ahmdsh1cMstemployee;
    }

    public void setAhmdsh1cMstemployee(Ahmdsh1cMstemployee ahmdsh1cMstemployee) {
        this.ahmdsh1cMstemployee = ahmdsh1cMstemployee;
    }

    public String getVidAhmdsh1cMstidwhs() {
        return vidAhmdsh1cMstidwhs;
    }

    public void setVidAhmdsh1cMstidwhs(String vidAhmdsh1cMstidwhs) {
        this.vidAhmdsh1cMstidwhs = vidAhmdsh1cMstidwhs;
    }

    public Ahmdsh1cMstidwhs getAhmdsh1cMstidwhs() {
        return ahmdsh1cMstidwhs;
    }

    public void setAhmdsh1cMstidwhs(Ahmdsh1cMstidwhs ahmdsh1cMstidwhs) {
        this.ahmdsh1cMstidwhs = ahmdsh1cMstidwhs;
    }

    public String getVstatcancel() {
        return vstatcancel;
    }

    public void setVstatcancel(String vstatcancel) {
        this.vstatcancel = vstatcancel;
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

    public String getVidAhmdsh1cMstprospek() {
        return vidAhmdsh1cMstprospek;
    }

    public void setVidAhmdsh1cMstprospek(String vidAhmdsh1cMstprospek) {
        this.vidAhmdsh1cMstprospek = vidAhmdsh1cMstprospek;
    }

    public Ahmdsh1cMstprospek getAhmdsmunMstprospek() {
        return ahmdsmunMstprospek;
    }

    public void setAhmdsmunMstprospek(Ahmdsh1cMstprospek ahmdsmunMstprospek) {
        this.ahmdsmunMstprospek = ahmdsmunMstprospek;
    }

    public List<Ahmdsh1cDtlunitspk> getListAhmdsh1cDtlunitspk() {
        return listAhmdsh1cDtlunitspk;
    }

    public void setListAhmdsh1cDtlunitspk(List<Ahmdsh1cDtlunitspk> listAhmdsh1cDtlunitspk) {
        this.listAhmdsh1cDtlunitspk = listAhmdsh1cDtlunitspk;
    }

    public List<Ahmdsh1cDtlunitspkso> getListAhmdsh1cDtlunitspkso() {
        return listAhmdsh1cDtlunitspkso;
    }

    public void setListAhmdsh1cDtlunitspkso(List<Ahmdsh1cDtlunitspkso> listAhmdsh1cDtlunitspkso) {
        this.listAhmdsh1cDtlunitspkso = listAhmdsh1cDtlunitspkso;
    }

    
    
    
}
