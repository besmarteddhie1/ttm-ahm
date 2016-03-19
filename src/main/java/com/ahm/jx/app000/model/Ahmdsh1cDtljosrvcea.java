/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author george
 */
@Entity
@Table(name = "AHMDSH1C_DTLJOSRVCEA")
public class Ahmdsh1cDtljosrvcea extends BaseAuditVersioning implements Serializable {

    @ManyToOne(targetEntity = Ahmdsh1cHdrjosrvcea.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_HDRJOSRVCEA", referencedColumnName = "VID")
    private Ahmdsh1cHdrjosrvcea ahmdsh1cHdrjosrvcea;
    @Column(name = "VID_AHMDSH1C_MSTMOTOR")
    private String vidAhmdsh1cMstmotor;
    @ManyToOne(targetEntity = Ahmdsh1cMstmotor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTMOTOR", referencedColumnName = "VID",insertable=false,updatable=false)
    private Ahmdsh1cMstmotor ahmdsh1cMstmotor;
    @Column(name = "DRECEIVSTNK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dreceivstnk;
    @Column(name = "VRECEIVSTNK")
    private String vreceivstnk;
    @Column(name = "DRECEIVBPKB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dreceivbpkb;
    @Column(name = "VRECEIVBPKB")
    private String vreceivbpkb;
    @Column(name = "DBASTSTNK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbaststnk;
    @Column(name = "VBASTSTNK")
    private String vbaststnk;
    @Column(name = "DBASTBPKB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbastbpkb;
    @Column(name = "VBASTBPKB")
    private String vbastbpkb;
    @Column(name = "VSTNKNUM")
    private String vstnknum;
    @Column(name = "VBPKBNUM")
    private String vbpkbnum;
    @Column(name = "VAREA")
    private String varea;
    @Column(name = "MPRICEBBN")
    private BigDecimal mpricebbn;
    @Column(name = "VSTAT")
    private String vstat;
    @Column(name = "DREQFAKSTNK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dreqfakstnk;
    @Column(name = "DCANCEL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dcancel;

    public Ahmdsh1cHdrjosrvcea getAhmdsh1cHdrjosrvcea() {
        return ahmdsh1cHdrjosrvcea;
    }

    public void setAhmdsh1cHdrjosrvcea(Ahmdsh1cHdrjosrvcea ahmdsh1cHdrjosrvcea) {
        this.ahmdsh1cHdrjosrvcea = ahmdsh1cHdrjosrvcea;
    }

    public String getVidAhmdsh1cMstmotor() {
        return vidAhmdsh1cMstmotor;
    }

    public void setVidAhmdsh1cMstmotor(String vidAhmdsh1cMstmotor) {
        this.vidAhmdsh1cMstmotor = vidAhmdsh1cMstmotor;
    }

    public Ahmdsh1cMstmotor getAhmdsh1cMstmotor() {
        return ahmdsh1cMstmotor;
    }

    public void setAhmdsh1cMstmotor(Ahmdsh1cMstmotor ahmdsh1cMstmotor) {
        this.ahmdsh1cMstmotor = ahmdsh1cMstmotor;
    }

    public Date getDreceivstnk() {
        return dreceivstnk;
    }

    public void setDreceivstnk(Date dreceivstnk) {
        this.dreceivstnk = dreceivstnk;
    }

    public String getVreceivstnk() {
        return vreceivstnk;
    }

    public void setVreceivstnk(String vreceivstnk) {
        this.vreceivstnk = vreceivstnk;
    }

    public Date getDreceivbpkb() {
        return dreceivbpkb;
    }

    public void setDreceivbpkb(Date dreceivbpkb) {
        this.dreceivbpkb = dreceivbpkb;
    }

    public String getVreceivbpkb() {
        return vreceivbpkb;
    }

    public void setVreceivbpkb(String vreceivbpkb) {
        this.vreceivbpkb = vreceivbpkb;
    }

    public Date getDbaststnk() {
        return dbaststnk;
    }

    public void setDbaststnk(Date dbaststnk) {
        this.dbaststnk = dbaststnk;
    }

    public String getVbaststnk() {
        return vbaststnk;
    }

    public void setVbaststnk(String vbaststnk) {
        this.vbaststnk = vbaststnk;
    }

    public Date getDbastbpkb() {
        return dbastbpkb;
    }

    public void setDbastbpkb(Date dbastbpkb) {
        this.dbastbpkb = dbastbpkb;
    }

    public String getVbastbpkb() {
        return vbastbpkb;
    }

    public void setVbastbpkb(String vbastbpkb) {
        this.vbastbpkb = vbastbpkb;
    }

    public String getVstnknum() {
        return vstnknum;
    }

    public void setVstnknum(String vstnknum) {
        this.vstnknum = vstnknum;
    }

    public String getVbpkbnum() {
        return vbpkbnum;
    }

    public void setVbpkbnum(String vbpkbnum) {
        this.vbpkbnum = vbpkbnum;
    }

    public String getVarea() {
        return varea;
    }

    public void setVarea(String varea) {
        this.varea = varea;
    }

    public BigDecimal getMpricebbn() {
        return mpricebbn;
    }

    public void setMpricebbn(BigDecimal mpricebbn) {
        this.mpricebbn = mpricebbn;
    }

    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

    public Date getDreqfakstnk() {
        return dreqfakstnk;
    }

    public void setDreqfakstnk(Date dreqfakstnk) {
        this.dreqfakstnk = dreqfakstnk;
    }

    public Date getDcancel() {
        return dcancel;
    }

    public void setDcancel(Date dcancel) {
        this.dcancel = dcancel;
    }
    
}
