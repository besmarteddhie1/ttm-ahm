/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

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
 * @author achmad.ha
 */
@Entity
@Table(name="AHMDSUAM_DTLRLACCESS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMDSUAM_HDRRLACCESS", "VACTALLOWED"}))
public class AhmdsuamDtlrlaccess extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VID_AHMDSUAM_HDRRLACCESS",length=64,nullable=false)
    private String vidAhmdsuamHdrrlaccess;
            
    @ManyToOne(targetEntity=AhmdsuamHdrrlaccess.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSUAM_HDRRLACCESS",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsuamHdrrlaccess ahmdsuamHdrrlaccess;
    
    @Column(name="VACTALLOWED",length=10,nullable=false)
    private String vactallowed;
       
    @Column(name="VFLAGENABLE",length=1,nullable=false)
    private String vflagenable;

    public String getVidAhmdsuamHdrrlaccess() {
        return vidAhmdsuamHdrrlaccess;
    }

    public void setVidAhmdsuamHdrrlaccess(String vidAhmdsuamHdrrlaccess) {
        this.vidAhmdsuamHdrrlaccess = vidAhmdsuamHdrrlaccess;
    }

    public AhmdsuamHdrrlaccess getAhmdsuamHdrrlaccess() {
        return ahmdsuamHdrrlaccess;
    }

    public void setAhmdsuamHdrrlaccess(AhmdsuamHdrrlaccess ahmdsuamHdrrlaccess) {
        this.ahmdsuamHdrrlaccess = ahmdsuamHdrrlaccess;
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
