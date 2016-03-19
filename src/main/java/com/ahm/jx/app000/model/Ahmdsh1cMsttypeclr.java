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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author achmad.ha
 */
@Entity
@Table(name = "AHMDSH1C_MSTTYPECLR",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VTYPECODE", "VCLRCODE"}))
public class Ahmdsh1cMsttypeclr extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VTYPECODE",length=6,nullable=false)
    private String vtypecode;
    
    @Column(name="VCLRCODE",length=6,nullable=false)
    private String vclrcode;
    
    @Column(name="VCLRDESC",length=30,nullable=false)
    private String vclrdesc;
    
    @Column(name="VTYPEDESC",length=30,nullable=false)
    private String vtypedesc;
    
    @Column(name="VTYPEDESC1",length=30,nullable=false)
    private String vtypedesc1;
    
    @Column(name="VITEMCODE",length=30,nullable=false)
    private String vitemcode;
    
    @Column(name="VITEMDESC",length=60,nullable=false)
    private String vitemdesc;
    
    @Column(name="VCCMTR",length=10,nullable=false)
    private String vccmtr;
    
    @Column(name="VGROUP",length=6,nullable=false)
    private String vgroup;
    
    @Column(name="MHETUNIT")
    private Double mhetunit;
    
    @Column(name="MBBN")
    private Double mbbn;
    
    @Column(name="VFLCBU",length=1)
    private String vflcbu;
    
    @Column(name="DBGNEFF",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbgneff;
    
    @Column(name="DENDEFF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dendeff;
    
    @Column(name = "VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name = "VIDB2B",length=40)
    private String vidb2b;
    
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

    public String getVclrdesc() {
        return vclrdesc;
    }

    public void setVclrdesc(String vclrdesc) {
        this.vclrdesc = vclrdesc;
    }

    public String getVtypedesc() {
        return vtypedesc;
    }

    public void setVtypedesc(String vtypedesc) {
        this.vtypedesc = vtypedesc;
    }

    public String getVtypedesc1() {
        return vtypedesc1;
    }

    public void setVtypedesc1(String vtypedesc1) {
        this.vtypedesc1 = vtypedesc1;
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

    public String getVgroup() {
        return vgroup;
    }

    public void setVgroup(String vgroup) {
        this.vgroup = vgroup;
    }

    public String getVitemcode() {
        return vitemcode;
    }

    public void setVitemcode(String vitemcode) {
        this.vitemcode = vitemcode;
    }

    public String getVitemdesc() {
        return vitemdesc;
    }

    public void setVitemdesc(String vitemdesc) {
        this.vitemdesc = vitemdesc;
    }

    public String getVccmtr() {
        return vccmtr;
    }

    public void setVccmtr(String vccmtr) {
        this.vccmtr = vccmtr;
    }

    public Double getMhetunit() {
        return mhetunit;
    }

    public void setMhetunit(Double mhetunit) {
        this.mhetunit = mhetunit;
    }

    public Double getMbbn() {
        return mbbn;
    }

    public void setMbbn(Double mbbn) {
        this.mbbn = mbbn;
    }

    public String getVflcbu() {
        return vflcbu;
    }

    public void setVflcbu(String vflcbu) {
        this.vflcbu = vflcbu;
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
