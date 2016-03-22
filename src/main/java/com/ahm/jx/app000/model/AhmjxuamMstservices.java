/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 *
 * @author sigit
 */
@Entity
@Table(name = "AHMJXUAM_MSTSERVICES")
public class AhmjxuamMstservices extends BaseAuditVersioning implements Serializable {

    @Column(name = "VURL")
    private String vurl;

    @Column(name = "VSVCNAME")
    private String vsvcName;

    @Column(name = "VSVCDESC")
    private String vsvcDesc;

    @Column(name = "VSTAT", length = 1)
    private String vstat;

    @Column(name = "VID_AHMJXUAM_MSTAPPS")
    private String vidAhmjxuamMstapps;

    @ManyToOne(targetEntity = AhmjxuamMstapps.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTAPPS", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstapps ahmjxuamMstapps;

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    public String getVsvcName() {
        return vsvcName;
    }

    public void setVsvcName(String vsvcName) {
        this.vsvcName = vsvcName;
    }

    public String getVsvcDesc() {
        return vsvcDesc;
    }

    public void setVsvcDesc(String vsvcDesc) {
        this.vsvcDesc = vsvcDesc;
    }

    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

    public String getVidAhmjxuamMstapps() {
        return vidAhmjxuamMstapps;
    }

    public void setVidAhmjxuamMstapps(String vidAhmjxuamMstapps) {
        this.vidAhmjxuamMstapps = vidAhmjxuamMstapps;
    }

    public AhmjxuamMstapps getAhmjxuamMstapps() {
        return ahmjxuamMstapps;
    }

    public void setAhmjxuamMstapps(AhmjxuamMstapps ahmjxuamMstapps) {
        this.ahmjxuamMstapps = ahmjxuamMstapps;
    }

}
