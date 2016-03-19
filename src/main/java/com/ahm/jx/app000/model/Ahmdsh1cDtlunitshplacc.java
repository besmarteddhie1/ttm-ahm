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

/**
 *
 * @author hendra.fs
 */
@Entity
@Table(name = "AHMDSH1C_DTLUNITSHPLACC")
public class Ahmdsh1cDtlunitshplacc extends BaseAuditVersioning implements Serializable {
    @ManyToOne(targetEntity=Ahmdsh1cDtlunitshpl.class, fetch=FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_DTLUNITSHPL", referencedColumnName="VID")
    private Ahmdsh1cDtlunitshpl ahmdsh1cDtlunitshpl;
    
    @Column(name="NQTYSHIP")
    private Integer nqtyship;
    
    @Column(name="VID_AHMDSH1C_MSTACCESORIES", length=64)
    private String vidAhmdsh1cMstaccessories;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstaccessories.class, fetch=FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTACCESORIES", referencedColumnName="VID", insertable=false, updatable=false)
    private Ahmdsh1cMstaccessories ahmdsh1cMstaccessories;

    public Integer getNqtyship() {
        return nqtyship;
    }

    public void setNqtyship(Integer nqtyship) {
        this.nqtyship = nqtyship;
    }

    public String getVidAhmdsh1cMstaccessories() {
        return vidAhmdsh1cMstaccessories;
    }

    public void setVidAhmdsh1cMstaccessories(String vidAhmdsh1cMstaccessories) {
        this.vidAhmdsh1cMstaccessories = vidAhmdsh1cMstaccessories;
    }

    public Ahmdsh1cDtlunitshpl getAhmdsh1cDtlunitshpl() {
        return ahmdsh1cDtlunitshpl;
    }

    public void setAhmdsh1cDtlunitshpl(Ahmdsh1cDtlunitshpl ahmdsh1cDtlunitshpl) {
        this.ahmdsh1cDtlunitshpl = ahmdsh1cDtlunitshpl;
    }

    public Ahmdsh1cMstaccessories getAhmdsh1cMstaccessories() {
        return ahmdsh1cMstaccessories;
    }

    public void setAhmdsh1cMstaccessories(Ahmdsh1cMstaccessories ahmdsh1cMstaccessories) {
        this.ahmdsh1cMstaccessories = ahmdsh1cMstaccessories;
    }
}
