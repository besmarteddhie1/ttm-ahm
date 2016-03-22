/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 *
 * @author sigit
 */
@Entity
@Table(name = "AHMJXUAM_MSTUSERS")
public class AhmjxuamMstusers extends BaseAuditVersioning implements Serializable {

    @Column(name = "VUSERNAME", length = 30, nullable = false, unique = true)
    private String vusername;

    @Column(name = "VPASSWORD")
    private String vpassword;

    @Column(name = "VFULLNAME")
    private String vfullname;

    @Column(name = "VEMAIL")
    private String vemail;

    @Column(name = "VPHONE", length = 20)
    private String vphone;

    @Column(name = "VADDRESS")
    private String vaddress;

    @Column(name = "DBIRTH")
    private Date dbirth;

    @Column(name = "VTOKEN")
    private String vtoken;

    @Column(name = "DTOKENEXP")
    private Date dtokenexp;

    @Column(name = "VIPADDRESS", length = 20)
    private String vipaddress;

    @Column(name = "VSTAT", length = 1)
    private String vstat;

    @Column(name = "VID_AHMJXUAM_MSTPARTNER")
    private String vidAhmjxuamMstpartner;

    @ManyToOne(targetEntity = AhmjxuamMstpartner.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTPARTNER", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstpartner ahmjxuamMstpartner;

    @OneToMany(mappedBy = "ahmjxuamMstusers")
    private List<AhmjxuamMstusrrols> listAhmjxuamMstusrrolses;

    public String getVusername() {
        return vusername;
    }

    public void setVusername(String vusername) {
        this.vusername = vusername;
    }

    public String getVpassword() {
        return vpassword;
    }

    public void setVpassword(String vpassword) {
        this.vpassword = vpassword;
    }

    public String getVfullname() {
        return vfullname;
    }

    public void setVfullname(String vfullname) {
        this.vfullname = vfullname;
    }

    public String getVemail() {
        return vemail;
    }

    public void setVemail(String vemail) {
        this.vemail = vemail;
    }

    public String getVphone() {
        return vphone;
    }

    public void setVphone(String vphone) {
        this.vphone = vphone;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public Date getDbirth() {
        return dbirth;
    }

    public void setDbirth(Date dbirth) {
        this.dbirth = dbirth;
    }

    public String getVtoken() {
        return vtoken;
    }

    public void setVtoken(String vtoken) {
        this.vtoken = vtoken;
    }

    public Date getDtokenexp() {
        return dtokenexp;
    }

    public void setDtokenexp(Date dtokenexp) {
        this.dtokenexp = dtokenexp;
    }

    public String getVipaddress() {
        return vipaddress;
    }

    public void setVipaddress(String vipaddress) {
        this.vipaddress = vipaddress;
    }

    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

    public String getVidAhmjxuamMstpartner() {
        return vidAhmjxuamMstpartner;
    }

    public void setVidAhmjxuamMstpartner(String vidAhmjxuamMstpartner) {
        this.vidAhmjxuamMstpartner = vidAhmjxuamMstpartner;
    }

    public AhmjxuamMstpartner getAhmjxuamMstpartner() {
        return ahmjxuamMstpartner;
    }

    public void setAhmjxuamMstpartner(AhmjxuamMstpartner ahmjxuamMstpartner) {
        this.ahmjxuamMstpartner = ahmjxuamMstpartner;
    }

    public List<AhmjxuamMstusrrols> getListAhmjxuamMstusrrolses() {
        return listAhmjxuamMstusrrolses;
    }

    public void setListAhmjxuamMstusrrolses(List<AhmjxuamMstusrrols> listAhmjxuamMstusrrolses) {
        this.listAhmjxuamMstusrrolses = listAhmjxuamMstusrrolses;
    }

}
