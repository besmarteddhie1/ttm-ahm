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
@Table(name = "AHMDSH1C_DTLSOKWI",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VNOKWI", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cDtlsokwi extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VNOKWI",length=64,nullable=false)
    private String vnokwi;
    
    @Column(name="MAMOUNTKWI",nullable=false,scale=20,precision=4)
    private BigDecimal mamountkwi;
    
    @Column(name="VTYPE",length=64,nullable=false)
    private String vidAhmdsbscDtlsettingVtype;
    
    @ManyToOne(targetEntity=AhmdsbscDtlsetting.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VTYPE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscDtlsetting ahmdsbscDtlsettingVtype;
    
    @Column(name="VNOTES",length=255)
    private String vnotes;
    
    @Column(name="ICOUNT",nullable=false)
    private Integer icount;
    
    @Column(name="VID_AHMDSH1C_DTLUNITSPKSO",nullable=false,length=64)
    private String vidAhmdsh1cDtlunitspkso;
    
    @ManyToOne(targetEntity=Ahmdsh1cDtlunitspkso.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_DTLUNITSPKSO",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cDtlunitspkso ahmdsh1cDtlunitspkso;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;

    public String getVnokwi() {
        return vnokwi;
    }

    public void setVnokwi(String vnokwi) {
        this.vnokwi = vnokwi;
    }

    public BigDecimal getMamountkwi() {
        return mamountkwi;
    }

    public void setMamountkwi(BigDecimal mamountkwi) {
        this.mamountkwi = mamountkwi;
    }

    

    public String getVnotes() {
        return vnotes;
    }

    public void setVnotes(String vnotes) {
        this.vnotes = vnotes;
    }

    public Integer getIcount() {
        return icount;
    }

    public void setIcount(Integer icount) {
        this.icount = icount;
    }

    public String getVidAhmdsh1cDtlunitspkso() {
        return vidAhmdsh1cDtlunitspkso;
    }

    public void setVidAhmdsh1cDtlunitspkso(String vidAhmdsh1cDtlunitspkso) {
        this.vidAhmdsh1cDtlunitspkso = vidAhmdsh1cDtlunitspkso;
    }

    public Ahmdsh1cDtlunitspkso getAhmdsh1cDtlunitspkso() {
        return ahmdsh1cDtlunitspkso;
    }

    public void setAhmdsh1cDtlunitspkso(Ahmdsh1cDtlunitspkso ahmdsh1cDtlunitspkso) {
        this.ahmdsh1cDtlunitspkso = ahmdsh1cDtlunitspkso;
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

    public AhmdsbscDtlsetting getAhmdsbscDtlsettingVtype() {
        return ahmdsbscDtlsettingVtype;
    }

    public void setAhmdsbscDtlsettingVtype(AhmdsbscDtlsetting ahmdsbscDtlsettingVtype) {
        this.ahmdsbscDtlsettingVtype = ahmdsbscDtlsettingVtype;
    }

    public String getVidAhmdsbscDtlsettingVtype() {
        return vidAhmdsbscDtlsettingVtype;
    }

    public void setVidAhmdsbscDtlsettingVtype(String vidAhmdsbscDtlsettingVtype) {
        this.vidAhmdsbscDtlsettingVtype = vidAhmdsbscDtlsettingVtype;
    }
    
    
}
