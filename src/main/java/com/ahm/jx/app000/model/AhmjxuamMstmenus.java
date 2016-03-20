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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 *
 * @author sigit
 */
@Entity
@Table(name = "AHMJXUAM_MSTMENUS")
public class AhmjxuamMstmenus extends BaseAuditVersioning implements Serializable {

    @Column(name = "VMENU_ID", length = 16, nullable = false)
    private String vmenuId;

    @Column(name = "VTITLE", length = 36, nullable = false)
    private String vtitle;

    @Column(name = "VURL", length = 128, nullable = true)
    private String vurl;

    @Column(name = "VAPPLICATION_ID", length = 16, unique = true)
    private String vapplicationId;

    @Column(name = "VPARENT", length = 64)
    private String vparent;

    @Column(name = "VSTAT", length = 1)
    private String vstat;

    @Column(name = "VICON", length = 128)
    private String vicon;

    @Column(name = "IORDER", length = 3)
    private Integer iorder;

    /*
     * Menu has parent. In database, root menu has parent = "" instead of NULL !!! 
     * Hibernate will try to find menu with id = "", resulting Entity Not Found, then throw exception.
     * Hibernate annot has @NotFound, but no equivalent annot exist in JPA.
     * either fetch set to lazy, or fix db value if want to stick with jpa annotation.
     * or use mixed hibernate/jpa annotation.
     */
    @ManyToOne(targetEntity = AhmjxuamMstmenus.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VPARENT", referencedColumnName = "VID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private AhmjxuamMstmenus ahmjxuamMstmenus;

    @OneToMany(targetEntity = AhmjxuamMstmenus.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "VPARENT", referencedColumnName = "VID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<AhmjxuamMstmenus> child;

    /**
     * @return the vmenuId
     */
    public String getVmenuId() {
        return vmenuId;
    }

    /**
     * @param vmenuId the vmenuId to set
     */
    public void setVmenuId(String vmenuId) {
        this.vmenuId = vmenuId;
    }

    /**
     * @return the vtitle
     */
    public String getVtitle() {
        return vtitle;
    }

    /**
     * @param vtitle the vtitle to set
     */
    public void setVtitle(String vtitle) {
        this.vtitle = vtitle;
    }

    /**
     * @return the vurl
     */
    public String getVurl() {
        return vurl;
    }

    /**
     * @param vurl the vurl to set
     */
    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    /**
     * @return the vapplicationId
     */
    public String getVapplicationId() {
        return vapplicationId;
    }

    /**
     * @param vapplicationId the vapplicationId to set
     */
    public void setVapplicationId(String vapplicationId) {
        this.vapplicationId = vapplicationId;
    }

    /**
     * @return the vparent
     */
    public String getVparent() {
        return vparent;
    }

    /**
     * @param vparent the vparent to set
     */
    public void setVparent(String vparent) {
        this.vparent = vparent;
    }

    /**
     * @return the vstat
     */
    public String getVstat() {
        return vstat;
    }

    /**
     * @param vstat the vstat to set
     */
    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

    /**
     * @return the vicon
     */
    public String getVicon() {
        return vicon;
    }

    /**
     * @param vicon the vicon to set
     */
    public void setVicon(String vicon) {
        this.vicon = vicon;
    }

    /**
     * @return the iorder
     */
    public Integer getIorder() {
        return iorder;
    }

    /**
     * @param iorder the iorder to set
     */
    public void setIorder(Integer iorder) {
        this.iorder = iorder;
    }

    /**
     * @return the ahmjxuamMstmenus
     */
    public AhmjxuamMstmenus getAhmjxuamMstmenus() {
        return ahmjxuamMstmenus;
    }

    /**
     * @param ahmjxuamMstmenus the ahmjxuamMstmenus to set
     */
    public void setAhmjxuamMstmenus(AhmjxuamMstmenus ahmjxuamMstmenus) {
        this.ahmjxuamMstmenus = ahmjxuamMstmenus;
    }

    /**
     * @return the child
     */
    public List<AhmjxuamMstmenus> getChild() {
        return child;
    }

    /**
     * @param child the child to set
     */
    public void setChild(List<AhmjxuamMstmenus> child) {
        this.child = child;
    }

}
