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
@Table(name = "AHMJXUAM_HSTAPPUSGS")
public class AhmjxuamHstappusgs extends BaseAuditVersioning implements Serializable {

    @Column(name = "VUSERNAME", length = 30, nullable = false)
    private String vusername;

    @Column(name = "VAPP", length = 128, nullable = true)
    private String vapp;

    @Column(name = "DACCESSTIME")
    private Date daccessTime;

    @Column(name = "VOS", length = 30)
    private String vos;

    @Column(name = "VBROWSER", length = 30)
    private String vbrowser;

    @Column(name = "VIPADDRESS", length = 20)
    private String vipAddress;

    public String getVusername() {
        return vusername;
    }

    public void setVusername(String vusername) {
        this.vusername = vusername;
    }

    public String getVapp() {
        return vapp;
    }

    public void setVapp(String vapp) {
        this.vapp = vapp;
    }

    public Date getDaccessTime() {
        return daccessTime;
    }

    public void setDaccessTime(Date daccessTime) {
        this.daccessTime = daccessTime;
    }

    public String getVos() {
        return vos;
    }

    public void setVos(String vos) {
        this.vos = vos;
    }

    public String getVbrowser() {
        return vbrowser;
    }

    public void setVbrowser(String vbrowser) {
        this.vbrowser = vbrowser;
    }

    public String getVipAddress() {
        return vipAddress;
    }

    public void setVipAddress(String vipAddress) {
        this.vipAddress = vipAddress;
    }

}
