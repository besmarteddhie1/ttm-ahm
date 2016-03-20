/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 *
 * @author sigit
 */
@Entity
@Table(name = "AHMJXUAM_HSTSVCUSGS")
public class AhmjxuamHstsvcusgs extends BaseAuditVersioning implements Serializable {

    @Column(name = "VUSERNAME", length = 30, nullable = false, unique = true)
    private String vusername;

    @Column(name = "VURL", length = 128, nullable = true)
    private String vurl;

    @Column(name = "DACCESSTIME")
    private Date daccesstime;

    @Column(name = "VOS", length = 30)
    private String vos;

    @Column(name = "VBROWSER", length = 30)
    private String vbrowser;

    @Column(name = "VIPADDRESS", length = 20)
    private String vipaddress;

    /**
     * @return the vusername
     */
    public String getVusername() {
        return vusername;
    }

    /**
     * @param vusername the vusername to set
     */
    public void setVusername(String vusername) {
        this.vusername = vusername;
    }

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
     * @return the daccesstime
     */
    public Date getDaccesstime() {
        return daccesstime;
    }

    /**
     * @param daccesstime the daccesstime to set
     */
    public void setDaccesstime(Date daccesstime) {
        this.daccesstime = daccesstime;
    }

    /**
     * @return the vos
     */
    public String getVos() {
        return vos;
    }

    /**
     * @param vos the vos to set
     */
    public void setVos(String vos) {
        this.vos = vos;
    }

    /**
     * @return the vbrowser
     */
    public String getVbrowser() {
        return vbrowser;
    }

    /**
     * @param vbrowser the vbrowser to set
     */
    public void setVbrowser(String vbrowser) {
        this.vbrowser = vbrowser;
    }

    /**
     * @return the vipaddress
     */
    public String getVipaddress() {
        return vipaddress;
    }

    /**
     * @param vipaddress the vipaddress to set
     */
    public void setVipaddress(String vipaddress) {
        this.vipaddress = vipaddress;
    }

}
