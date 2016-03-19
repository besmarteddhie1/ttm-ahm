/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "AHMJXUAM_HDRRLACCESS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMJXUAM_MSTMENUS", "VID_AHMJXUAM_MSTROLES"}))
public class AhmjxuamHdrrlaccess extends BaseAuditVersioning implements Serializable {

    @Column(name = "VID_AHMJXUAM_MSTROLES", length = 64, nullable = false)
    private String vidAhmjxuamMstroles;

    @Column(name = "VID_AHMJXUAM_MSTMENUS", length = 64, nullable = false)
    private String vidAhmjxuamMstmenus;

    @ManyToOne(targetEntity = AhmjxuamMstroles.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTROLES", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstroles ahmjxuamMstroles;

    @ManyToOne(targetEntity = AhmjxuamMstmenus.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTMENUS", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstmenus ahmjxuamMstmenus;

    @OneToMany(mappedBy = "ahmjxuamHdrrlaccess", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AhmjxuamDtlrlaccess> listAhmjxuamDtlrlaccess;

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
     * @return the vidAhmjxuamMstmenus
     */
    public String getVidAhmjxuamMstmenus() {
        return vidAhmjxuamMstmenus;
    }

    /**
     * @param vidAhmjxuamMstmenus the vidAhmjxuamMstmenus to set
     */
    public void setVidAhmjxuamMstmenus(String vidAhmjxuamMstmenus) {
        this.vidAhmjxuamMstmenus = vidAhmjxuamMstmenus;
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

    /**
     * @return the ahmjxuamMstmenus
     */
    public AhmjxuamMstmenus getAhmjxuamMstmenus() {
        return ahmjxuamMstmenus;
    }

    /**
     * @param ahmjxuamMstmenus the ahmjxuamMstmenus to set
     */
    public void setAhmjxuamMstmenus(AhmjxuamMstmenus ahmjxuamMstmenus) {
        this.ahmjxuamMstmenus = ahmjxuamMstmenus;
    }

}
