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
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 *
 * @author sigit
 */
@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Table(name = "AHMJXUAM_MSTUSRROLS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMJXUAM_MSTUSERS", "VID_AHMJXUAM_MSTROLES"}))
public class AhmjxuamMstusrrols extends BaseAuditVersioning implements Serializable {

    @Column(name = "VID_AHMJXUAM_MSTUSERS", length = 64, nullable = false)
    private String vidAhmjxuamMstusers;

    @Column(name = "VID_AHMJXUAM_MSTROLES", length = 64, nullable = false)
    private String vidAhmjxuamMstroles;

    @Column(name = "VSTATUS", length = 1, nullable = false)
    private String vstatus;

    @ManyToOne(targetEntity = AhmjxuamMstusers.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTUSERS", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstusers ahmjxuamMstusers;

    @ManyToOne(targetEntity = AhmjxuamMstroles.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTROLES", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstroles ahmjxuamMstroles;

    /**
     * @return the vidAhmjxuamMstusers
     */
    public String getVidAhmjxuamMstusers() {
        return vidAhmjxuamMstusers;
    }

    /**
     * @param vidAhmjxuamMstusers the vidAhmjxuamMstusers to set
     */
    public void setVidAhmjxuamMstusers(String vidAhmjxuamMstusers) {
        this.vidAhmjxuamMstusers = vidAhmjxuamMstusers;
    }

    /**
     * @return the vidAhmjxuamMstroles
     */
    public String getVidAhmjxuamMstroles() {
        return vidAhmjxuamMstroles;
    }

    /**
     * @param vidAhmjxuamMstroles the vidAhmjxuamMstroles to set
     */
    public void setVidAhmjxuamMstroles(String vidAhmjxuamMstroles) {
        this.vidAhmjxuamMstroles = vidAhmjxuamMstroles;
    }

    /**
     * @return the vstatus
     */
    public String getVstatus() {
        return vstatus;
    }

    /**
     * @param vstatus the vstatus to set
     */
    public void setVstatus(String vstatus) {
        this.vstatus = vstatus;
    }

    /**
     * @return the ahmjxuamMstusers
     */
    public AhmjxuamMstusers getAhmjxuamMstusers() {
        return ahmjxuamMstusers;
    }

    /**
     * @param ahmjxuamMstusers the ahmjxuamMstusers to set
     */
    public void setAhmjxuamMstusers(AhmjxuamMstusers ahmjxuamMstusers) {
        this.ahmjxuamMstusers = ahmjxuamMstusers;
    }

    /**
     * @return the ahmjxuamMstroles
     */
    public AhmjxuamMstroles getAhmjxuamMstroles() {
        return ahmjxuamMstroles;
    }

    /**
     * @param ahmjxuamMstroles the ahmjxuamMstroles to set
     */
    public void setAhmjxuamMstroles(AhmjxuamMstroles ahmjxuamMstroles) {
        this.ahmjxuamMstroles = ahmjxuamMstroles;
    }

}
