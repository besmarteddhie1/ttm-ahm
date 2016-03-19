/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "AHMDSH1C_DTLUNITINVMD",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMDSH1C_HDRUNITINVMD", "VID_AHMDSH1C_MSTTYPECLR"}))
public class Ahmdsh1cDtlunitinvmd extends BaseAuditVersioning implements  Serializable{
    
    @ManyToOne(targetEntity=Ahmdsh1cHdrunitinvmd.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_HDRUNITINVMD",referencedColumnName="VID")
    private Ahmdsh1cHdrunitinvmd ahmdsh1cHdrunitinvmd;
    
    @Column(name="VID_AHMDSH1C_MSTTYPECLR",length=64, nullable=false)
    private String vidAhmdsh1cMsttypeclr;
    
    @ManyToOne(targetEntity=Ahmdsh1cMsttypeclr.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTTYPECLR",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMsttypeclr ahmdsh1cMsttypeclr;
    
    @Column(name="MPRICE",precision=11,scale=0)
    private Integer mprice;
    
    @Column(name="NQTY",precision=11,scale=0)
    private Integer nqty;
    
    @Column(name="MDISCOUNT",precision=11,scale=0)
    private Integer mdiscount;
    
    @Column(name="NPCTDISC",precision=11,scale=2)
    private BigDecimal npctdisc;
    
    @Column(name="MPPN",precision=11,scale=2)
    private BigDecimal mppn;

    public Ahmdsh1cHdrunitinvmd getAhmdsh1cHdrunitinvmd() {
        return ahmdsh1cHdrunitinvmd;
    }

    public void setAhmdsh1cHdrunitinvmd(Ahmdsh1cHdrunitinvmd ahmdsh1cHdrunitinvmd) {
        this.ahmdsh1cHdrunitinvmd = ahmdsh1cHdrunitinvmd;
    }

    public String getVidAhmdsh1cMsttypeclr() {
        return vidAhmdsh1cMsttypeclr;
    }

    public void setVidAhmdsh1cMsttypeclr(String vidAhmdsh1cMsttypeclr) {
        this.vidAhmdsh1cMsttypeclr = vidAhmdsh1cMsttypeclr;
    }

    public Ahmdsh1cMsttypeclr getAhmdsh1cMsttypeclr() {
        return ahmdsh1cMsttypeclr;
    }

    public void setAhmdsh1cMsttypeclr(Ahmdsh1cMsttypeclr ahmdsh1cMsttypeclr) {
        this.ahmdsh1cMsttypeclr = ahmdsh1cMsttypeclr;
    }

    public Integer getMprice() {
        return mprice;
    }

    public void setMprice(Integer mprice) {
        this.mprice = mprice;
    }

    public Integer getNqty() {
        return nqty;
    }

    public void setNqty(Integer nqty) {
        this.nqty = nqty;
    }

    public Integer getMdiscount() {
        return mdiscount;
    }

    public void setMdiscount(Integer mdiscount) {
        this.mdiscount = mdiscount;
    }

    public BigDecimal getNpctdisc() {
        return npctdisc;
    }

    public void setNpctdisc(BigDecimal npctdisc) {
        this.npctdisc = npctdisc;
    }

    public BigDecimal getMppn() {
        return mppn;
    }

    public void setMppn(BigDecimal mppn) {
        this.mppn = mppn;
    }
}
