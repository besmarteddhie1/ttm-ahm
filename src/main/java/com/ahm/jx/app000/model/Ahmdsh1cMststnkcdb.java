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
@Table(name = "AHMDSH1C_MSTSTNKCDB")
public class Ahmdsh1cMststnkcdb extends BaseAuditVersioning implements Serializable {

    @Column(name = "VID_AHMDSH1C_MSTMOTOR",length=64)
    private String vidAhmdsh1cMstmotor;
    @Column(name = "VSTNKSTAT",length=1)
    private String vstnkstat;
    @Column(name = "VCDBSTAT",length=1)
    private String vcdbstat;
    @Column(name = "VSTATUS",length=1)
    private String vstatus;
    @Column(name = "VID_AHMDSH1C_HDRUNITSPK",length=64)
    private String vidAhmdsh1cHdrunitspk;
    @Column(name = "VID_AHMDSBSC_MSTDLRCODE",length=64)
    private String vidAhmdsbscMstdlrcode;
    @ManyToOne(targetEntity = Ahmdsh1cMstmotor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTMOTOR", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMstmotor ahmdsh1cMstmotor;
    @ManyToOne(targetEntity = Ahmdsh1cHdrunitspk.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_HDRUNITSPK", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cHdrunitspk ahmdsh1cHdrunitspk;
    @ManyToOne(targetEntity = AhmdsbscMstdlrcode.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSBSC_MSTDLRCODE", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;

    public String getVidAhmdsh1cMstmotor() {
        return vidAhmdsh1cMstmotor;
    }

    public void setVidAhmdsh1cMstmotor(String vidAhmdsh1cMstmotor) {
        this.vidAhmdsh1cMstmotor = vidAhmdsh1cMstmotor;
    }

    public String getVstnkstat() {
        return vstnkstat;
    }

    public void setVstnkstat(String vstnkstat) {
        this.vstnkstat = vstnkstat;
    }

    public String getVcdbstat() {
        return vcdbstat;
    }

    public void setVcdbstat(String vcdbstat) {
        this.vcdbstat = vcdbstat;
    }

    public String getVstatus() {
        return vstatus;
    }

    public void setVstatus(String vstatus) {
        this.vstatus = vstatus;
    }

    public String getVidAhmdsh1cHdrunitspk() {
        return vidAhmdsh1cHdrunitspk;
    }

    public void setVidAhmdsh1cHdrunitspk(String vidAhmdsh1cHdrunitspk) {
        this.vidAhmdsh1cHdrunitspk = vidAhmdsh1cHdrunitspk;
    }

    public String getVidAhmdsbscMstdlrcode() {
        return vidAhmdsbscMstdlrcode;
    }

    public void setVidAhmdsbscMstdlrcode(String vidAhmdsbscMstdlrcode) {
        this.vidAhmdsbscMstdlrcode = vidAhmdsbscMstdlrcode;
    }

    public Ahmdsh1cMstmotor getAhmdsh1cMstmotor() {
        return ahmdsh1cMstmotor;
    }

    public void setAhmdsh1cMstmotor(Ahmdsh1cMstmotor ahmdsh1cMstmotor) {
        this.ahmdsh1cMstmotor = ahmdsh1cMstmotor;
    }

    public Ahmdsh1cHdrunitspk getAhmdsh1cHdrunitspk() {
        return ahmdsh1cHdrunitspk;
    }

    public void setAhmdsh1cHdrunitspk(Ahmdsh1cHdrunitspk ahmdsh1cHdrunitspk) {
        this.ahmdsh1cHdrunitspk = ahmdsh1cHdrunitspk;
    }

    public AhmdsbscMstdlrcode getAhmdsbscMstdlrcode() {
        return ahmdsbscMstdlrcode;
    }

    public void setAhmdsbscMstdlrcode(AhmdsbscMstdlrcode ahmdsbscMstdlrcode) {
        this.ahmdsbscMstdlrcode = ahmdsbscMstdlrcode;
    }
}
