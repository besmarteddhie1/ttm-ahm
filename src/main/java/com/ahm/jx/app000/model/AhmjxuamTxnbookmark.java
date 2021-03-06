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
@Table(name = "AHMJXUAM_TXNBOOKMARK",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMJXUAM_MSTUSERS", "VID_AHMJXUAM_MSTMENUS"}))
public class AhmjxuamTxnbookmark extends BaseAuditVersioning implements Serializable {

    @Column(name = "VID_AHMJXUAM_MSTUSERS", length = 64, nullable = false)
    private String vidAhmjxuamMstusers;

    @ManyToOne(targetEntity = AhmjxuamMstusers.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTUSERS", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstusers ahmjxuamMstusers;

    @Column(name = "VID_AHMJXUAM_MSTMENUS", length = 64, nullable = false)
    private String vidAhmjxuamMstmenus;

    @ManyToOne(targetEntity = AhmjxuamMstmenus.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTMENUS", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstmenus ahmjxuamMstmenus;

    public String getVidAhmjxuamMstusers() {
        return vidAhmjxuamMstusers;
    }

    public void setVidAhmjxuamMstusers(String vidAhmjxuamMstusers) {
        this.vidAhmjxuamMstusers = vidAhmjxuamMstusers;
    }

    public AhmjxuamMstusers getAhmjxuamMstusers() {
        return ahmjxuamMstusers;
    }

    public void setAhmjxuamMstusers(AhmjxuamMstusers ahmjxuamMstusers) {
        this.ahmjxuamMstusers = ahmjxuamMstusers;
    }

    public String getVidAhmjxuamMstmenus() {
        return vidAhmjxuamMstmenus;
    }

    public void setVidAhmjxuamMstmenus(String vidAhmjxuamMstmenus) {
        this.vidAhmjxuamMstmenus = vidAhmjxuamMstmenus;
    }

    public AhmjxuamMstmenus getAhmjxuamMstmenus() {
        return ahmjxuamMstmenus;
    }

    public void setAhmjxuamMstmenus(AhmjxuamMstmenus ahmjxuamMstmenus) {
        this.ahmjxuamMstmenus = ahmjxuamMstmenus;
    }

}
