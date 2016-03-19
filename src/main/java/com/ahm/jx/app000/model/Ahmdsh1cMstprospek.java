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

/**
 *
 * @author laurentinus
 */
@Entity
@Table(name = "AHMDSH1C_MSTPROSPEK")
public class Ahmdsh1cMstprospek extends BaseAuditVersioning implements Serializable {

    @Column(name = "VPHONENUM", length = 15, nullable = false)
    private String vphonenum;
    @Column(name = "VID_AHMDSH1C_MSTEMPLOYEE", length = 64, nullable = true)
    private String vidAhmdsh1cMstemployee;
    @ManyToOne(targetEntity = Ahmdsh1cMstemployee.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTEMPLOYEE", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMstemployee ahmdsh1cMstemployee;
    @Column(name = "VID_AHMDSH1C_MSTKELURAHAN", length = 64)
    private String vidAhmdsh1cMstkelurahan;
    @ManyToOne(targetEntity = Ahmdsh1cMstkelurahan.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTKELURAHAN", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMstkelurahan ahmdsh1cMstkelurahan;
    @Column(name = "VADDRESS", length = 100, nullable = false)
    private String vaddress;
    @Column(name = "VADDRESS1", length = 100)
    private String vaddress1;
    @Column(name = "VGANG", length = 50)
    private String vgang;
    @Column(name = "VNAME", length = 100, nullable = false)
    private String vname;
    @Column(name = "VNOKTP", length = 50)
    private String vnoktp;
    @Column(name = "DBIRTHDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbirthdate;
    @Column(name = "VBIRTHPLACE", length = 100)
    private String vbirthplace;
    @Column(name = "VNPWP", length = 50)
    private String vnpwp;
    @Column(name = "VHPNUM", length = 15)
    private String vhpnum;
    @Column(name = "DPROSDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dprosdate;
    @Column(name = "VSEX", length = 1)
    private String vsex;
    @Column(name = "VSTAT", length = 1)
    private String vstat;
    @Column(name = "VMBIRTHDT", length = 6)
    private String vmbirthdt;
    @Column(name = "DDATEBUY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ddatebuy;
    @Column(name = "VJOBCODE", length = 6)
    private String vjobcode;
    @Column(name = "VRELCODE", length = 1)
    private String vrelcode;
    @Column(name = "VEDUCODE", length = 1)
    private String veducode;
    @Column(name = "VEMAIL", length = 100)
    private String vemail;
    @Column(name = "VID_AHMDSH1C_MSTCUSTGRP", length = 64)
    private String vidAhmdsh1cMstcustgrp;
    @ManyToOne(targetEntity = Ahmdsh1cMstcustgrp.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTCUSTGRP", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMstcustgrp ahmdsh1cMstcustgrp;
    @Column(name = "VIDCARDH1", length = 20)
    private String vidcardh1;
    @Column(name = "VIDCARDH2", length = 20)
    private String vidcardh2;
    @Column(name = "VIDCARDH3", length = 20)
    private String vidcardh3;
    @Column(name = "VCONTACTID", length = 30)
    private String vcontactid;
    @Column(name = "VBRANDPREV", length = 20)
    private String vbrandprev;
    @Column(name = "VTYPEPREV", length = 20)
    private String vtypeprev;
    @Column(name = "VCATPREV", length = 20)
    private String vcatprev;
    @Column(name = "NYEARPROD")
    private Integer nyearprod;
    @Column(name = "DTRANSH1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtransh1;
    @Column(name = "DTRANSH2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtransh2;
    @Column(name = "DTRANSH3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtransh3;
    @Column(name = "VHOMSTAT", length = 1)
    private String vhomstat;
    @Column(name = "VHPSTAT", length = 1)
    private String vhpstat;
    @Column(name = "VCONDITION", length = 1)
    private String vcondition;
    @Column(name = "VNOTE", length = 100)
    private String vnote;
    @Column(name = "VGROUP", length = 6)
    private String vgroup;
    @Column(name = "VIMAGE", columnDefinition = "mediumblob")
    private Byte[] vimage;
    @Column(name = "VFLMEDIATOR", length = 1)
    private String vflmediator;
    @Column(name = "NSEQFLWUP")
    private Integer nseqflwup;
    @Column(name = "VB2BSTAT", length = 1)
    private String vb2bstat;
    @Column(name = "VID_AHMDSBSC_MSTDLRCODE", length = 64, nullable = false)
    private String vidAhmdsbscMstdlrcode;
    @ManyToOne(targetEntity = AhmdsbscMstdlrcode.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSBSC_MSTDLRCODE", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    @Column(name = "VEXPENSE", length = 1)
    private String vexpense;
    @Column(name = "VPICNAME", length = 30)
    private String vpicname;
    @Column(name = "VAVAILABLE", length = 1)
    private String vavailable;
    @Column(name = "VUSEFOR", length = 1)
    private String vusefor;
    @Column(name = "VUSER", length = 1)
    private String vuser;
    @Column(name = "VFRAMEPREV", length = 20)
    private String vframeprev;
    @Column(name = "VFOLLOWUP", length = 1)
    private String vfollowup;
    @Column(name = "VIDCUSTOMER", length = 45)
    private String vidcustomer;
    @Column(name = "VKELURAHAN", length = 30)
    private String vkelurahan;
    @Column(name = "VKECAMATAN", length = 30)
    private String vkecamatan;
    @Column(name = "VCITY", length = 100)
    private String vcity;
    @Column(name = "VSOURCE", length = 1)
    private String vsource;
    @OneToMany(targetEntity = H1c005Locjoin.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID",referencedColumnName="VID_AHMDSH1C_MSTKELURAHAN",insertable=false,updatable=false)
    private List<H1c005Locjoin> h1c005Locjoins;

    public String getVsource() {
        return vsource;
    }

    public void setVsource(String vsource) {
        this.vsource = vsource;
    }

    public String getVkelurahan() {
        return vkelurahan;
    }

    public void setVkelurahan(String vkelurahan) {
        this.vkelurahan = vkelurahan;
    }

    public String getVkecamatan() {
        return vkecamatan;
    }

    public void setVkecamatan(String vkecamatan) {
        this.vkecamatan = vkecamatan;
    }

    public String getVcity() {
        return vcity;
    }

    public void setVcity(String vcity) {
        this.vcity = vcity;
    }

    public List<H1c005Locjoin> getH1c005Locjoins() {
        return h1c005Locjoins;
    }

    public void setH1c005Locjoins(List<H1c005Locjoin> h1c005Locjoins) {
        this.h1c005Locjoins = h1c005Locjoins;
    }

    public String getVidcustomer() {
        return vidcustomer;
    }

    public void setVidcustomer(String vidcustomer) {
        this.vidcustomer = vidcustomer;
    }

    public String getVphonenum() {
        return vphonenum;
    }

    public void setVphonenum(String vphonenum) {
        this.vphonenum = vphonenum;
    }

    public String getVidAhmdsh1cMstemployee() {
        return vidAhmdsh1cMstemployee;
    }

    public void setVidAhmdsh1cMstemployee(String vidAhmdsh1cMstemployee) {
        this.vidAhmdsh1cMstemployee = vidAhmdsh1cMstemployee;
    }

    public Ahmdsh1cMstemployee getAhmdsh1cMstemployee() {
        return ahmdsh1cMstemployee;
    }

    public void setAhmdsh1cMstemployee(Ahmdsh1cMstemployee ahmdsh1cMstemployee) {
        this.ahmdsh1cMstemployee = ahmdsh1cMstemployee;
    }

    public String getVidAhmdsh1cMstkelurahan() {
        return vidAhmdsh1cMstkelurahan;
    }

    public void setVidAhmdsh1cMstkelurahan(String vidAhmdsh1cMstkelurahan) {
        this.vidAhmdsh1cMstkelurahan = vidAhmdsh1cMstkelurahan;
    }

    public Ahmdsh1cMstkelurahan getAhmdsh1cMstkelurahan() {
        return ahmdsh1cMstkelurahan;
    }

    public void setAhmdsh1cMstkelurahan(Ahmdsh1cMstkelurahan ahmdsh1cMstkelurahan) {
        this.ahmdsh1cMstkelurahan = ahmdsh1cMstkelurahan;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getVaddress1() {
        return vaddress1;
    }

    public void setVaddress1(String vaddress1) {
        this.vaddress1 = vaddress1;
    }

    public String getVgang() {
        return vgang;
    }

    public void setVgang(String vgang) {
        this.vgang = vgang;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVnoktp() {
        return vnoktp;
    }

    public void setVnoktp(String vnoktp) {
        this.vnoktp = vnoktp;
    }

    public Date getDbirthdate() {
        return dbirthdate;
    }

    public void setDbirthdate(Date dbirthdate) {
        this.dbirthdate = dbirthdate;
    }

    public String getVbirthplace() {
        return vbirthplace;
    }

    public void setVbirthplace(String vbirthplace) {
        this.vbirthplace = vbirthplace;
    }

    public String getVnpwp() {
        return vnpwp;
    }

    public void setVnpwp(String vnpwp) {
        this.vnpwp = vnpwp;
    }

    public String getVhpnum() {
        return vhpnum;
    }

    public void setVhpnum(String vhpnum) {
        this.vhpnum = vhpnum;
    }

    public Date getDprosdate() {
        return dprosdate;
    }

    public void setDprosdate(Date dprosdate) {
        this.dprosdate = dprosdate;
    }

    public String getVsex() {
        return vsex;
    }

    public void setVsex(String vsex) {
        this.vsex = vsex;
    }

    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

    public String getVmbirthdt() {
        return vmbirthdt;
    }

    public void setVmbirthdt(String vmbirthdt) {
        this.vmbirthdt = vmbirthdt;
    }

    public Date getDdatebuy() {
        return ddatebuy;
    }

    public void setDdatebuy(Date ddatebuy) {
        this.ddatebuy = ddatebuy;
    }

    public String getVjobcode() {
        return vjobcode;
    }

    public void setVjobcode(String vjobcode) {
        this.vjobcode = vjobcode;
    }

    public String getVrelcode() {
        return vrelcode;
    }

    public void setVrelcode(String vrelcode) {
        this.vrelcode = vrelcode;
    }

    public String getVeducode() {
        return veducode;
    }

    public void setVeducode(String veducode) {
        this.veducode = veducode;
    }

    public String getVemail() {
        return vemail;
    }

    public void setVemail(String vemail) {
        this.vemail = vemail;
    }

    public String getVidAhmdsh1cMstcustgrp() {
        return vidAhmdsh1cMstcustgrp;
    }

    public void setVidAhmdsh1cMstcustgrp(String vidAhmdsh1cMstcustgrp) {
        this.vidAhmdsh1cMstcustgrp = vidAhmdsh1cMstcustgrp;
    }

    public Ahmdsh1cMstcustgrp getAhmdsh1cMstcustgrp() {
        return ahmdsh1cMstcustgrp;
    }

    public void setAhmdsh1cMstcustgrp(Ahmdsh1cMstcustgrp ahmdsh1cMstcustgrp) {
        this.ahmdsh1cMstcustgrp = ahmdsh1cMstcustgrp;
    }

    public String getVidcardh1() {
        return vidcardh1;
    }

    public void setVidcardh1(String vidcardh1) {
        this.vidcardh1 = vidcardh1;
    }

    public String getVidcardh2() {
        return vidcardh2;
    }

    public void setVidcardh2(String vidcardh2) {
        this.vidcardh2 = vidcardh2;
    }

    public String getVidcardh3() {
        return vidcardh3;
    }

    public void setVidcardh3(String vidcardh3) {
        this.vidcardh3 = vidcardh3;
    }

    public String getVcontactid() {
        return vcontactid;
    }

    public void setVcontactid(String vcontactid) {
        this.vcontactid = vcontactid;
    }

    public String getVbrandprev() {
        return vbrandprev;
    }

    public void setVbrandprev(String vbrandprev) {
        this.vbrandprev = vbrandprev;
    }

    public String getVtypeprev() {
        return vtypeprev;
    }

    public void setVtypeprev(String vtypeprev) {
        this.vtypeprev = vtypeprev;
    }

    public String getVcatprev() {
        return vcatprev;
    }

    public void setVcatprev(String vcatprev) {
        this.vcatprev = vcatprev;
    }

    public Date getDtransh1() {
        return dtransh1;
    }

    public void setDtransh1(Date dtransh1) {
        this.dtransh1 = dtransh1;
    }

    public Date getDtransh2() {
        return dtransh2;
    }

    public void setDtransh2(Date dtransh2) {
        this.dtransh2 = dtransh2;
    }

    public Date getDtransh3() {
        return dtransh3;
    }

    public void setDtransh3(Date dtransh3) {
        this.dtransh3 = dtransh3;
    }

    public String getVhomstat() {
        return vhomstat;
    }

    public void setVhomstat(String vhomstat) {
        this.vhomstat = vhomstat;
    }

    public String getVhpstat() {
        return vhpstat;
    }

    public void setVhpstat(String vhpstat) {
        this.vhpstat = vhpstat;
    }

    public String getVcondition() {
        return vcondition;
    }

    public void setVcondition(String vcondition) {
        this.vcondition = vcondition;
    }

    public String getVnote() {
        return vnote;
    }

    public void setVnote(String vnote) {
        this.vnote = vnote;
    }

    public String getVgroup() {
        return vgroup;
    }

    public void setVgroup(String vgroup) {
        this.vgroup = vgroup;
    }

    public String getVflmediator() {
        return vflmediator;
    }

    public void setVflmediator(String vflmediator) {
        this.vflmediator = vflmediator;
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

    public String getVexpense() {
        return vexpense;
    }

    public void setVexpense(String vexpense) {
        this.vexpense = vexpense;
    }

    public String getVpicname() {
        return vpicname;
    }

    public void setVpicname(String vpicname) {
        this.vpicname = vpicname;
    }

    public String getVavailable() {
        return vavailable;
    }

    public void setVavailable(String vavailable) {
        this.vavailable = vavailable;
    }

    public String getVusefor() {
        return vusefor;
    }

    public void setVusefor(String vusefor) {
        this.vusefor = vusefor;
    }

    public String getVuser() {
        return vuser;
    }

    public void setVuser(String vuser) {
        this.vuser = vuser;
    }

    public String getVframeprev() {
        return vframeprev;
    }

    public void setVframeprev(String vframeprev) {
        this.vframeprev = vframeprev;
    }

    public String getVfollowup() {
        return vfollowup;
    }

    public void setVfollowup(String vfollowup) {
        this.vfollowup = vfollowup;
    }

    public Integer getNyearprod() {
        return nyearprod;
    }

    public void setNyearprod(Integer nyearprod) {
        this.nyearprod = nyearprod;
    }

    public Byte[] getVimage() {
        return vimage;
    }

    public void setVimage(Byte[] vimage) {
        this.vimage = vimage;
    }

    public Integer getNseqflwup() {
        return nseqflwup;
    }

    public void setNseqflwup(Integer nseqflwup) {
        this.nseqflwup = nseqflwup;
    }
}
