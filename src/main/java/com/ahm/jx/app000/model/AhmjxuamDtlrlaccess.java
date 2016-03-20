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
@Table(name = "AHMJXUAM_DTLRLACCESS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMJXUAM_HDRRLACCESS", "VACTALLOWED"}))
public class AhmjxuamDtlrlaccess extends BaseAuditVersioning implements Serializable {

    @Column(name = "VID_AHMJXUAM_HDRRLACCESS", length = 64, nullable = false)
    private String vidAhmjxuamHdrrlaccess;

    @Column(name = "VACTALLOWED", length = 10, nullable = false)
    private String vactallowed;

    @Column(name = "VFLAGENABLE", length = 1, nullable = false)
    private String vflagenable;

    @ManyToOne(targetEntity = AhmjxuamHdrrlaccess.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_HDRRLACCESS", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamHdrrlaccess ahmjxuamHdrrlaccess;

    public String getVidAhmjxuamHdrrlaccess() {
        return vidAhmjxuamHdrrlaccess;
    }

    public void setVidAhmjxuamHdrrlaccess(String vidAhmjxuamHdrrlaccess) {
        this.vidAhmjxuamHdrrlaccess = vidAhmjxuamHdrrlaccess;
    }

    public AhmjxuamHdrrlaccess getAhmjxuamHdrrlaccess() {
        return ahmjxuamHdrrlaccess;
    }

    public void setAhmjxuamHdrrlaccess(AhmjxuamHdrrlaccess ahmjxuamHdrrlaccess) {
        this.ahmjxuamHdrrlaccess = ahmjxuamHdrrlaccess;
    }

    public String getVactallowed() {
        return vactallowed;
    }

    public void setVactallowed(String vactallowed) {
        this.vactallowed = vactallowed;
    }

    public String getVflagenable() {
        return vflagenable;
    }

    public void setVflagenable(String vflagenable) {
        this.vflagenable = vflagenable;
    }
}
