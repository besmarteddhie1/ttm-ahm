/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 *
 * @author sigit
 */
@Entity
@Table(name = "AHMJXUAM_MSTPARTNER")
public class AhmjxuamMstpartner extends BaseAuditVersioning implements Serializable {

    @Column(name = "VDEALERCODE", length = 6, nullable = false, unique = true)
    private String vdealercode;

    @Column(name = "VADDRESS", length = 100, nullable = false)
    private String vaddress;

    @Column(name = "VNAME", length = 35)
    private String vname;

    @Column(name = "VOWNER", length = 30, nullable = false)
    private String vowner;

    @Column(name = "VPHONENUM", length = 50, nullable = false)
    private String vphonenum;

    @Column(name = "VCITY", length = 45, nullable = false)
    private String vcity;

    @Column(name = "VMDCODE", length = 6, nullable = false)
    private String vmdcode;

    @Column(name = "DBEGINEFF", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbegineff;

    @Column(name = "DENDEFF", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dendeff;

    @Column(name = "NLEVEL", scale = 0, precision = 0, nullable = false)
    private Integer nlevel;

    @Lob
    @Column(name = "BCERT", nullable = false)
    private byte[] bcert;

    @Column(name = "VMDDLRCODE", length = 6)
    private String vmddlrcode;

    @Column(name = "NPIT")
    private Integer npit;

    public String getVdealercode() {
        return vdealercode;
    }

    public void setVdealercode(String vdealercode) {
        this.vdealercode = vdealercode;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVowner() {
        return vowner;
    }

    public void setVowner(String vowner) {
        this.vowner = vowner;
    }

    public String getVphonenum() {
        return vphonenum;
    }

    public void setVphonenum(String vphonenum) {
        this.vphonenum = vphonenum;
    }

    public String getVcity() {
        return vcity;
    }

    public void setVcity(String vcity) {
        this.vcity = vcity;
    }

    public String getVmdcode() {
        return vmdcode;
    }

    public void setVmdcode(String vmdcode) {
        this.vmdcode = vmdcode;
    }

    public Date getDbegineff() {
        return dbegineff;
    }

    public void setDbegineff(Date dbegineff) {
        this.dbegineff = dbegineff;
    }

    public Date getDendeff() {
        return dendeff;
    }

    public void setDendeff(Date dendeff) {
        this.dendeff = dendeff;
    }

    public Integer getNlevel() {
        return nlevel;
    }

    public void setNlevel(Integer nlevel) {
        this.nlevel = nlevel;
    }

    public byte[] getBcert() {
        return bcert;
    }

    public void setBcert(byte[] bcert) {
        this.bcert = bcert;
    }

    public String getVmddlrcode() {
        return vmddlrcode;
    }

    public void setVmddlrcode(String vmddlrcode) {
        this.vmddlrcode = vmddlrcode;
    }

    public Integer getNpit() {
        return npit;
    }

    public void setNpit(Integer npit) {
        this.npit = npit;
    }

}
