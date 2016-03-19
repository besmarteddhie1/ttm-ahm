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

/**
 *
 * @author george
 */
@Entity
@Table(name = "AHMDSH1C_MSTKELURAHAN")
public class Ahmdsh1cMstkelurahan extends BaseAuditVersioning implements Serializable{
    @Column(name="VIDKEL",length=10,unique=true,nullable=false)
    private String vidkel;
    
    @Column(name="VKELDESC",length=100,nullable=false)
    private String vkeldesc;
    
    @Column(name="VID_AHMDSH1C_MSTKECAMATAN",length=64,nullable=false)
    private String vidAhmdsh1cMstkecamatan;
    
    @Column(name="VPOSTCODE",length=5,nullable=false)
    private String vpostcode;
    
    @Column(name = "VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name = "VIDB2B",length=40)
    private String vidb2b;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstkecamatan.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTKECAMATAN",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstkecamatan ahmdsh1cMstkecamatan;

    public String getVkeldesc() {
        return vkeldesc;
    }

    public void setVkeldesc(String vkeldesc) {
        this.vkeldesc = vkeldesc;
    }

    public String getVidAhmdsh1cMstkecamatan() {
        return vidAhmdsh1cMstkecamatan;
    }

    public void setVidAhmdsh1cMstkecamatan(String vidAhmdsh1cMstkecamatan) {
        this.vidAhmdsh1cMstkecamatan = vidAhmdsh1cMstkecamatan;
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

    public Ahmdsh1cMstkecamatan getAhmdsh1cMstkecamatan() {
        return ahmdsh1cMstkecamatan;
    }

    public void setAhmdsh1cMstkecamatan(Ahmdsh1cMstkecamatan ahmdsh1cMstkecamatan) {
        this.ahmdsh1cMstkecamatan = ahmdsh1cMstkecamatan;
    }

    public String getVidkel() {
        return vidkel;
    }

    public void setVidkel(String vidkel) {
        this.vidkel = vidkel;
    }

    public String getVpostcode() {
        return vpostcode;
    }

    public void setVpostcode(String vpostcode) {
        this.vpostcode = vpostcode;
    }

}
