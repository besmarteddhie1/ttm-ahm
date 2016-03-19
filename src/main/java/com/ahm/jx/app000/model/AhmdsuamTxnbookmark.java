/*
 * To change this template, choose Tools | Templates
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
 * @author achmad.ha
 */
@Entity
@Table(name = "AHMDSUAM_TXNBOOKMARK", 
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMDSUAM_MSTUSERS", "VID_AHMDSUAM_MSTMENUS"}))
public class AhmdsuamTxnbookmark extends BaseAuditVersioning implements Serializable{
        
    @Column(name="VID_AHMDSUAM_MSTUSERS",length = 64,nullable = false)     
    private String vidAhmdsuamMstusers;
    
    @ManyToOne(targetEntity=AhmdsuamMstusers.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSUAM_MSTUSERS",referencedColumnName = "VID",insertable = false,updatable = false)
    private AhmdsuamMstusers ahmdsuamMstusers;
    
    @Column(name="VID_AHMDSUAM_MSTMENUS",length = 64,nullable = false)     
    private String vidAhmdsuamMstmenus;
    
    @ManyToOne(targetEntity=AhmdsuamMstmenus.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSUAM_MSTMENUS",referencedColumnName = "VID",insertable = false,updatable = false)
    private AhmdsuamMstmenus ahmdsuamMstmenus;

    public String getVidAhmdsuamMstusers() {
        return vidAhmdsuamMstusers;
    }

    public void setVidAhmdsuamMstusers(String vidAhmdsuamMstusers) {
        this.vidAhmdsuamMstusers = vidAhmdsuamMstusers;
    }

    public AhmdsuamMstusers getAhmdsuamMstusers() {
        return ahmdsuamMstusers;
    }

    public void setAhmdsuamMstusers(AhmdsuamMstusers ahmdsuamMstusers) {
        this.ahmdsuamMstusers = ahmdsuamMstusers;
    }

    public String getVidAhmdsuamMstmenus() {
        return vidAhmdsuamMstmenus;
    }

    public void setVidAhmdsuamMstmenus(String vidAhmdsuamMstmenus) {
        this.vidAhmdsuamMstmenus = vidAhmdsuamMstmenus;
    }

    public AhmdsuamMstmenus getAhmdsuamMstmenus() {
        return ahmdsuamMstmenus;
    }

    public void setAhmdsuamMstmenus(AhmdsuamMstmenus ahmdsuamMstmenus) {
        this.ahmdsuamMstmenus = ahmdsuamMstmenus;
    }
}
