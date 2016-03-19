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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author george
 */
@Entity
@Table(name = "AHMDSH1C_HDRJOSRVCEA")
public class Ahmdsh1cHdrjosrvcea extends BaseAuditVersioning implements Serializable {

    @Column(name="VIDJOBNUM")
    private String vidjobnum;
    @Column(name="VID_AHMDSH1C_MSTPARTNER")
    private String vidAhmdsh1cMstpartner;
    @Column(name="DJOBDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date djobdate;
    @Column(name="VID_AHMDSBSC_MSTDLRCODE")
    private String vidAhmdsbscMstdlrcode;
    @Column(name="VSTAT")
    private String vstat;
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="ahmdsh1cHdrjosrvcea")    
    private List<Ahmdsh1cDtljosrvcea> listAhmdsh1cDtljosrvcea;

    public List<Ahmdsh1cDtljosrvcea> getListAhmdsh1cDtljosrvcea() {
        return listAhmdsh1cDtljosrvcea;
    }

    public void setListAhmdsh1cDtljosrvcea(List<Ahmdsh1cDtljosrvcea> listAhmdsh1cDtljosrvcea) {
        this.listAhmdsh1cDtljosrvcea = listAhmdsh1cDtljosrvcea;
    }

    public String getVidjobnum() {
        return vidjobnum;
    }

    public void setVidjobnum(String vidjobnum) {
        this.vidjobnum = vidjobnum;
    }

    public String getVidAhmdsh1cMstpartner() {
        return vidAhmdsh1cMstpartner;
    }

    public void setVidAhmdsh1cMstpartner(String vidAhmdsh1cMstpartner) {
        this.vidAhmdsh1cMstpartner = vidAhmdsh1cMstpartner;
    }

    public Date getDjobdate() {
        return djobdate;
    }

    public void setDjobdate(Date djobdate) {
        this.djobdate = djobdate;
    }

    public String getVidAhmdsbscMstdlrcode() {
        return vidAhmdsbscMstdlrcode;
    }

    public void setVidAhmdsbscMstdlrcode(String vidAhmdsbscMstdlrcode) {
        this.vidAhmdsbscMstdlrcode = vidAhmdsbscMstdlrcode;
    }

    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

}
