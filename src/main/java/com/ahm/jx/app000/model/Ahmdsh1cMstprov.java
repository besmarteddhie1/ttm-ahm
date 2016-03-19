/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author george
 */
@Entity
@Table(name = "AHMDSH1C_MSTPROV")
public class Ahmdsh1cMstprov extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VIDPROV",length=6,unique=true,nullable=false)
    private String vidprov;
    
    @Column(name="VPROVDESC",length=100,nullable=false)
    private String vprovdesc;
    
    @Column(name = "VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name = "VIDB2B",length=40)
    private String vidb2b;

    public String getvIdprov() {
        return vidprov;
    }

    public void setvIdprov(String vIdprov) {
        this.vidprov = vIdprov;
    }

    public String getvProvdesc() {
        return vprovdesc;
    }

    public void setvProvdesc(String vProvdesc) {
        this.vprovdesc = vProvdesc;
    }

    public String getVb2bstat() {
        return vb2bstat;
    }

    public void setVb2bstat(String vb2bstat) {
        this.vb2bstat = vb2bstat;
    }

    public String getVidb2b() {
        return vidb2b;
    }

    public void setVidb2b(String vidb2b) {
        this.vidb2b = vidb2b;
    }
}
