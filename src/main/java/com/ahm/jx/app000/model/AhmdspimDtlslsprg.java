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
 * @author laurentinus
 */
@Entity
@Table(name = "AHMDSPIM_DTLSLSPRG",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VUDSLSPRG", "VID_AHMDSBSC_MSTDLRCODE"}))
public class AhmdspimDtlslsprg extends BaseAuditVersioning implements Serializable{
    @Column(name="VUDSLSPRG",length=40, nullable=false)
    private String vudslsprg;
    
    @ManyToOne(targetEntity=Ahmdsh1cHdrunitspk.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSPIM_HDRSLSPRG",referencedColumnName="VID")
    private AhmdspimHdrslsprg ahmdspimHdrslsprg;
    
    @Column(name="VTYPECODE",length=6, nullable=false)
    private String vtypecode;
    
    @Column(name="VCLRCODE",length=6, nullable=false)
    private String vclrcode;
    
    @Column(name="IOPTLOCK", nullable=false)
    private Integer ioptlock;
    
    @Column(name="VROWMASK",length=1, nullable=false)
    private String vrowmask;
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;

    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;

    public String getVudslsprg() {
        return vudslsprg;
    }

    public void setVudslsprg(String vudslsprg) {
        this.vudslsprg = vudslsprg;
    }

    public AhmdspimHdrslsprg getAhmdspimHdrslsprg() {
        return ahmdspimHdrslsprg;
    }

    public void setAhmdspimHdrslsprg(AhmdspimHdrslsprg ahmdspimHdrslsprg) {
        this.ahmdspimHdrslsprg = ahmdspimHdrslsprg;
    }

    public String getVtypecode() {
        return vtypecode;
    }

    public void setVtypecode(String vtypecode) {
        this.vtypecode = vtypecode;
    }

    public String getVclrcode() {
        return vclrcode;
    }

    public void setVclrcode(String vclrcode) {
        this.vclrcode = vclrcode;
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
