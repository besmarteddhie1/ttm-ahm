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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author achmad.ha
 */
@Entity
@Table(name = "AHMDSH1C_HDRUNITPO",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VIDUNITPO", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cHdrunitpo extends BaseAuditVersioning implements  Serializable{

    @Column(name="VIDUNITPO",length=64,nullable=false)
    private String vidunitpo;
    
    @Column(name="NYEAR",precision=11,scale=0,nullable=false)
    private Integer nyear;

    @Column(name="NMONTH",precision=11,scale=0,nullable=false)
    private Integer nmonth;
    
    @Column(name="VTYPEPO",length=1,nullable=false)
    private String vtypepo;
    
    @Column(name="ISEQ",precision=11,nullable=false)
    private Integer iseq;
    
    @Column(name="DSTARTPO",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dstartpo;               
    
    @Column(name="DENDPO")    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dendpo;
        
    @Column(name="VB2BSTAT",length=1)
    private String vb2stat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;
    
    @Column(name="ISENDTOMD",precision=11,nullable=false)
    private Integer isendtomd;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="ahmdsh1cHdrunitpo")    
    private List<Ahmdsh1cDtlunitpo> listAhmdsh1cDtlunitpo;

    public String getVidunitpo() {
        return vidunitpo;
    }

    public void setVidunitpo(String vidunitpo) {
        this.vidunitpo = vidunitpo;
    }

    public Integer getNyear() {
        return nyear;
    }

    public void setNyear(Integer nyear) {
        this.nyear = nyear;
    }

    public Integer getNmonth() {
        return nmonth;
    }

    public void setNmonth(Integer nmonth) {
        this.nmonth = nmonth;
    }

    public String getVtypepo() {
        return vtypepo;
    }

    public void setVtypepo(String vtypepo) {
        this.vtypepo = vtypepo;
    }

    public Integer getIseq() {
        return iseq;
    }

    public void setIseq(Integer iseq) {
        this.iseq = iseq;
    }
    
    public Date getDstartpo() {
        return dstartpo;
    }

    public void setDstartpo(Date dstartpo) {
        this.dstartpo = dstartpo;
    }

    public Date getDendpo() {
        return dendpo;
    }

    public void setDendpo(Date dendpo) {
        this.dendpo = dendpo;
    }

    public String getVb2stat() {
        return vb2stat;
    }

    public void setVb2stat(String vb2stat) {
        this.vb2stat = vb2stat;
    }

    public String getVidb2b() {
        return vidb2b;
    }

    public void setVidb2b(String vidb2b) {
        this.vidb2b = vidb2b;
    }

    public Integer getIsendtomd() {
        return isendtomd;
    }

    public void setIsendtomd(Integer isendtomd) {
        this.isendtomd = isendtomd;
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

    public List<Ahmdsh1cDtlunitpo> getListAhmdsh1cDtlunitpo() {
        return listAhmdsh1cDtlunitpo;
    }

    public void setListAhmdsh1cDtlunitpo(List<Ahmdsh1cDtlunitpo> listAhmdsh1cDtlunitpo) {
        this.listAhmdsh1cDtlunitpo = listAhmdsh1cDtlunitpo;
    }   
}
