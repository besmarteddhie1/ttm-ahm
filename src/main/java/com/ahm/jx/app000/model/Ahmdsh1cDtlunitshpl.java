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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hendra.fs
 */
@Entity
@Table(name = "AHMDSH1C_DTLUNITSHPL")
public class Ahmdsh1cDtlunitshpl extends BaseAuditVersioning implements Serializable {
    @ManyToOne(targetEntity=Ahmdsh1cHdrunitshpl.class, fetch=FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_HDRUNITSHPL", referencedColumnName="VID")
    private Ahmdsh1cHdrunitshpl ahmdsh1cHdrunitshpl;
    
    @Column(name = "NQTYSTD", precision = 11, scale = 0)
    private Integer nqtystd = new Integer(0);
    @Column(name = "VID_AHMDSH1C_DTLUNITSPKSO", length = 64)
    private String vidAhmdsh1cDtlunitspkso;
    @ManyToOne(targetEntity = Ahmdsh1cDtlunitspkso.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMDSH1C_DTLUNITSPKSO", referencedColumnName = "VID", insertable = false, updatable = false)
    private Ahmdsh1cDtlunitspkso ahmdsh1cDtlunitspkso;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ahmdsh1cDtlunitshpl")    
    private List<Ahmdsh1cDtlunitshplacc> listAhmdsh1cDtlunitshplacc;

    public Integer getNqtystd() {
        return nqtystd;
    }

    public void setNqtystd(Integer nqtystd) {
        this.nqtystd = nqtystd;
    }

    public String getVidAhmdsh1cDtlunitspkso() {
        return vidAhmdsh1cDtlunitspkso;
    }

    public void setVidAhmdsh1cDtlunitspkso(String vidAhmdsh1cDtlunitspkso) {
        this.vidAhmdsh1cDtlunitspkso = vidAhmdsh1cDtlunitspkso;
    }

    public Ahmdsh1cHdrunitshpl getAhmdsh1cHdrunitshpl() {
        return ahmdsh1cHdrunitshpl;
    }

    public void setAhmdsh1cHdrunitshpl(Ahmdsh1cHdrunitshpl ahmdsh1cHdrunitshpl) {
        this.ahmdsh1cHdrunitshpl = ahmdsh1cHdrunitshpl;
    }

    public Ahmdsh1cDtlunitspkso getAhmdsh1cDtlunitspkso() {
        return ahmdsh1cDtlunitspkso;
    }

    public void setAhmdsh1cDtlunitspkso(Ahmdsh1cDtlunitspkso ahmdsh1cDtlunitspkso) {
        this.ahmdsh1cDtlunitspkso = ahmdsh1cDtlunitspkso;
    }

    public List<Ahmdsh1cDtlunitshplacc> getListAhmdsh1cDtlunitshplacc() {
        return listAhmdsh1cDtlunitshplacc;
    }

    public void setListAhmdsh1cDtlunitshplacc(List<Ahmdsh1cDtlunitshplacc> listAhmdsh1cDtlunitshplacc) {
        this.listAhmdsh1cDtlunitshplacc = listAhmdsh1cDtlunitshplacc;
    }
}
