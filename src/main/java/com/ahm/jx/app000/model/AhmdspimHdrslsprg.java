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
@Table(name = "AHMDSPIM_HDRSLSPRG", uniqueConstraints = @UniqueConstraint(columnNames = {"VIDSLSIDPRG", "VID_AHMDSBSC_MSTDLRCODE"}))
public class AhmdspimHdrslsprg extends BaseAuditVersioning implements Serializable{
    
    
    @Column(name="VIDSLSIDPRG",length=10, nullable=false)
    private String vidslsidprg;
    
    @Column(name="VSALESDESC",length=50, nullable=false)
    private String vsalesdesc;
    
    @Column(name="DBGNEFF", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbgneff;
    
    @Column(name="DLSTEFF", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dlsteff;
    
    @Column(name="DGRACEPOFINCO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dgracepofinco;
    
    @Column(name="DGRACESUBMIT", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dgraceposubmit;
    
    @Column(name="DGRACEBAST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dgracebast;
    
    @Column(name="DGRACESTNK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dgracestnk;
    
    @Column(name="VCATSLSPRG",length=1, nullable=false)
    private String vcatslsprg;
    
    @Column(name="VSUBCATSLSPRG",length=1, nullable=false)
    private String vsubcatslsprg;
    
    @Column(name="VJOINSALES",length=1)
    private String vjoinsales;
    
    @Column(name="IOPTLOCK", nullable=false)
    private Integer ioptlock;
    
    @Column(name="VROWMASK",length=1, nullable=false)
    private String vrowmask;
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2stat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="ahmdspimHdrslsprg")    
    private List<AhmdspimDtlslsprg> listAhmdspimDtlslsprg;

    public String getVidslsidprg() {
        return vidslsidprg;
    }

    public void setVidslsidprg(String vidslsidprg) {
        this.vidslsidprg = vidslsidprg;
    }

    public String getVsalesdesc() {
        return vsalesdesc;
    }

    public void setVsalesdesc(String vsalesdesc) {
        this.vsalesdesc = vsalesdesc;
    }

    public Date getDbgneff() {
        return dbgneff;
    }

    public void setDbgneff(Date dbgneff) {
        this.dbgneff = dbgneff;
    }

    public Date getDlsteff() {
        return dlsteff;
    }

    public void setDlsteff(Date dlsteff) {
        this.dlsteff = dlsteff;
    }

    public Date getDgracepofinco() {
        return dgracepofinco;
    }

    public void setDgracepofinco(Date dgracepofinco) {
        this.dgracepofinco = dgracepofinco;
    }

    public Date getDgraceposubmit() {
        return dgraceposubmit;
    }

    public void setDgraceposubmit(Date dgraceposubmit) {
        this.dgraceposubmit = dgraceposubmit;
    }

    public Date getDgracebast() {
        return dgracebast;
    }

    public void setDgracebast(Date dgracebast) {
        this.dgracebast = dgracebast;
    }

    public Date getDgracestnk() {
        return dgracestnk;
    }

    public void setDgracestnk(Date dgracestnk) {
        this.dgracestnk = dgracestnk;
    }

    public String getVcatslsprg() {
        return vcatslsprg;
    }

    public void setVcatslsprg(String vcatslsprg) {
        this.vcatslsprg = vcatslsprg;
    }

    public String getVsubcatslsprg() {
        return vsubcatslsprg;
    }

    public void setVsubcatslsprg(String vsubcatslsprg) {
        this.vsubcatslsprg = vsubcatslsprg;
    }

    public String getVjoinsales() {
        return vjoinsales;
    }

    public void setVjoinsales(String vjoinsales) {
        this.vjoinsales = vjoinsales;
    }

    public Integer getIoptlock() {
        return ioptlock;
    }

    public void setIoptlock(Integer ioptlock) {
        this.ioptlock = ioptlock;
    }

    public String getVrowmask() {
        return vrowmask;
    }

    public void setVrowmask(String vrowmask) {
        this.vrowmask = vrowmask;
    }

    public String getVb2stat() {
        return vb2stat;
    }

    public void setVb2stat(String vb2stat) {
        this.vb2stat = vb2stat;
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

    public List<AhmdspimDtlslsprg> getListAhmdspimDtlslsprg() {
        return listAhmdspimDtlslsprg;
    }

    public void setListAhmdspimDtlslsprg(List<AhmdspimDtlslsprg> listAhmdspimDtlslsprg) {
        this.listAhmdspimDtlslsprg = listAhmdspimDtlslsprg;
    }
    
}
