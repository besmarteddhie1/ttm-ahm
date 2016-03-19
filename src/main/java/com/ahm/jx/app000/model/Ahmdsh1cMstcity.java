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
 * @author achmad.ha
 */
@Entity
@Table(name = "AHMDSH1C_MSTCITY")
public class Ahmdsh1cMstcity extends BaseAuditVersioning implements Serializable{
    
    @Column(name = "VIDCITY",length=6,nullable=false,unique=true)
    private String vidcity;
    
    @Column(name = "VID_AHMDSH1C_MSTPROV",length=6)
    private String vidAhmdsh1cMstprov;
    
    @Column(name = "VCITYDESC",length=30)
    private String vcitydesc;
    
    @Column(name = "VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name = "VIDB2B",length=40)
    private String vidb2b;

    @ManyToOne(targetEntity=Ahmdsh1cMstprov.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTPROV",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstprov ahmdsh1cMstprov;
    
    public String getVidcity() {
        return vidcity;
    }

    public void setVidcity(String vidcity) {
        this.vidcity = vidcity;
    }

    public String getVidAhmdsh1cMstprov() {
        return vidAhmdsh1cMstprov;
    }

    public void setVidAhmdsh1cMstprov(String vidAhmdsh1cMstprov) {
        this.vidAhmdsh1cMstprov = vidAhmdsh1cMstprov;
    }

    public String getVcitydesc() {
        return vcitydesc;
    }

    public void setVcitydesc(String vcitydesc) {
        this.vcitydesc = vcitydesc;
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

    public Ahmdsh1cMstprov getAhmdsh1cMstprov() {
        return ahmdsh1cMstprov;
    }

    public void setAhmdsh1cMstprov(Ahmdsh1cMstprov ahmdsh1cMstprov) {
        this.ahmdsh1cMstprov = ahmdsh1cMstprov;
    }
    
}
