/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author achmad.ha
 */
@Entity
@Table(name = "AHMDSH1C_HDRUNITRCV",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VIDSHIPLIST", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cHdrunitrcv extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VID_AHMDSH1C_HDRUNITPO",length=64)
    private String vidAhmdsh1cHdrunitpo;    
    
    @ManyToOne(targetEntity=Ahmdsh1cHdrunitpo.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_HDRUNITPO",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cHdrunitpo ahmdsh1cHdrunitpo;
    
    @Column(name="VIDSHIPLIST",length=100)
    private String vidshiplist; 
    
    @Column(name="DSHIPLIST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dshiplist;
    
    @Column(name="DRECEIVE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dreceive;
    
    @Column(name="VID_AHMDSH1C_HDRUNITINVMD",length=64)
    private String vidAhmdsh1cHdrunitinvmd;    
    
    @ManyToOne(targetEntity=Ahmdsh1cHdrunitinvmd.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_HDRUNITINVMD",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cHdrunitinvmd ahmdsh1cHdrunitinvmd;
    
    @Column(name="VID_AHMDSH1C_MSTPARTNER",length=64, nullable=false)
    private String vidAhmdsh1cMstpartner;    
    
    @ManyToOne(targetEntity=Ahmdsh1cMstpartner.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTPARTNER",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstpartner ahmdsh1cMstpartner;
    
    @Column(name="VNOPOLTRUCK",length=10, nullable=false)
    private String vnopoltruck; 
    
    @Column(name="VDRIVER",length=20, nullable=false)
    private String vdriver; 
    
    @Column(name="VTYPERCV",length=64)
    private String vidAhmdsbscDtlsettingVtypercv;
    
    @ManyToOne(targetEntity=AhmdsbscDtlsetting.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VTYPERCV",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscDtlsetting ahmdsbscDtlsettingVtypercv;
    
    @Column(name="VRCVREFDOC",length=30)
    private String vrcvrefdoc;
    
    @Column(name="VFROM",length=6)
    private String vfrom;
    
    @Column(name="VTO",length=6)
    private String vto;
    
    @Column(name="VTPCODE",length=30)
    private String vtpcode;
    
    @Column(name="VTYPEGOODS",length=1)
    private String vtypegoods;
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;

    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;

    public String getVidAhmdsh1cHdrunitpo() {
        return vidAhmdsh1cHdrunitpo;
    }

    public void setVidAhmdsh1cHdrunitpo(String vidAhmdsh1cHdrunitpo) {
        this.vidAhmdsh1cHdrunitpo = vidAhmdsh1cHdrunitpo;
    }

    public Ahmdsh1cHdrunitpo getAhmdsh1cHdrunitpo() {
        return ahmdsh1cHdrunitpo;
    }

    public void setAhmdsh1cHdrunitpo(Ahmdsh1cHdrunitpo ahmdsh1cHdrunitpo) {
        this.ahmdsh1cHdrunitpo = ahmdsh1cHdrunitpo;
    }

    public String getVidshiplist() {
        return vidshiplist;
    }

    public void setVidshiplist(String vidshiplist) {
        this.vidshiplist = vidshiplist;
    }

    public Date getDshiplist() {
        return dshiplist;
    }

    public void setDshiplist(Date dshiplist) {
        this.dshiplist = dshiplist;
    }

    public Date getDreceive() {
        return dreceive;
    }

    public void setDreceive(Date dreceive) {
        this.dreceive = dreceive;
    }

    public String getVidAhmdsh1cHdrunitinvmd() {
        return vidAhmdsh1cHdrunitinvmd;
    }

    public void setVidAhmdsh1cHdrunitinvmd(String vidAhmdsh1cHdrunitinvmd) {
        this.vidAhmdsh1cHdrunitinvmd = vidAhmdsh1cHdrunitinvmd;
    }

    public Ahmdsh1cHdrunitinvmd getAhmdsh1cHdrunitinvmd() {
        return ahmdsh1cHdrunitinvmd;
    }

    public void setAhmdsh1cHdrunitinvmd(Ahmdsh1cHdrunitinvmd ahmdsh1cHdrunitinvmd) {
        this.ahmdsh1cHdrunitinvmd = ahmdsh1cHdrunitinvmd;
    }
    
    public String getVidAhmdsh1cMstpartner() {
        return vidAhmdsh1cMstpartner;
    }

    public void setVidAhmdsh1cMstpartner(String vidAhmdsh1cMstpartner) {
        this.vidAhmdsh1cMstpartner = vidAhmdsh1cMstpartner;
    }

    public Ahmdsh1cMstpartner getAhmdsh1cMstpartner() {
        return ahmdsh1cMstpartner;
    }

    public void setAhmdsh1cMstpartner(Ahmdsh1cMstpartner ahmdsh1cMstpartner) {
        this.ahmdsh1cMstpartner = ahmdsh1cMstpartner;
    }

    public String getVnopoltruck() {
        return vnopoltruck;
    }

    public void setVnopoltruck(String vnopoltruck) {
        this.vnopoltruck = vnopoltruck;
    }

    public String getVdriver() {
        return vdriver;
    }

    public void setVdriver(String vdriver) {
        this.vdriver = vdriver;
    }

    public String getVidAhmdsbscDtlsettingVtypercv() {
        return vidAhmdsbscDtlsettingVtypercv;
    }

    public void setVidAhmdsbscDtlsettingVtypercv(String vidAhmdsbscDtlsettingVtypercv) {
        this.vidAhmdsbscDtlsettingVtypercv = vidAhmdsbscDtlsettingVtypercv;
    }

    public AhmdsbscDtlsetting getAhmdsbscDtlsettingVtypercv() {
        return ahmdsbscDtlsettingVtypercv;
    }

    public void setAhmdsbscDtlsettingVtypercv(AhmdsbscDtlsetting ahmdsbscDtlsettingVtypercv) {
        this.ahmdsbscDtlsettingVtypercv = ahmdsbscDtlsettingVtypercv;
    }

    public String getVrcvrefdoc() {
        return vrcvrefdoc;
    }

    public void setVrcvrefdoc(String vrcvrefdoc) {
        this.vrcvrefdoc = vrcvrefdoc;
    }

    public String getVfrom() {
        return vfrom;
    }

    public void setVfrom(String vfrom) {
        this.vfrom = vfrom;
    }

    public String getVto() {
        return vto;
    }

    public void setVto(String vto) {
        this.vto = vto;
    }

    public String getVtpcode() {
        return vtpcode;
    }

    public void setVtpcode(String vtpcode) {
        this.vtpcode = vtpcode;
    }

    public String getVtypegoods() {
        return vtypegoods;
    }

    public void setVtypegoods(String vtypegoods) {
        this.vtypegoods = vtypegoods;
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
