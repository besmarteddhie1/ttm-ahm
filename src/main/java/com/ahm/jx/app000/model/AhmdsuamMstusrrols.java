/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditImpl;
import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import javax.persistence.CascadeType;
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
 * @author achmad
 */
@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Table(name = "AHMDSUAM_MSTUSRROLS", 
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMDSUAM_MSTUSERS", "VID_AHMDSUAM_MSTROLES"}))    
    public class AhmdsuamMstusrrols extends BaseAuditVersioning implements Serializable {
    
    @Column(name="VID_AHMDSUAM_MSTUSERS",length = 64,nullable = false)     
    private String vidAhmdsuamMstusers;

    @Column(name="VID_AHMDSUAM_MSTROLES",length = 64,nullable = false) 
    private String vidAhmdsuamMstroles;

    @Column(name="VSTATUS",length = 1,nullable = false) 
    private String vstatus;
    
    @ManyToOne(targetEntity=AhmdsuamMstusers.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSUAM_MSTUSERS",referencedColumnName = "VID",insertable = false,updatable = false)
    private AhmdsuamMstusers ahmdsuamMstusers;
    
    @ManyToOne(targetEntity=AhmdsuamMstroles.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSUAM_MSTROLES",referencedColumnName = "VID",insertable = false,updatable = false)
    private AhmdsuamMstroles ahmdsuamMstroles;   

    public String getVidAhmdsuamMstusers() {
        return vidAhmdsuamMstusers;
    }

    public void setVidAhmdsuamMstusers(String vidAhmdsuamMstusers) {
        this.vidAhmdsuamMstusers = vidAhmdsuamMstusers;
    }

    public String getVidAhmdsuamMstroles() {
        return vidAhmdsuamMstroles;
    }

    public void setVidAhmdsuamMstroles(String vidAhmdsuamMstroles) {
        this.vidAhmdsuamMstroles = vidAhmdsuamMstroles;
    }

    public AhmdsuamMstusers getAhmdsuamMstusers() {
        return ahmdsuamMstusers;
    }

    public void setAhmdsuamMstusers(AhmdsuamMstusers ahmdsuamMstusers) {
        this.ahmdsuamMstusers = ahmdsuamMstusers;
    }

    public AhmdsuamMstroles getAhmdsuamMstroles() {
        return ahmdsuamMstroles;
    }

    public void setAhmdsuamMstroles(AhmdsuamMstroles ahmdsuamMstroles) {
        this.ahmdsuamMstroles = ahmdsuamMstroles;
    }

    public String getVstatus() {
        return vstatus;
    }

    public void setVstatus(String vstatus) {
        this.vstatus = vstatus;
    }
}
