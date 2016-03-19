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

/**
 *
 * @author achmad.ha
 */
@Entity
@Table(name = "AHMDSBSC_DTLSETTING",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMDSBSC_HDRSETTING", "VITEMCODE","VDLRCODE"}))
public class AhmdsbscDtlsetting extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VID_AHMDSBSC_HDRSETTING",length = 64,nullable = false)     
    private String vidAhmdsbscHdrsetting;
        
    @Column(name="VITEMCODE",length = 20,nullable=false)
    private String vitemcode;
    
    @Column(name="VITEMNAME",length = 50,nullable=false)
    private String vitemname;
    
    @Column(name="VITEMDESC",length = 100)
    private String vitemdesc;
    
    @Column(name="VSTATUS",length=1,nullable=false)
    private String vstatus;
    
    @Column(name="VDLRCODE",length=6,nullable=false)
    private String vdlrcode;
    
    @ManyToOne(targetEntity=AhmdsbscHdrsetting.class,cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_HDRSETTING",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscHdrsetting ahmdsbscHdrsetting;

    public String getVidAhmdsbscHdrsetting() {
        return vidAhmdsbscHdrsetting;
    }

    public void setVidAhmdsbscHdrsetting(String vidAhmdsbscHdrsetting) {
        this.vidAhmdsbscHdrsetting = vidAhmdsbscHdrsetting;
    }

    public String getVitemcode() {
        return vitemcode;
    }

    public void setVitemcode(String vitemcode) {
        this.vitemcode = vitemcode;
    }

    public String getVitemname() {
        return vitemname;
    }

    public void setVitemname(String vitemname) {
        this.vitemname = vitemname;
    }

    public String getVitemdesc() {
        return vitemdesc;
    }

    public void setVitemdesc(String vitemdesc) {
        this.vitemdesc = vitemdesc;
    }

    public String getVstatus() {
        return vstatus;
    }

    public void setVstatus(String vstatus) {
        this.vstatus = vstatus;
    }

    public String getVdlrcode() {
        return vdlrcode;
    }

    public void setVdlrcode(String vdlrcode) {
        this.vdlrcode = vdlrcode;
    }

    public AhmdsbscHdrsetting getAhmdsbscHdrsetting() {
        return ahmdsbscHdrsetting;
    }

    public void setAhmdsbscHdrsetting(AhmdsbscHdrsetting ahmdsbscHdrsetting) {
        this.ahmdsbscHdrsetting = ahmdsbscHdrsetting;
    }
}
