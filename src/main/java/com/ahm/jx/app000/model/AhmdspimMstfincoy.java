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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author george
 */
@Entity
@Table(name = "AHMDSPIM_MSTFINCOY")
public class AhmdspimMstfincoy extends BaseAuditVersioning implements Serializable {

    @Column(name = "VFCCODE", unique = true, length = 10, nullable = false)
    private String vfccode;
    @Column(name = "VFCDOCTYPE", length = 1, nullable = false)
    private String vfcdoctype;
    @Column(name = "VFCDOCID", length = 30, nullable = false)
    private String vfcdocid;
    @Column(name = "VFCNAME", length = 100, nullable = false)
    private String vfcname;
    @Column(name = "VFCADDR", length = 100, nullable = false)
    private String vfcaddr;
    @Column(name = "VFCKEL", length = 30)
    private String vfckel;
    @Column(name = "VFCKEC", length = 30)
    private String vfckec;
    @Column(name = "VFCCITY", length = 5, nullable = false)
    private String vfccity;
    @Column(name = "VFCACC", length = 1)
    private String vfcacc;
    @Column(name = "VFCPROP", length = 5, nullable = false)
    private String vfcprop;
    @Column(name = "VFCZIPCD", length = 6)
    private String vfczipcd;
    @Column(name = "DBGNEFF", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbgneff;
    @Column(name = "DENDEFF", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dendeff;
    @Column(name = "VFCRECON", length = 1)
    private String vfcrecon;
    @Column(name = "VSHORTNAME", length = 15)
    private String vshortname;
    @Column(name = "VB2BSTAT", length = 1)
    private String vb2bstat;
    @Column(name = "VIDB2B", length = 40)
    private String vidb2b;

    public String getVfccode() {
        return vfccode;
    }

    public void setVfccode(String vfccode) {
        this.vfccode = vfccode;
    }

    public String getVfcdoctype() {
        return vfcdoctype;
    }

    public void setVfcdoctype(String vfcdoctype) {
        this.vfcdoctype = vfcdoctype;
    }

    public String getVfcdocid() {
        return vfcdocid;
    }

    public void setVfcdocid(String vfcdocid) {
        this.vfcdocid = vfcdocid;
    }

    public String getVfcname() {
        return vfcname;
    }

    public void setVfcname(String vfcname) {
        this.vfcname = vfcname;
    }

    public String getVfcaddr() {
        return vfcaddr;
    }

    public void setVfcaddr(String vfcaddr) {
        this.vfcaddr = vfcaddr;
    }

    public String getVfckel() {
        return vfckel;
    }

    public void setVfckel(String vfckel) {
        this.vfckel = vfckel;
    }

    public String getVfckec() {
        return vfckec;
    }

    public void setVfckec(String vfckec) {
        this.vfckec = vfckec;
    }

    public String getVfccity() {
        return vfccity;
    }

    public void setVfccity(String vfccity) {
        this.vfccity = vfccity;
    }

    public String getVfcacc() {
        return vfcacc;
    }

    public void setVfcacc(String vfcacc) {
        this.vfcacc = vfcacc;
    }

    public String getVfcprop() {
        return vfcprop;
    }

    public void setVfcprop(String vfcprop) {
        this.vfcprop = vfcprop;
    }

    public String getVfczipcd() {
        return vfczipcd;
    }

    public void setVfczipcd(String vfczipcd) {
        this.vfczipcd = vfczipcd;
    }

    public Date getDbgneff() {
        return dbgneff;
    }

    public void setDbgneff(Date dbgneff) {
        this.dbgneff = dbgneff;
    }

    public Date getDendeff() {
        return dendeff;
    }

    public void setDendeff(Date dendeff) {
        this.dendeff = dendeff;
    }

    public String getVfcrecon() {
        return vfcrecon;
    }

    public void setVfcrecon(String vfcrecon) {
        this.vfcrecon = vfcrecon;
    }

    public String getVshortname() {
        return vshortname;
    }

    public void setVshortname(String vshortname) {
        this.vshortname = vshortname;
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
