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
@Table(name = "AHMDSCDB_MSTMTRVSHMN")
public class AhmdscdbMstmtrvshmn extends BaseAuditVersioning implements Serializable {

    @Column(name = "VID_AHMDSMTS_MSTMOTOR", length = 64, nullable = false)
    private String vidAhmdsmtsMstmotor;
    @Column(name = "VID_AHMDSH1C_MSTPROSPEK", length = 64, nullable = false)
    private String vidAhmdsh1cMstprospek;
    @Column(name = "IPEMESAN")
    private Integer ipemesan;
    @Column(name = "IPEMBELI")
    private Integer ipembeli;
    @Column(name = "IPEMILIKSTNK")
    private Integer ipemilikstnk;
    @Column(name = "IPENGGUNA")
    private Integer ipengguna;
    @Column(name = "IPEMBAWA")
    private Integer ipembawa;
    @Column(name = "VID_PROSPEK_STNK", length = 64)
    private String vidProspekStnk;
    @Column(name = "VB2BSTAT", length = 1)
    private String vb2bstat;
    @Column(name = "VID_AHMDSBSC_MSTDLRCODE", length = 64, nullable = false)
    private String vidAhmdsbscMstdlrcode;
    @ManyToOne(targetEntity = AhmdsbscMstdlrcode.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSBSC_MSTDLRCODE", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    @ManyToOne(targetEntity = Ahmdsh1cMstprospek.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_MSTPROSPEK", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cMstprospek ahmdsh1cMstprospek;
    @ManyToOne(targetEntity = AhmdsmtsMstmotor.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSMTS_MSTMOTOR", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmdsmtsMstmotor ahmdsmtsMstmotor;

    public AhmdsmtsMstmotor getAhmdsmtsMstmotor() {
        return ahmdsmtsMstmotor;
    }

    public void setAhmdsmtsMstmotor(AhmdsmtsMstmotor ahmdsmtsMstmotor) {
        this.ahmdsmtsMstmotor = ahmdsmtsMstmotor;
    }

    public String getVidAhmdsmtsMstmotor() {
        return vidAhmdsmtsMstmotor;
    }

    public void setVidAhmdsmtsMstmotor(String vidAhmdsmtsMstmotor) {
        this.vidAhmdsmtsMstmotor = vidAhmdsmtsMstmotor;
    }

    public String getVidAhmdsh1cMstprospek() {
        return vidAhmdsh1cMstprospek;
    }

    public void setVidAhmdsh1cMstprospek(String vidAhmdsh1cMstprospek) {
        this.vidAhmdsh1cMstprospek = vidAhmdsh1cMstprospek;
    }

    public Integer getIpemesan() {
        return ipemesan;
    }

    public void setIpemesan(Integer ipemesan) {
        this.ipemesan = ipemesan;
    }

    public Integer getIpembeli() {
        return ipembeli;
    }

    public void setIpembeli(Integer ipembeli) {
        this.ipembeli = ipembeli;
    }

    public Integer getIpemilikstnk() {
        return ipemilikstnk;
    }

    public void setIpemilikstnk(Integer ipemilikstnk) {
        this.ipemilikstnk = ipemilikstnk;
    }

    public Integer getIpengguna() {
        return ipengguna;
    }

    public void setIpengguna(Integer ipengguna) {
        this.ipengguna = ipengguna;
    }

    public Integer getIpembawa() {
        return ipembawa;
    }

    public void setIpembawa(Integer ipembawa) {
        this.ipembawa = ipembawa;
    }

    public String getVidProspekStnk() {
        return vidProspekStnk;
    }

    public void setVidProspekStnk(String vidProspekStnk) {
        this.vidProspekStnk = vidProspekStnk;
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

    public Ahmdsh1cMstprospek getAhmdsh1cMstprospek() {
        return ahmdsh1cMstprospek;
    }

    public void setAhmdsh1cMstprospek(Ahmdsh1cMstprospek ahmdsh1cMstprospek) {
        this.ahmdsh1cMstprospek = ahmdsh1cMstprospek;
    }
}
