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
@Table(name = "AHMDSCDB_MSTHUMANRLTN")
public class AhmdscdbMsthumanrltn extends BaseAuditVersioning implements Serializable {

    @Column(name = "VIDPROSPEK1", length = 64, nullable = false)
    private String vidprospek1;
    @Column(name = "VIDPROSPEK2", length = 64, nullable = false)
    private String vidprospek2;
    @Column(name = "VRELATIONTYPE", length = 1, nullable = false)
    private String vrelationtype;
    @Column(name = "VB2BSTAT", length = 1)
    private String vb2bstat;
    @Column(name = "VID_AHMDSBSC_MSTDLRCODE", length = 64, nullable = false)
    private String vidAhmdsbscMstdlrcode;
    @ManyToOne(targetEntity = AhmdsbscMstdlrcode.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSBSC_MSTDLRCODE", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    @ManyToOne(targetEntity = Ahmdsh1cMstprospek.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VIDPROSPEK1", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMstprospek ahmdsh1cMstprospek1;
    @ManyToOne(targetEntity = Ahmdsh1cMstprospek.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VIDPROSPEK2", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMstprospek ahmdsh1cMstprospek2;

    public String getVidprospek1() {
        return vidprospek1;
    }

    public void setVidprospek1(String vidprospek1) {
        this.vidprospek1 = vidprospek1;
    }

    public String getVidprospek2() {
        return vidprospek2;
    }

    public void setVidprospek2(String vidprospek2) {
        this.vidprospek2 = vidprospek2;
    }

    public String getVrelationtype() {
        return vrelationtype;
    }

    public void setVrelationtype(String vrelationtype) {
        this.vrelationtype = vrelationtype;
    }

    public String getVb2bstat() {
        return vb2bstat;
    }

    public void setVb2bstat(String vb2bstat) {
        this.vb2bstat = vb2bstat;
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

    public Ahmdsh1cMstprospek getAhmdsh1cMstprospek1() {
        return ahmdsh1cMstprospek1;
    }

    public void setAhmdsh1cMstprospek1(Ahmdsh1cMstprospek ahmdsh1cMstprospek1) {
        this.ahmdsh1cMstprospek1 = ahmdsh1cMstprospek1;
    }

    public Ahmdsh1cMstprospek getAhmdsh1cMstprospek2() {
        return ahmdsh1cMstprospek2;
    }

    public void setAhmdsh1cMstprospek2(Ahmdsh1cMstprospek ahmdsh1cMstprospek2) {
        this.ahmdsh1cMstprospek2 = ahmdsh1cMstprospek2;
    }
    
}
