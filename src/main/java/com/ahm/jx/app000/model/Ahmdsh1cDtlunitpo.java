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
@Table(name = "AHMDSH1C_DTLUNITPO",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMDSH1C_HDRUNITPO", "VID_AHMDSH1C_MSTTYPECLR"}))
public class Ahmdsh1cDtlunitpo extends BaseAuditVersioning implements  Serializable{
    
//    @Column(name="VID_AHMDSH1C_HDRUNITPO",length=64, nullable=false)
//    private String vidAhmdsh1cHdrunitpo;    
//    
//    @ManyToOne(targetEntity=Ahmdsh1cHdrunitpo.class,fetch= FetchType.LAZY)
//    @JoinColumn(name="VID_AHMDSH1C_HDRUNITPO",referencedColumnName="VID",insertable=false,updatable=false)
//    private Ahmdsh1cHdrunitpo ahmdsh1cHdrunitpo;
    
    @ManyToOne(targetEntity=Ahmdsh1cHdrunitpo.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_HDRUNITPO",referencedColumnName="VID")
    private Ahmdsh1cHdrunitpo ahmdsh1cHdrunitpo;
    
    @Column(name="VID_AHMDSH1C_MSTTYPECLR",length=64, nullable=false)
    private String vidAhmdsh1cMsttypeclr;
    
    @ManyToOne(targetEntity=Ahmdsh1cMsttypeclr.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTTYPECLR",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMsttypeclr ahmdsh1cMsttypeclr;
    
    @Column(name="NQTYFIX",precision=11,scale=0)
    private Integer nqtyfix = new Integer(0);
    
    @Column(name="NQTYTEN1",precision=11,scale=0)
    private Integer nqtyten1 = new Integer(0);
    
    @Column(name="NQTYTEN2",precision=11,scale=0)
    private Integer nqtyten2 = new Integer(0);
    
    @Column(name="VPOCLOSE",length=1)
    private String vpoclose;
    
    @Column(name="NKORFIX",precision=11,scale=0)
    private Integer nkorfix = new Integer(0);
    
    @Column(name="NKORFIX1",precision=11,scale=0)
    private Integer nkorfix1 = new Integer(0);
    
    @Column(name="NKORFIX2",precision=11,scale=0)
    private Integer nkorfix2 = new Integer(0);
    
    @Column(name="NQTYINV",precision=11,scale=0)
    private Integer nqtyinv = new Integer(0);    
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;

//    public String getVidAhmdsh1cHdrunitpo() {
//        return vidAhmdsh1cHdrunitpo;
//    }
//
//    public void setVidAhmdsh1cHdrunitpo(String vidAhmdsh1cHdrunitpo) {
//        this.vidAhmdsh1cHdrunitpo = vidAhmdsh1cHdrunitpo;
//    }

    public Ahmdsh1cHdrunitpo getAhmdsh1cHdrunitpo() {
        return ahmdsh1cHdrunitpo;
    }

    public void setAhmdsh1cHdrunitpo(Ahmdsh1cHdrunitpo ahmdsh1cHdrunitpo) {
        this.ahmdsh1cHdrunitpo = ahmdsh1cHdrunitpo;
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

    public Integer getNqtyfix() {
        return nqtyfix;
    }

    public void setNqtyfix(Integer nqtyfix) {
        this.nqtyfix = nqtyfix;
    }

    public Integer getNqtyten1() {
        return nqtyten1;
    }

    public void setNqtyten1(Integer nqtyten1) {
        this.nqtyten1 = nqtyten1;
    }

    public Integer getNqtyten2() {
        return nqtyten2;
    }

    public void setNqtyten2(Integer nqtyten2) {
        this.nqtyten2 = nqtyten2;
    }
    
    public String getVpoclose() {
        return vpoclose;
    }

    public void setVpoclose(String vpoclose) {
        this.vpoclose = vpoclose;
    }

    public Integer getNkorfix() {
        return nkorfix;
    }

    public void setNkorfix(Integer nkorfix) {
        this.nkorfix = nkorfix;
    }

    public Integer getNkorfix1() {
        return nkorfix1;
    }

    public void setNkorfix1(Integer nkorfix1) {
        this.nkorfix1 = nkorfix1;
    }

    public Integer getNkorfix2() {
        return nkorfix2;
    }

    public void setNkorfix2(Integer nkorfix2) {
        this.nkorfix2 = nkorfix2;
    }

    public Integer getNqtyinv() {
        return nqtyinv;
    }

    public void setNqtyinv(Integer nqtyinv) {
        this.nqtyinv = nqtyinv;
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
}
