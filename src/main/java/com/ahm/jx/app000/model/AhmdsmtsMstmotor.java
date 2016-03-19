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

/**
 *
 * @author george
 */
@Entity
@Table(name="AHMDSMTS_MSTMOTOR")
public class AhmdsmtsMstmotor extends BaseAuditVersioning implements Serializable{
    @Column(name = "VFRAMENUM", length = 20, nullable = false, unique = true)
    private String vframenum;
    @Column(name = "VENGINENUM", length = 20, nullable = false, unique = true)
    private String venginenum;
    @Column(name="VNOPOL",length=10)
    private String vnopol;
    @Column(name = "VID_AHMDSH1C_MSTTYPECLR", length = 64,nullable=false)
    private String vidAhmdsh1cMsttypeclr;
    @ManyToOne(targetEntity = Ahmdsh1cMsttypeclr.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTTYPECLR", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMsttypeclr ahmdsh1cMsttypeclr;
    @Column(name="DNEXTSVC")
    @Temporal(TemporalType.DATE)
    private Date dnextsvc;
    @Column(name="DMCBUY")
    @Temporal(TemporalType.DATE)
    private Date dmcbuy;
    @Column(name="DLASTSERVICE")
    @Temporal(TemporalType.DATE)
    private Date dlastservice;
    @Column(name = "NTHNPROD", scale = 4, precision = 0)
    private Integer nthnprod;
    @Column(name = "NKMSERVICE", scale = 4, precision = 0)
    private Integer nkmservice;
    @Column(name = "VID_AHMDSH1C_MSTPROSPEK", length = 64)
    private String vidAhmdsh1cMstprospek;
    @ManyToOne(targetEntity = Ahmdsh1cMstprospek.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTPROSPEK", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMstprospek ahmdsh1cMstprospek;
    @Column(name = "VB2BSTAT", length = 1)
    private String vb2bstat;
    @Column(name = "VID_AHMDSBSC_MSTDLRCODE", nullable = false, length = 64)
    private String vidAhmdsbscMstdlrcode;
    @ManyToOne(targetEntity = AhmdsbscMstdlrcode.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSBSC_MSTDLRCODE", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;

    public String getVframenum() {
        return vframenum;
    }

    public void setVframenum(String vframenum) {
        this.vframenum = vframenum;
    }

    public String getVenginenum() {
        return venginenum;
    }

    public void setVenginenum(String venginenum) {
        this.venginenum = venginenum;
    }

    public String getVnopol() {
        return vnopol;
    }

    public void setVnopol(String vnopol) {
        this.vnopol = vnopol;
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

    public Date getDnextsvc() {
        return dnextsvc;
    }

    public void setDnextsvc(Date dnextsvc) {
        this.dnextsvc = dnextsvc;
    }

    public Date getDmcbuy() {
        return dmcbuy;
    }

    public void setDmcbuy(Date dmcbuy) {
        this.dmcbuy = dmcbuy;
    }

    public Date getDlastservice() {
        return dlastservice;
    }

    public void setDlastservice(Date dlastservice) {
        this.dlastservice = dlastservice;
    }

    public Integer getNthnprod() {
        return nthnprod;
    }

    public void setNthnprod(Integer nthnprod) {
        this.nthnprod = nthnprod;
    }

    public Integer getNkmservice() {
        return nkmservice;
    }

    public void setNkmservice(Integer nkmservice) {
        this.nkmservice = nkmservice;
    }

    public String getVidAhmdsh1cMstprospek() {
        return vidAhmdsh1cMstprospek;
    }

    public void setVidAhmdsh1cMstprospek(String vidAhmdsh1cMstprospek) {
        this.vidAhmdsh1cMstprospek = vidAhmdsh1cMstprospek;
    }

    public Ahmdsh1cMstprospek getAhmdsh1cMstprospek() {
        return ahmdsh1cMstprospek;
    }

    public void setAhmdsh1cMstprospek(Ahmdsh1cMstprospek ahmdsh1cMstprospek) {
        this.ahmdsh1cMstprospek = ahmdsh1cMstprospek;
    }

    public String getVb2bstat() {
        return vb2bstat;
    }

    public void setVb2bstat(String vb2bstat) {
        this.vb2bstat = vb2bstat;
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
