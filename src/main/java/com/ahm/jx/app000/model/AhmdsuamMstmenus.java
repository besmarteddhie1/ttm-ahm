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
 * @author achmad
 */
@Entity
@Table(name="AHMDSUAM_MSTMENUS")
public class AhmdsuamMstmenus extends BaseAuditVersioning implements Serializable{
                
    @Column(name="VMENU_ID",length = 16,nullable = false)
    private String vmenuId;
    
    @Column(name="VTITLE",length = 24,nullable = false)
    private String vtitle;
    
    @Column(name="VURL",length = 128,nullable = true)
    private String vurl;
    
    @Column(name="VAPPLICATION_ID",length = 16,unique=true)    
    private String vapplicationId;
    
    @Column(name="VPARENT",length = 64)    
    private String vparent;
    
    @Column(name="VSTAT",length=1)
    private String vstat;
    
    @Column(name="VICON",length=128)
    private String vicon;
    
    /*
     * Menu has parent. In database, root menu has parent = "" instead of NULL !!! 
     * Hibernate will try to find menu with id = "", resulting Entity Not Found, then throw exception.
     * Hibernate annot has @NotFound, but no equivalent annot exist in JPA.
     * either fetch set to lazy, or fix db value if want to stick with jpa annotation.
     * or use mixed hibernate/jpa annotation.
     */
    @ManyToOne(targetEntity=AhmdsuamMstmenus.class, fetch= FetchType.LAZY)
    @JoinColumn(name="VPARENT", referencedColumnName="VID",insertable=false,updatable=false)    
    @NotFound(action= NotFoundAction.IGNORE)    
    private AhmdsuamMstmenus ahmdsuamMstmenus;

    @OneToMany(targetEntity = AhmdsuamMstmenus.class,fetch = FetchType.LAZY)
    @JoinColumn(name="VPARENT", referencedColumnName="VID",insertable = false,updatable = false)    
    @NotFound(action= NotFoundAction.IGNORE)    
    private List<AhmdsuamMstmenus> child;

    public String getVmenuId() {
        return vmenuId;
    }

    public void setVmenuId(String vmenuId) {
        this.vmenuId = vmenuId;
    }

    public String getVtitle() {
        return vtitle;
    }

    public void setVtitle(String vtitle) {
        this.vtitle = vtitle;
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    public String getVapplicationId() {
        return vapplicationId;
    }

    public void setVapplicationId(String vapplicationId) {
        this.vapplicationId = vapplicationId;
    }

    public AhmdsuamMstmenus getAhmdsuamMstmenus() {
        return ahmdsuamMstmenus;
    }

    public void setAhmdsuamMstmenus(AhmdsuamMstmenus ahmdsuamMstmenus) {
        this.ahmdsuamMstmenus = ahmdsuamMstmenus;
    }

    public List<AhmdsuamMstmenus> getChild() {
        return child;
    }

    public void setChild(List<AhmdsuamMstmenus> child) {
        this.child = child;
    }

    public String getVparent() {
        return vparent;
    }

    public void setVparent(String vparent) {
        this.vparent = vparent;
    }

    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

    public String getVicon() {
        return vicon;
    }

    public void setVicon(String vicon) {
        this.vicon = vicon;
    }
    
    
}
