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
@Table(name="AHMDSH1C_MSTACCSVSMTR",
        uniqueConstraints=@UniqueConstraint(columnNames={"VID_AHMDSH1C_MSTACCESSORIES","VID_AHMDSH1C_MSTTYPECLR"}))
public class Ahmdsh1cMstaccsvsmtr extends BaseAuditVersioning implements Serializable{
    @Column(name="VID_AHMDSH1C_MSTACCESSORIES",length=64,nullable=false)
    private String vidAhmdsh1cMstaccessories;
    
    @Column(name="VID_AHMDSH1C_MSTTYPECLR",length=64,nullable=false)
    private String vidAhmdsh1cMsttypeclr;
    
    @Column(name = "VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name = "VIDB2B",length=40)
    private String vidb2b;

    @ManyToOne(targetEntity=Ahmdsh1cMstaccessories.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTACCESSORIES",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstaccessories ahmdsh1cMstaccessories;
    
    @ManyToOne(targetEntity=Ahmdsh1cMsttypeclr.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTTYPECLR",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMsttypeclr ahmdsh1cMsttypeclr;
    
    public String getVidAhmdsh1cMstaccessories() {
        return vidAhmdsh1cMstaccessories;
    }

    public void setVidAhmdsh1cMstaccessories(String vidAhmdsh1cMstaccessories) {
        this.vidAhmdsh1cMstaccessories = vidAhmdsh1cMstaccessories;
    }

    public String getVidAhmdsh1cMsttypeclr() {
        return vidAhmdsh1cMsttypeclr;
    }

    public void setVidAhmdsh1cMsttypeclr(String vidAhmdsh1cMsttypeclr) {
        this.vidAhmdsh1cMsttypeclr = vidAhmdsh1cMsttypeclr;
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

    public Ahmdsh1cMsttypeclr getAhmdsh1cMsttypeclr() {
        return ahmdsh1cMsttypeclr;
    }

    public void setAhmdsh1cMsttypeclr(Ahmdsh1cMsttypeclr ahmdsh1cMsttypeclr) {
        this.ahmdsh1cMsttypeclr = ahmdsh1cMsttypeclr;
    }
    
}
