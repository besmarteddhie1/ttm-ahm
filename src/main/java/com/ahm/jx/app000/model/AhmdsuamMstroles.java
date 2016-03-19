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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 *
 * @author achmad
 */
@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
@Table(name="AHMDSUAM_MSTROLES")
public class AhmdsuamMstroles extends BaseAuditVersioning implements Serializable{
    
    @Column(name="VROLES_ID",length = 20,nullable = false,unique = true) 
    private String vrolesId;
    
    @Column(name="VROLES_NAME",length = 30) 
    private String vrolesName;
    
    @Column(name="VROLES_DESC",length = 255) 
    private String vrolesDesc;    
    
    @Column(name="VROLES_STATUS",length = 1) 
    private String vrolesStatus;
    
    @OneToMany(mappedBy = "ahmdsuamMstroles")    
    private List<AhmdsuamMstusrrols> listAhmdsuamMstusrrolses;
    
    @OneToMany(mappedBy = "ahmdsuamMstroles")    
    private List<AhmdsuamHdrrlaccess> listAhmdsuamHdrrlaccesses;

    public String getVrolesId() {
        return vrolesId;
    }

    public void setVrolesId(String vrolesId) {
        this.vrolesId = vrolesId;
    }

    public String getVrolesName() {
        return vrolesName;
    }

    public void setVrolesName(String vrolesName) {
        this.vrolesName = vrolesName;
    }

    public String getVrolesDesc() {
        return vrolesDesc;
    }

    public void setVrolesDesc(String vrolesDesc) {
        this.vrolesDesc = vrolesDesc;
    }

    public String getVrolesStatus() {
        return vrolesStatus;
    }

    public void setVrolesStatus(String vrolesStatus) {
        this.vrolesStatus = vrolesStatus;
    }

    public List<AhmdsuamMstusrrols> getListAhmdsuamMstusrrolses() {
        return listAhmdsuamMstusrrolses;
    }

    public void setListAhmdsuamMstusrrolses(List<AhmdsuamMstusrrols> listAhmdsuamMstusrrolses) {
        this.listAhmdsuamMstusrrolses = listAhmdsuamMstusrrolses;
    }

    public List<AhmdsuamHdrrlaccess> getListAhmdsuamHdrrlaccesses() {
        return listAhmdsuamHdrrlaccesses;
    }

    public void setListAhmdsuamHdrrlaccesses(List<AhmdsuamHdrrlaccess> listAhmdsuamHdrrlaccesses) {
        this.listAhmdsuamHdrrlaccesses = listAhmdsuamHdrrlaccesses;
    }
}
