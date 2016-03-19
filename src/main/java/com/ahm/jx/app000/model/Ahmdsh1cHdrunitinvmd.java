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
 * @author achmad.ha
 */
@Entity
@Table(name = "AHMDSH1C_HDRUNITINVMD",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VINVNO", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cHdrunitinvmd extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VINVNO",length=30,nullable=false)
    private String vinvno;
    
    @Column(name="DINV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dinv;
    
    @Column(name="DTOP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtop;
    
    @ManyToOne(targetEntity=Ahmdsh1cHdrunitpo.class,fetch= FetchType.LAZY,optional=true)
    @JoinColumn(name="VID_AHMDSH1C_HDRUNITPO",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cHdrunitpo ahmdsh1cHdrunitpo;
    
    @Column(name="VID_AHMDSH1C_HDRUNITPO",length=64)
    private String vidAhmdsh1cHdrunitpo;
    
    @Column(name="VPONONDIMS",length=64)
    private String vponondims;
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;
    
    @Column(name="VFLAGUPLOAD",length=1)
    private String vflagupload;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="ahmdsh1cHdrunitinvmd")    
    private List<Ahmdsh1cDtlunitinvmd> listAhmdsh1cDtlunitinvmd;

    public String getVinvno() {
        return vinvno;
    }

    public void setVinvno(String vinvno) {
        this.vinvno = vinvno;
    }

    public Date getDinv() {
        return dinv;
    }

    public void setDinv(Date dinv) {
        this.dinv = dinv;
    }

    public Date getDtop() {
        return dtop;
    }

    public void setDtop(Date dtop) {
        this.dtop = dtop;
    }

    public Ahmdsh1cHdrunitpo getAhmdsh1cHdrunitpo() {
        return ahmdsh1cHdrunitpo;
    }

    public void setAhmdsh1cHdrunitpo(Ahmdsh1cHdrunitpo ahmdsh1cHdrunitpo) {
        this.ahmdsh1cHdrunitpo = ahmdsh1cHdrunitpo;
    }

    public String getVidAhmdsh1cHdrunitpo() {
        return vidAhmdsh1cHdrunitpo;
    }

    public void setVidAhmdsh1cHdrunitpo(String vidAhmdsh1cHdrunitpo) {
        this.vidAhmdsh1cHdrunitpo = vidAhmdsh1cHdrunitpo;
    }

    public String getVponondims() {
        return vponondims;
    }

    public void setVponondims(String vponondims) {
        this.vponondims = vponondims;
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

    public String getVflagupload() {
        return vflagupload;
    }

    public void setVflagupload(String vflagupload) {
        this.vflagupload = vflagupload;
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

    public List<Ahmdsh1cDtlunitinvmd> getListAhmdsh1cDtlunitinvmd() {
        return listAhmdsh1cDtlunitinvmd;
    }

    public void setListAhmdsh1cDtlunitinvmd(List<Ahmdsh1cDtlunitinvmd> listAhmdsh1cDtlunitinvmd) {
        this.listAhmdsh1cDtlunitinvmd = listAhmdsh1cDtlunitinvmd;
    }
}
