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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author sigit
 */
@Entity
@Table(name = "AHMJXUAM_MSTSVCROLS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMJXUAM_MSTSERVICES", "VID_AHMJXUAM_MSTROLES"}))
public class AhmjxuamMstsvcrols extends BaseAuditVersioning implements Serializable {

    @Column(name = "VID_AHMJXUAM_MSTSERVICES", length = 64, nullable = false)
    private String vidAhmjxuamMstservices;

    @Column(name = "VID_AHMJXUAM_MSTROLES", length = 64, nullable = false)
    private String vidAhmjxuamMstroles;

    @ManyToOne(targetEntity = AhmjxuamMstservices.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTSERVICES", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstservices ahmjxuamMstservices;

    @ManyToOne(targetEntity = AhmjxuamMstroles.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTROLES", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstroles ahmjxuamMstroles;

    public String getVidAhmjxuamMstservices() {
        return vidAhmjxuamMstservices;
    }

    public void setVidAhmjxuamMstservices(String vidAhmjxuamMstservices) {
        this.vidAhmjxuamMstservices = vidAhmjxuamMstservices;
    }

    public String getVidAhmjxuamMstroles() {
        return vidAhmjxuamMstroles;
    }

    public void setVidAhmjxuamMstroles(String vidAhmjxuamMstroles) {
        this.vidAhmjxuamMstroles = vidAhmjxuamMstroles;
    }

    public AhmjxuamMstservices getAhmjxuamMstservices() {
        return ahmjxuamMstservices;
    }

    public void setAhmjxuamMstservices(AhmjxuamMstservices ahmjxuamMstservices) {
        this.ahmjxuamMstservices = ahmjxuamMstservices;
    }

    public AhmjxuamMstroles getAhmjxuamMstroles() {
        return ahmjxuamMstroles;
    }

    public void setAhmjxuamMstroles(AhmjxuamMstroles ahmjxuamMstroles) {
        this.ahmjxuamMstroles = ahmjxuamMstroles;
    }

}
