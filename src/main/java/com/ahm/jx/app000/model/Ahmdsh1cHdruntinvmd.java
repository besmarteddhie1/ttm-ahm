/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "AHMDSH1C_HDRUNTINVMD",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VIDINVMD", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cHdruntinvmd extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VIDINVMD",length=30,nullable=false)
    private String vidinvmd;
    
    @Column(name="DINVDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dinvdate;
    
    @Column(name="DTOPINVDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtopinvdate;
    
    @Column(name="VREFNUMBER",length=20)
    private String vrefnumber;
    
    @Column(name="VTYPEINV",length=1)
    private String vtypeinv;
    
    @Column(name="MDISCOUNT",scale=20,precision=4)
    private BigDecimal mdiscount;
    
    @Column(name="NTOP",scale=10,precision=0)
    private BigInteger ntop;
    
    @Column(name="VIDINVREF",length=20)
    private String vidinvref;
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;

    public String getVidinvmd() {
        return vidinvmd;
    }

    public void setVidinvmd(String vidinvmd) {
        this.vidinvmd = vidinvmd;
    }

    public Date getDinvdate() {
        return dinvdate;
    }

    public void setDinvdate(Date dinvdate) {
        this.dinvdate = dinvdate;
    }

    public Date getDtopinvdate() {
        return dtopinvdate;
    }

    public void setDtopinvdate(Date dtopinvdate) {
        this.dtopinvdate = dtopinvdate;
    }

    public String getVrefnumber() {
        return vrefnumber;
    }

    public void setVrefnumber(String vrefnumber) {
        this.vrefnumber = vrefnumber;
    }

    public String getVtypeinv() {
        return vtypeinv;
    }

    public void setVtypeinv(String vtypeinv) {
        this.vtypeinv = vtypeinv;
    }

    public BigDecimal getMdiscount() {
        return mdiscount;
    }

    public void setMdiscount(BigDecimal mdiscount) {
        this.mdiscount = mdiscount;
    }

    public BigInteger getNtop() {
        return ntop;
    }

    public void setNtop(BigInteger ntop) {
        this.ntop = ntop;
    }

    public String getVidinvref() {
        return vidinvref;
    }

    public void setVidinvref(String vidinvref) {
        this.vidinvref = vidinvref;
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
