/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author achmad.ha
 */
@Entity
@Table(name = "AHMDSBSC_HDRSETTING")
public class AhmdsbscHdrsetting extends BaseAuditVersioning implements Serializable{
    
    @Column(name = "VIDSETTING",length=20,nullable=false,unique=true)
    private String vidsetting;
    
    @Column(name = "VDESCSETTING",length=100,nullable=false)
    private String vdescsetting;
    
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="ahmdsbscHdrsetting")    
    private List<AhmdsbscDtlsetting> listAhmdsbscDtlsettings;

    public String getVidsetting() {
        return vidsetting;
    }

    public void setVidsetting(String vidsetting) {
        this.vidsetting = vidsetting;
    }

    public String getVdescsetting() {
        return vdescsetting;
    }

    public void setVdescsetting(String vdescsetting) {
        this.vdescsetting = vdescsetting;
    }

    public List<AhmdsbscDtlsetting> getListAhmdsbscDtlsettings() {
        return listAhmdsbscDtlsettings;
    }

    public void setListAhmdsbscDtlsettings(List<AhmdsbscDtlsetting> listAhmdsbscDtlsettings) {
        this.listAhmdsbscDtlsettings = listAhmdsbscDtlsettings;
    }    
}
