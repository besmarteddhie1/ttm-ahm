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
 * @author george
 */
@Entity
@Table(name="AHMDSH1C_MSTACSSTOCK",
        uniqueConstraints=@UniqueConstraint(columnNames={"VID_AHMDSH1C_MSTACCESORIES","VID_AHMDSH1C_MSTIDWHS","VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cMstacsstock extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VID_AHMDSH1C_MSTACCESORIES",nullable=false,length=64)
    private String vidAhmdsh1cMstaccesories;
    
    @Column(name="VID_AHMDSH1C_MSTIDWHS",nullable=false,length=64)
    private String vidAhmdsh1cMstidwhs;
    
    @Column(name="NQTY",nullable=false)
    private Integer nqty;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstaccessories.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTACCESORIES",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstaccessories ahmdsh1cMstaccessories;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstidwhs.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTIDWHS",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstidwhs ahmdsh1cMstidwhs;
    
    @Column(name = "VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name = "VIDB2B",length=40)
    private String vidb2b;

    public String getVidAhmdsh1cMstaccesories() {
        return vidAhmdsh1cMstaccesories;
    }

    public void setVidAhmdsh1cMstaccesories(String vidAhmdsh1cMstaccesories) {
        this.vidAhmdsh1cMstaccesories = vidAhmdsh1cMstaccesories;
    }

    public String getVidAhmdsh1cMstidwhs() {
        return vidAhmdsh1cMstidwhs;
    }

    public void setVidAhmdsh1cMstidwhs(String vidAhmdsh1cMstidwhs) {
        this.vidAhmdsh1cMstidwhs = vidAhmdsh1cMstidwhs;
    }

    public Integer getNqty() {
        return nqty;
    }

    public void setNqty(Integer nqty) {
        this.nqty = nqty;
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

    public Ahmdsh1cMstaccessories getAhmdsh1cMstaccessories() {
        return ahmdsh1cMstaccessories;
    }

    public void setAhmdsh1cMstaccessories(Ahmdsh1cMstaccessories ahmdsh1cMstaccessories) {
        this.ahmdsh1cMstaccessories = ahmdsh1cMstaccessories;
    }

    public Ahmdsh1cMstidwhs getAhmdsh1cMstidwhs() {
        return ahmdsh1cMstidwhs;
    }

    public void setAhmdsh1cMstidwhs(Ahmdsh1cMstidwhs ahmdsh1cMstidwhs) {
        this.ahmdsh1cMstidwhs = ahmdsh1cMstidwhs;
    }
    
}
