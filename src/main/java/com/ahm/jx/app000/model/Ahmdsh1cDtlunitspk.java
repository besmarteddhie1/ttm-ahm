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
 * @author laurentinus
 */
@Entity
@Table(name = "AHMDSH1C_DTLUNITSPK",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMDSH1C_HDRUNITSPK", "VID_AHMDSH1C_MSTTYPECLR", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cDtlunitspk extends BaseAuditVersioning implements Serializable{
    /*
    @Column(name="VID_AHMDSH1C_HDRUNITSPK",length=64, nullable=false)
    private String vidAhmdsh1cHdrunitspk;
    */
    @ManyToOne(targetEntity=Ahmdsh1cHdrunitspk.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_HDRUNITSPK",referencedColumnName="VID")
    private Ahmdsh1cHdrunitspk ahmdsh1cHdrunitspk;
    
    @Column(name="VID_AHMDSH1C_MSTTYPECLR",length=64, nullable=false)
    private String vidAhmdsh1cMsttypeclr;
    
    @ManyToOne(targetEntity=Ahmdsh1cMsttypeclr.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTTYPECLR",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMsttypeclr ahmdsh1cMsttypeclr;
    
    @Column(name="NQTY",precision=11,scale=0)
    private Integer nqty = new Integer(0);
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;

    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    /*
    public String getVidAhmdsh1cHdrunitspk() {
        return vidAhmdsh1cHdrunitspk;
    }

    public void setVidAhmdsh1cHdrunitspk(String vidAhmdsh1cHdrunitspk) {
        this.vidAhmdsh1cHdrunitspk = vidAhmdsh1cHdrunitspk;
    }
    * */
    public Ahmdsh1cHdrunitspk getAhmdsh1cHdrunitspk() {
        return ahmdsh1cHdrunitspk;
    }

    public void setAhmdsh1cHdrunitspk(Ahmdsh1cHdrunitspk ahmdsh1cHdrunitspk) {
        this.ahmdsh1cHdrunitspk = ahmdsh1cHdrunitspk;
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

    public Integer getNqty() {
        return nqty;
    }

    public void setNqty(Integer nqty) {
        this.nqty = nqty;
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
