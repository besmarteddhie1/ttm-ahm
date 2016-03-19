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
@Table(name = "AHMDSBSC_TXNAPPCOUNT",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMJXUAM_MSTMENUS", "IBULAN", "ITAHUN"}))
public class AhmdsbscTxnappcount extends BaseAuditVersioning implements Serializable {

    @Column(name = "VID_AHMJXUAM_MSTMENUS", length = 64)
    private String vidAhmjxuamMstmenus;

    @ManyToOne(targetEntity = AhmjxuamMstmenus.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_AHMJXUAM_MSTMENUS", referencedColumnName = "VID", insertable = false, updatable = false)
    private AhmjxuamMstmenus ahmjxuamMstmenus;

    @Column(name = "IBULAN", precision = 0, scale = 2)
    private Integer ibulan;

    @Column(name = "ITAHUN", precision = 0, scale = 4)
    private Integer itahun;

    @Column(name = "ICOUNTER", precision = 0, scale = 20)
    private BigInteger icounter;

    public String getVidAhmjxuamMstmenus() {
        return vidAhmjxuamMstmenus;
    }

    public void setVidAhmjxuamMstmenus(String vidAhmjxuamMstmenus) {
        this.vidAhmjxuamMstmenus = vidAhmjxuamMstmenus;
    }

    public AhmjxuamMstmenus getAhmjxuamMstmenus() {
        return ahmjxuamMstmenus;
    }

    public void setAhmjxuamMstmenus(AhmjxuamMstmenus ahmjxuamMstmenus) {
        this.ahmjxuamMstmenus = ahmjxuamMstmenus;
    }

    public Integer getIbulan() {
        return ibulan;
    }

    public void setIbulan(Integer ibulan) {
        this.ibulan = ibulan;
    }

    public Integer getItahun() {
        return itahun;
    }

    public void setItahun(Integer itahun) {
        this.itahun = itahun;
    }

    public BigInteger getIcounter() {
        return icounter;
    }

    public void setIcounter(BigInteger icounter) {
        this.icounter = icounter;
    }
}
