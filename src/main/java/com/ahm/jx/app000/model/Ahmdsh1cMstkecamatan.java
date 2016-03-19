/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "AHMDSH1C_MSTKECAMATAN")
public class Ahmdsh1cMstkecamatan extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VIDKEC",length=10,nullable=false,unique=true)
    private String vidkec;
    
    @Column(name="VKECDESC",length=100,nullable=false)
    private String vkecdesc;
    
    @Column(name="VID_AHMDSH1C_MSTCITY",length=64,nullable=false)
    private String vidAhmdsh1cMstcity;
    
    @Column(name = "VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name = "VIDB2B",length=40)
    private String vidb2b;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstcity.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTCITY", referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstcity ahmdsh1cMstcity;

    public String getVidkec() {
        return vidkec;
    }

    public void setVidkec(String vidkec) {
        this.vidkec = vidkec;
    }

    public String getvKecdesc() {
        return vkecdesc;
    }

    public void setvKecdesc(String vKecdesc) {
        this.vkecdesc = vKecdesc;
    }

    public String getvIdAhmdsh1cMstcity() {
        return vidAhmdsh1cMstcity;
    }

    public void setvIdAhmdsh1cMstcity(String vIdAhmdsh1cMstcity) {
        this.vidAhmdsh1cMstcity = vIdAhmdsh1cMstcity;
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

    public Ahmdsh1cMstcity getAhmdsh1cMstcity() {
        return ahmdsh1cMstcity;
    }

    public void setAhmdsh1cMstcity(Ahmdsh1cMstcity ahmdsh1cMstcity) {
        this.ahmdsh1cMstcity = ahmdsh1cMstcity;
    }
    
}
