/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author achmad.ha modified by Heldy 12-06-2015: Add column VIDPROSPEK
 * modified by George 22-10-2015: Change column VIDPROSPEK to
 * VID_AHMDSH1C_MSTPROSPEK
 */
@Entity
@Table(name = "AHMDSH1C_MSTMOTOR",
uniqueConstraints =
@UniqueConstraint(columnNames = {"VFRAMENUM", "VENGINENUM", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cMstmotor extends BaseAuditVersioning implements Serializable {

    @Column(name = "VFRAMENUM", length = 20, nullable = false, unique = true)
    private String vframenum;
    @Column(name = "VENGINENUM", length = 20, nullable = false, unique = true)
    private String venginenum;
    @Column(name = "VID_AHMDSH1C_MSTTYPECLR", length = 64)
    private String vidAhmdsh1cMsttypeclr;
    @ManyToOne(targetEntity = Ahmdsh1cMsttypeclr.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTTYPECLR", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMsttypeclr ahmdsh1cMsttypeclr;
    @Column(name = "NTHNPROD", scale = 4, precision = 0, nullable = false)
    private Integer nthnprod;
    @Column(name = "DRECEIVE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dreceive;
    @Column(name = "VUNITSTAT", length = 64)
    private String vidAhmdsbscDtlsettingVunitstat;
    @ManyToOne(targetEntity = AhmdsbscDtlsetting.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VUNITSTAT", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmdsbscDtlsetting ahmdsbscDtlsettingVunitstat;
    @Column(name = "VFLSTATUNIT", length = 1)
    private String vflstatunit;
    @Column(name = "VIDINVOICE", length = 20)
    private String vidinvoice;
    @Column(name = "DREQSTNK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dreqstnk;
    @Column(name = "DRECFAKSTNK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date drecfakstnk;
    @Column(name = "VREQSTNKNUM", length = 20)
    private String vreqstnknum;
    @Column(name = "NSEQNUM", scale = 11, precision = 0)
    private Integer nseqnum;
    @Column(name = "DSHPLSDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dshplsdate;
    @Column(name = "DINVDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dinvdate;
    @Column(name = "VFAKSTNKNUM", length = 20)
    private String vfakstnknum;
    @Column(name = "VID_AHMDSH1C_MSTIDWHS", length = 64)
    private String vidAhmdsh1cMstidwhs;
    @OneToOne(targetEntity = Ahmdsh1cMstidwhs.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTIDWHS", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMstidwhs ahmdsh1cMstidwhs;
    @Column(name = "VB2BSTAT", length = 1)
    private String vb2bstat;
    @Column(name = "VIDB2B", length = 40)
    private String vidb2b;
    @Column(name = "VID_AHMDSBSC_MSTDLRCODE", nullable = false, length = 64)
    private String vidAhmdsbscMstdlrcode;
    @ManyToOne(targetEntity = AhmdsbscMstdlrcode.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSBSC_MSTDLRCODE", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    @Column(name = "VID_AHMDSH1C_MSTPROSPEK", length = 64)
    private String vidAhmdsh1cMstprospek;
    @ManyToOne(targetEntity = Ahmdsh1cMstprospek.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTPROSPEK", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMstprospek ahmdsh1cMstprospek;

    @OneToMany(targetEntity = Ahmdsh1cMststnkcdb.class, mappedBy = "vidAhmdsh1cMstmotor")
    private List<Ahmdsh1cMststnkcdb> ahmdsh1cMststnkcdbs;

    public List<Ahmdsh1cMststnkcdb> getAhmdsh1cMststnkcdbs() {
        return ahmdsh1cMststnkcdbs;
    }

    public void setAhmdsh1cMststnkcdbs(List<Ahmdsh1cMststnkcdb> ahmdsh1cMststnkcdbs) {
        this.ahmdsh1cMststnkcdbs = ahmdsh1cMststnkcdbs;
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

    public Integer getNthnprod() {
        return nthnprod;
    }

    public void setNthnprod(Integer nthnprod) {
        this.nthnprod = nthnprod;
    }

    public Date getDreceive() {
        return dreceive;
    }

    public void setDreceive(Date dreceive) {
        this.dreceive = dreceive;
    }

    public String getVidAhmdsbscDtlsettingVunitstat() {
        return vidAhmdsbscDtlsettingVunitstat;
    }

    public void setVidAhmdsbscDtlsettingVunitstat(String vidAhmdsbscDtlsettingVunitstat) {
        this.vidAhmdsbscDtlsettingVunitstat = vidAhmdsbscDtlsettingVunitstat;
    }

    public AhmdsbscDtlsetting getAhmdsbscDtlsettingVunitstat() {
        return ahmdsbscDtlsettingVunitstat;
    }

    public void setAhmdsbscDtlsettingVunitstat(AhmdsbscDtlsetting ahmdsbscDtlsettingVunitstat) {
        this.ahmdsbscDtlsettingVunitstat = ahmdsbscDtlsettingVunitstat;
    }

    public String getVflstatunit() {
        return vflstatunit;
    }

    public void setVflstatunit(String vflstatunit) {
        this.vflstatunit = vflstatunit;
    }

    public String getVidinvoice() {
        return vidinvoice;
    }

    public void setVidinvoice(String vidinvoice) {
        this.vidinvoice = vidinvoice;
    }

    public Date getDreqstnk() {
        return dreqstnk;
    }

    public void setDreqstnk(Date dreqstnk) {
        this.dreqstnk = dreqstnk;
    }

    public Date getDrecfakstnk() {
        return drecfakstnk;
    }

    public void setDrecfakstnk(Date drecfakstnk) {
        this.drecfakstnk = drecfakstnk;
    }

    public String getVreqstnknum() {
        return vreqstnknum;
    }

    public void setVreqstnknum(String vreqstnknum) {
        this.vreqstnknum = vreqstnknum;
    }

    public Integer getNseqnum() {
        return nseqnum;
    }

    public void setNseqnum(Integer nseqnum) {
        this.nseqnum = nseqnum;
    }

    public Date getDshplsdate() {
        return dshplsdate;
    }

    public void setDshplsdate(Date dshplsdate) {
        this.dshplsdate = dshplsdate;
    }

    public Date getDinvdate() {
        return dinvdate;
    }

    public void setDinvdate(Date dinvdate) {
        this.dinvdate = dinvdate;
    }

    public String getVfakstnknum() {
        return vfakstnknum;
    }

    public void setVfakstnknum(String vfakstnknum) {
        this.vfakstnknum = vfakstnknum;
    }

    public String getVidAhmdsh1cMstidwhs() {
        return vidAhmdsh1cMstidwhs;
    }

    public void setVidAhmdsh1cMstidwhs(String vidAhmdsh1cMstidwhs) {
        this.vidAhmdsh1cMstidwhs = vidAhmdsh1cMstidwhs;
    }

    public Ahmdsh1cMstidwhs getAhmdsh1cMstidwhs() {
        return ahmdsh1cMstidwhs;
    }

    public void setAhmdsh1cMstidwhs(Ahmdsh1cMstidwhs ahmdsh1cMstidwhs) {
        this.ahmdsh1cMstidwhs = ahmdsh1cMstidwhs;
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
