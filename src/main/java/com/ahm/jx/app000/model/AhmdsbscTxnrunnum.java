/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author achmad.ha
 */
@Entity
@Table(name = "AHMDSBSC_TXNRUNNUM",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VIDRUNNUM", "VRESET"}))
public class AhmdsbscTxnrunnum extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VIDRUNNUM",length = 20,nullable = false)
    private String vidrunnum;
    
    @Column(name="VRESET",length = 20,nullable = false)
    private String vreset;
    
    @Column(name="IVALUE",nullable = false)
    private Integer ivalue;
    
    public String getVidrunnum() {
        return vidrunnum;
    }
    
    public void setVidrunnum(String vidrunnum) {
        this.vidrunnum = vidrunnum;
    }
    
    public String getVreset() {
        return vreset;
    }
    
    public void setVreset(String vreset) {
        this.vreset = vreset;
    }
    
    public Integer getIvalue() {
        return ivalue;
    }
    
    public void setIvalue(Integer ivalue) {
        this.ivalue = ivalue;
    }
}
