/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 *
 * @author sigit
 */
@Entity
@Table(name = "AHMJXUAM_MSTROLES")
public class AhmjxuamMstroles extends BaseAuditVersioning implements Serializable {

    @Column(name = "VROLES_ID", length = 20, nullable = false, unique = true)
    private String vrolesId;

    @Column(name = "VROLES_NAME", length = 30)
    private String vrolesName;

    @Column(name = "VROLES_DESC", length = 255)
    private String vrolesDesc;

    @Column(name = "VROLES_STATUS", length = 1)
    private String vrolesStatus;

    @OneToMany(mappedBy = "ahmjxuamMstroles")
    private List<AhmjxuamMstusrrols> listAhmjxuamMstusrrolses;

    @OneToMany(mappedBy = "ahmjxuamMstroles")
    private List<AhmjxuamHdrrlaccess> listAhmjxuamHdrrlaccesses;

    /**
     * @return the vrolesId
     */
    public String getVrolesId() {
        return vrolesId;
    }

    /**
     * @param vrolesId the vrolesId to set
     */
    public void setVrolesId(String vrolesId) {
        this.vrolesId = vrolesId;
    }

    /**
     * @return the vrolesName
     */
    public String getVrolesName() {
        return vrolesName;
    }

    /**
     * @param vrolesName the vrolesName to set
     */
    public void setVrolesName(String vrolesName) {
        this.vrolesName = vrolesName;
    }

    /**
     * @return the vrolesDesc
     */
    public String getVrolesDesc() {
        return vrolesDesc;
    }

    /**
     * @param vrolesDesc the vrolesDesc to set
     */
    public void setVrolesDesc(String vrolesDesc) {
        this.vrolesDesc = vrolesDesc;
    }

    /**
     * @return the vrolesStatus
     */
    public String getVrolesStatus() {
        return vrolesStatus;
    }

    /**
     * @param vrolesStatus the vrolesStatus to set
     */
    public void setVrolesStatus(String vrolesStatus) {
        this.vrolesStatus = vrolesStatus;
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

    /**
     * @return the listAhmjxuamHdrrlaccesses
     */
    public List<AhmjxuamHdrrlaccess> getListAhmjxuamHdrrlaccesses() {
        return listAhmjxuamHdrrlaccesses;
    }

    /**
     * @param listAhmjxuamHdrrlaccesses the listAhmjxuamHdrrlaccesses to set
     */
    public void setListAhmjxuamHdrrlaccesses(List<AhmjxuamHdrrlaccess> listAhmjxuamHdrrlaccesses) {
        this.listAhmjxuamHdrrlaccesses = listAhmjxuamHdrrlaccesses;
    }

}
