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

    @Column(name = "VTOKEN")
    private String vtoken;

    @Column(name = "DTOKENEXP")
    private Date dtokenexp;

    @Column(name = "VIPADDRESS", length = 20)
    private String vipaddress;

    @Column(name = "VSTAT", length = 1)
    private String vstat;

//    @Column(name = "VID_AHMDSBSC_MSTLDRDODE")
//    private String vidAhmdsbscMstldrdode;
    @Column(name = "VID_AHMJXUAM_MSTPARTNER")
    private String vidAhmjxuamMstpartner;

    @ManyToOne(targetEntity = AhmjxuamMstpartner.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTPARTNER", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstpartner ahmjxuamMstpartner;

    @OneToMany(mappedBy = "ahmjxuamMstusers")
    private List<AhmjxuamMstusrrols> listAhmjxuamMstusrrolses;

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
     * @return the vpassword
     */
    public String getVpassword() {
        return vpassword;
    }

    /**
     * @param vpassword the vpassword to set
     */
    public void setVpassword(String vpassword) {
        this.vpassword = vpassword;
    }

    /**
     * @return the vtoken
     */
    public String getVtoken() {
        return vtoken;
    }

    /**
     * @param vtoken the vtoken to set
     */
    public void setVtoken(String vtoken) {
        this.vtoken = vtoken;
    }

    /**
     * @return the dtokenexp
     */
    public Date getDtokenexp() {
        return dtokenexp;
    }

    /**
     * @param dtokenexp the dtokenexp to set
     */
    public void setDtokenexp(Date dtokenexp) {
        this.dtokenexp = dtokenexp;
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

    /**
     * @return the vstat
     */
    public String getVstat() {
        return vstat;
    }

    /**
     * @param vstat the vstat to set
     */
    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

//    /**
//     * @return the vidAhmdsbscMstldrdode
//     */
//    public String getVidAhmdsbscMstldrdode() {
//        return vidAhmdsbscMstldrdode;
//    }
//    /**
//     * @param vidAhmdsbscMstldrdode the vidAhmdsbscMstldrdode to set
//     */
//    public void setVidAhmdsbscMstldrdode(String vidAhmdsbscMstldrdode) {
//        this.vidAhmdsbscMstldrdode = vidAhmdsbscMstldrdode;
//    }
    /**
     * @return the vidAhmjxuamMstpartner
     */
    public String getVidAhmjxuamMstpartner() {
        return vidAhmjxuamMstpartner;
    }

    /**
     * @param vidAhmjxuamMstpartner the vidAhmjxuamMstpartner to set
     */
    public void setVidAhmjxuamMstpartner(String vidAhmjxuamMstpartner) {
        this.vidAhmjxuamMstpartner = vidAhmjxuamMstpartner;
    }

    /**
     * @return the ahmjxuamMstpartner
     */
    public AhmjxuamMstpartner getAhmjxuamMstpartner() {
        return ahmjxuamMstpartner;
    }

    /**
     * @param ahmjxuamMstpartner the ahmjxuamMstpartner to set
     */
    public void setAhmjxuamMstpartner(AhmjxuamMstpartner ahmjxuamMstpartner) {
        this.ahmjxuamMstpartner = ahmjxuamMstpartner;
    }

    /**
     * @return the listAhmjxuamMstusrrolses
     */
    public List<AhmjxuamMstusrrols> getListAhmjxuamMstusrrolses() {
        return listAhmjxuamMstusrrolses;
    }

    /**
     * @param listAhmjxuamMstusrrolses the listAhmjxuamMstusrrolses to set
     */
    public void setListAhmjxuamMstusrrolses(List<AhmjxuamMstusrrols> listAhmjxuamMstusrrolses) {
        this.listAhmjxuamMstusrrolses = listAhmjxuamMstusrrolses;
    }

}
