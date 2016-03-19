/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author hendra.fs
 */
@Entity
@Table(name = "AHMDSH1C_HDRUNITSHPL", uniqueConstraints = @UniqueConstraint(columnNames = 
        {"VIDSHPLSNUM", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cHdrunitshpl extends BaseAuditVersioning implements Serializable {

    @Column(name="VIDSHPLSNUM", length=20, nullable=false)
    private String vidshplsnum;
    @Column(name="VDRIVER", length=20, nullable=false)
    private String vdriver;
    @Column(name="VNOPOLEXP", length=10, nullable=false)
    private String vnopolexp;
    @Column(name="VTYPESHPL", length=1, nullable=false)
    private String vtypeshpl;
    @Column(name="DSHPLSDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dshplsdate;
    @Column(name="VID_AHMDSH1C_MSTIDWHS", length=64)
    private String vidAhmdsh1cmstidwhs;
    @Column(name="VID_AHMDSBSC_MSTDLRCODE", nullable=false, length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstidwhs.class, fetch=FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTIDWHS", referencedColumnName="VID", insertable = false, updatable = false)
    private Ahmdsh1cMstidwhs ahmdsh1cMstidwhs;
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class, fetch=FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE", referencedColumnName="VID", insertable=false, updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ahmdsh1cHdrunitshpl")    
    private List<Ahmdsh1cDtlunitshpl> listAhmdsh1cDtlunitshpl;

    public String getVidshplsnum() {
        return vidshplsnum;
    }

    public void setVidshplsnum(String vidshplsnum) {
        this.vidshplsnum = vidshplsnum;
    }

    public String getVdriver() {
        return vdriver;
    }

    public void setVdriver(String vdriver) {
        this.vdriver = vdriver;
    }

    public String getVnopolexp() {
        return vnopolexp;
    }

    public void setVnopolexp(String vnopolexp) {
        this.vnopolexp = vnopolexp;
    }

    public String getVtypeshpl() {
        return vtypeshpl;
    }

    public void setVtypeshpl(String vtypeshpl) {
        this.vtypeshpl = vtypeshpl;
    }

    public Date getDshplsdate() {
        return dshplsdate;
    }

    public void setDshplsdate(Date dshplsdate) {
        this.dshplsdate = dshplsdate;
    }

    public String getVidAhmdsh1cmstidwhs() {
        return vidAhmdsh1cmstidwhs;
    }

    public void setVidAhmdsh1cmstidwhs(String vidAhmdsh1cmstidwhs) {
        this.vidAhmdsh1cmstidwhs = vidAhmdsh1cmstidwhs;
    }

    public String getVidAhmdsbscMstdlrcode() {
        return vidAhmdsbscMstdlrcode;
    }

    public void setVidAhmdsbscMstdlrcode(String vidAhmdsbscMstdlrcode) {
        this.vidAhmdsbscMstdlrcode = vidAhmdsbscMstdlrcode;
    }

    public Ahmdsh1cMstidwhs getAhmdsh1cMstidwhs() {
        return ahmdsh1cMstidwhs;
    }

    public void setAhmdsh1cMstidwhs(Ahmdsh1cMstidwhs ahmdsh1cMstidwhs) {
        this.ahmdsh1cMstidwhs = ahmdsh1cMstidwhs;
    }

    public AhmdsbscMstdlrcode getAhmdsbscMstdlrcode() {
        return ahmdsbscMstdlrcode;
    }

    public void setAhmdsbscMstdlrcode(AhmdsbscMstdlrcode ahmdsbscMstdlrcode) {
        this.ahmdsbscMstdlrcode = ahmdsbscMstdlrcode;
    }

    public List<Ahmdsh1cDtlunitshpl> getListAhmdsh1cDtlunitshpl() {
        return listAhmdsh1cDtlunitshpl;
    }

    public void setListAhmdsh1cDtlunitshpl(List<Ahmdsh1cDtlunitshpl> listAhmdsh1cDtlunitshpl) {
        this.listAhmdsh1cDtlunitshpl = listAhmdsh1cDtlunitshpl;
    }
}
