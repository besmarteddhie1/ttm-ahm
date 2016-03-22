/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

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
 * @author sigit
 */
@Entity
@Table(name = "AHMJXUAM_MSTAPPS")
public class AhmjxuamMstapps extends BaseAuditVersioning implements Serializable {

    @Column(name = "VNAME")
    private String vname;

    @Column(name = "VDESC")
    private String vdesc;

    @Column(name = "VSTAT", length = 1)
    private String vstat;

    @OneToMany(mappedBy = "ahmjxuamMstapps")
    private List<AhmjxuamMstservices> listAhmjxuamMstserviceses;

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVdesc() {
        return vdesc;
    }

    public void setVdesc(String vdesc) {
        this.vdesc = vdesc;
    }

    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

    public List<AhmjxuamMstservices> getListAhmjxuamMstserviceses() {
        return listAhmjxuamMstserviceses;
    }

    public void setListAhmjxuamMstserviceses(List<AhmjxuamMstservices> listAhmjxuamMstserviceses) {
        this.listAhmjxuamMstserviceses = listAhmjxuamMstserviceses;
    }

}
