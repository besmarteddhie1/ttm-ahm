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
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Table(name = "AHMJXUAM_MSTSERVICES")
public class AhmjxuamMstservices extends BaseAuditVersioning implements Serializable {

    @Column(name = "VURL")
    private String vurl;

    @Column(name = "VSVCNAME")
    private String vsvcname;

    @Column(name = "VSVCDESC")
    private String vsvcdesc;

    @Column(name = "VSTAT", length = 1)
    private String vstat;

    @Column(name = "VID_AHMJXUAM_MSTAPPS")
    private String vidAhmjxuamMstapps;

    @ManyToOne(targetEntity = AhmjxuamMstapps.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTAPPS", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstapps ahmjxuamMstapps;

    /**
     * @return the vurl
     */
    public String getVurl() {
        return vurl;
    }

    /**
     * @param vurl the vurl to set
     */
    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    /**
     * @return the vsvcname
     */
    public String getVsvcname() {
        return vsvcname;
    }

    /**
     * @param vsvcname the vsvcname to set
     */
    public void setVsvcname(String vsvcname) {
        this.vsvcname = vsvcname;
    }

    /**
     * @return the vsvcdesc
     */
    public String getVsvcdesc() {
        return vsvcdesc;
    }

    /**
     * @param vsvcdesc the vsvcdesc to set
     */
    public void setVsvcdesc(String vsvcdesc) {
        this.vsvcdesc = vsvcdesc;
    }

    /**
     * @return the vidAhmjxuamMstapps
     */
    public String getVidAhmjxuamMstapps() {
        return vidAhmjxuamMstapps;
    }

    /**
     * @param vidAhmjxuamMstapps the vidAhmjxuamMstapps to set
     */
    public void setVidAhmjxuamMstapps(String vidAhmjxuamMstapps) {
        this.vidAhmjxuamMstapps = vidAhmjxuamMstapps;
    }

    /**
     * @return the ahmjxuamMstapps
     */
    public AhmjxuamMstapps getAhmjxuamMstapps() {
        return ahmjxuamMstapps;
    }

    /**
     * @param ahmjxuamMstapps the ahmjxuamMstapps to set
     */
    public void setAhmjxuamMstapps(AhmjxuamMstapps ahmjxuamMstapps) {
        this.ahmjxuamMstapps = ahmjxuamMstapps;
    }

}
