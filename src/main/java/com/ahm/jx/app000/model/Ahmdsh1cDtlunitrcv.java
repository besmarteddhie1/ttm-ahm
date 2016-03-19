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
 * @author laurentinus
 */
@Entity
@Table(name = "AHMDSH1C_DTLUNITRCV")
public class Ahmdsh1cDtlunitrcv extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VID_AHMDSH1C_HDRUNITRCV",length=64, nullable=false)
    private String vidAhmdsh1cHdrunitrcv;    
    
    @ManyToOne(targetEntity=Ahmdsh1cHdrunitrcv.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_HDRUNITRCV",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cHdrunitrcv ahmdsh1cHdrunitrcv;
    
    @Column(name="VID_AHMDSH1C_MSTMOTOR",length=64, nullable=false)
    private String vidAhmdsh1cMstmotor;    
    
    @ManyToOne(targetEntity=Ahmdsh1cMstmotor.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTMOTOR",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstmotor ahmdsh1cMstmotor;
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;

    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;

    public String getVidAhmdsh1cHdrunitrcv() {
        return vidAhmdsh1cHdrunitrcv;
    }

    public void setVidAhmdsh1cHdrunitrcv(String vidAhmdsh1cHdrunitrcv) {
        this.vidAhmdsh1cHdrunitrcv = vidAhmdsh1cHdrunitrcv;
    }

    public Ahmdsh1cHdrunitrcv getAhmdsh1cHdrunitrcv() {
        return ahmdsh1cHdrunitrcv;
    }

    public void setAhmdsh1cHdrunitrcv(Ahmdsh1cHdrunitrcv ahmdsh1cHdrunitrcv) {
        this.ahmdsh1cHdrunitrcv = ahmdsh1cHdrunitrcv;
    }

    public String getVidAhmdsh1cMstmotor() {
        return vidAhmdsh1cMstmotor;
    }

    public void setVidAhmdsh1cMstmotor(String vidAhmdsh1cMstmotor) {
        this.vidAhmdsh1cMstmotor = vidAhmdsh1cMstmotor;
    }

    public Ahmdsh1cMstmotor getAhmdsh1cMstmotor() {
        return ahmdsh1cMstmotor;
    }

    public void setAhmdsh1cMstmotor(Ahmdsh1cMstmotor ahmdsh1cMstmotor) {
        this.ahmdsh1cMstmotor = ahmdsh1cMstmotor;
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
