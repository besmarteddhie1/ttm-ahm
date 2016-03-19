/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditImpl;
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
 * @author achmad
 */
@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Table(name="AHMDSUAM_HDRRLACCESS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMDSUAM_MSTMENUS", "VID_AHMDSUAM_MSTROLES"}))
public class AhmdsuamHdrrlaccess extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VID_AHMDSUAM_MSTROLES",length = 64,nullable = false)     
    private String vidAhmdsuamMstroles;
    
    @Column(name="VID_AHMDSUAM_MSTMENUS",length = 64,nullable = false)     
    private String vidAhmdsuamMstmenus;    
    
    @ManyToOne(targetEntity=AhmdsuamMstroles.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSUAM_MSTROLES",referencedColumnName = "VID",insertable = false,updatable = false)
    private AhmdsuamMstroles ahmdsuamMstroles;
    
    @ManyToOne(targetEntity=AhmdsuamMstmenus.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSUAM_MSTMENUS",referencedColumnName = "VID",insertable = false,updatable = false)
    private AhmdsuamMstmenus ahmdsuamMstmenus;
    
    @OneToMany(mappedBy="ahmdsuamHdrrlaccess",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    private List<AhmdsuamDtlrlaccess> listAhmdsuamDtlrlaccess;

    public String getVidAhmdsuamMstroles() {
        return vidAhmdsuamMstroles;
    }

    public void setVidAhmdsuamMstroles(String vidAhmdsuamMstroles) {
        this.vidAhmdsuamMstroles = vidAhmdsuamMstroles;
    }

    public String getVidAhmdsuamMstmenus() {
        return vidAhmdsuamMstmenus;
    }

    public void setVidAhmdsuamMstmenus(String vidAhmdsuamMstmenus) {
        this.vidAhmdsuamMstmenus = vidAhmdsuamMstmenus;
    }

    public AhmdsuamMstroles getAhmdsuamMstroles() {
        return ahmdsuamMstroles;
    }

    public void setAhmdsuamMstroles(AhmdsuamMstroles ahmdsuamMstroles) {
        this.ahmdsuamMstroles = ahmdsuamMstroles;
    }

    public AhmdsuamMstmenus getAhmdsuamMstmenus() {
        return ahmdsuamMstmenus;
    }

    public void setAhmdsuamMstmenus(AhmdsuamMstmenus ahmdsuamMstmenus) {
        this.ahmdsuamMstmenus = ahmdsuamMstmenus;
    }

    public List<AhmdsuamDtlrlaccess> getListAhmdsuamDtlrlaccess() {
        return listAhmdsuamDtlrlaccess;
    }

    public void setListAhmdsuamDtlrlaccess(List<AhmdsuamDtlrlaccess> listAhmdsuamDtlrlaccess) {
        this.listAhmdsuamDtlrlaccess = listAhmdsuamDtlrlaccess;
    }
}