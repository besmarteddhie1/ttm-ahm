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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author george
 */
@Entity
@Table(name="AHMDSH1C_MSTCUSTGRP",
        uniqueConstraints=@UniqueConstraint(columnNames={"VIDCUSTGRP","VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cMstcustgrp extends BaseAuditVersioning implements Serializable{
    @Column(name="VIDCUSTGRP",length=20,nullable=false)
    private String vidcustgrp;
    
    @Column(name="VCUSTGRPDESC",length=30,nullable=false)
    private String vcustgrpdesc;
    
    @Column(name="NDISCGRPH1",scale=10,precision=0,nullable=false)
    private BigDecimal ndiscgrph1;
    
    @Column(name="DBGNEFFH1",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbgneffh1;
    
    @Column(name="DENDEFFH1",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dendeffh1;
    
    @Column(name="NDISCGRPH2",scale=5,precision=2)
    private Double ndiscgrph2;
    
    @Column(name="NDISCGRPH3",scale=5,precision=2)
    private Double ndiscgrph3;
    
    @Column(name="DBGNEFFH2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbgneffh2;
    
    @Column(name="DENDEFFH2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dendeffh2;
    
    @Column(name="DBGNEFFH3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbgneffh3;
    
    @Column(name="DENDEFFH3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dendeffh3;
    
    @Column(name="VADDRESS1",length=50,nullable=false)
    private String vaddress1;
    
    @Column(name="VADDRESS2",length=50)
    private String vaddress2;
    
    @Column(name="VPHONE1",length=20,nullable=false)
    private String vphone1;
    
    @Column(name="VPHONE2",length=20)
    private String vphone2;
    
    @Column(name="VID_AHMDSH1C_MSTKELURAHAN",length=64,nullable=false)
    private String vidAhmdsh1cMstkelurahan;
     
    @ManyToOne(targetEntity=Ahmdsh1cMstkelurahan.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTKELURAHAN",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstkelurahan ahmdsh1cMstkelurahan;
    
    @Column(name = "VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name = "VIDB2B",length=40)
    private String vidb2b;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",length=64,nullable=false)
    private String vidAhmdsbscMstdlrcode;

    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    public String getVidcustgrp() {
        return vidcustgrp;
    }

    public void setVidcustgrp(String vIdcustgrp) {
        this.vidcustgrp = vIdcustgrp;
    }

    public String getVcustgrpdesc() {
        return vcustgrpdesc;
    }

    public void setVcustgrpdesc(String vCustgrpdesc) {
        this.vcustgrpdesc = vCustgrpdesc;
    }

    public BigDecimal getNdiscgrph1() {
        return ndiscgrph1;
    }

    public void setNdiscgrph1(BigDecimal nDiscgrph1) {
        this.ndiscgrph1 = nDiscgrph1;
    }

    public Date getDbgneffh1() {
        return dbgneffh1;
    }

    public void setDbgneffh1(Date dBgneffh1) {
        this.dbgneffh1 = dBgneffh1;
    }

    public Date getDendeffh1() {
        return dendeffh1;
    }

    public void setDendeffh1(Date dEndeffh1) {
        this.dendeffh1 = dEndeffh1;
    }

    public Double getNdiscgrph2() {
        return ndiscgrph2;
    }

    public void setNdiscgrph2(Double nDiscgrph2) {
        this.ndiscgrph2 = nDiscgrph2;
    }

    public Double getNdiscgrph3() {
        return ndiscgrph3;
    }

    public void setNdiscgrph3(Double nDiscgrph3) {
        this.ndiscgrph3 = nDiscgrph3;
    }

    public Date getDbgneffh2() {
        return dbgneffh2;
    }

    public void setDbgneffh2(Date dBgneffh2) {
        this.dbgneffh2 = dBgneffh2;
    }

    public Date getDendeffh2() {
        return dendeffh2;
    }

    public void setDendeffh2(Date dEndeffh2) {
        this.dendeffh2 = dEndeffh2;
    }

    public Date getDbgneffh3() {
        return dbgneffh3;
    }

    public void setDbgneffh3(Date dBgneffh3) {
        this.dbgneffh3 = dBgneffh3;
    }

    public Date getDendeffh3() {
        return dendeffh3;
    }

    public void setDendeffh3(Date dEndeffh3) {
        this.dendeffh3 = dEndeffh3;
    }

    public Ahmdsh1cMstkelurahan getAhmdsh1cMstkelurahan() {
        return ahmdsh1cMstkelurahan;
    }

    public void setAhmdsh1cMstkelurahan(Ahmdsh1cMstkelurahan ahmdsh1cMstkelurahan) {
        this.ahmdsh1cMstkelurahan = ahmdsh1cMstkelurahan;
    }

    public String getVaddress1() {
        return vaddress1;
    }

    public void setVaddress1(String vAddress1) {
        this.vaddress1 = vAddress1;
    }

    public String getVaddress2() {
        return vaddress2;
    }

    public void setVaddress2(String vAddress2) {
        this.vaddress2 = vAddress2;
    }

    public String getVphone1() {
        return vphone1;
    }

    public void setVphone1(String vPhone1) {
        this.vphone1 = vPhone1;
    }

    public String getVphone2() {
        return vphone2;
    }

    public void setVphone2(String vPhone2) {
        this.vphone2 = vPhone2;
    }

    public String getVidAhmdsh1cMstkelurahan() {
        return vidAhmdsh1cMstkelurahan;
    }

    public void setVidAhmdsh1cMstkelurahan(String vidAhmdsh1cMstkelurahan) {
        this.vidAhmdsh1cMstkelurahan = vidAhmdsh1cMstkelurahan;
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

    public void setVidAhmdsbscMstdlrcode(String vDlrcode) {
        this.vidAhmdsbscMstdlrcode = vDlrcode;
    }

    public AhmdsbscMstdlrcode getAhmdsbscMstdlrcode() {
        return ahmdsbscMstdlrcode;
    }

    public void setAhmdsbscMstdlrcode(AhmdsbscMstdlrcode ahmdsbscMstdlrcode) {
        this.ahmdsbscMstdlrcode = ahmdsbscMstdlrcode;
    }
    
}
