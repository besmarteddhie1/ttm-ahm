/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.app000.model.Ahmdsh1cMstprospek;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

/**
 *
 * @author george
 */
@Entity
@Subselect("select kel.vid,kel.vkeldesc,kec.vid vidKec, kec.vkecdesc,"
+ "cit.vid vidCity, cit.vcitydesc,prov.vid vidProv, prov.vprovdesc, kel.vpostcode "
+ " from ahmdsh1c_mstkelurahan kel, ahmdsh1c_mstkecamatan kec, ahmdsh1c_mstcity cit, "
+ " ahmdsh1c_mstprov prov "
+ " where kec.vid  = kel.vid_ahmdsh1c_mstkecamatan "
+ " and cit.vid    = kec.vid_ahmdsh1c_mstcity "
+ " and prov.vid   = cit.vid_ahmdsh1c_mstprov")
@Synchronize({"Ahmdsh1cMstkelurahan", "Ahmdsh1cMstkecamatan", "Ahmdsh1cMstcity", "Ahmdsh1cMstprov"})
public class H1c005Locjoin implements Serializable{

    @Id
    private String vid;
    @Column
    private String vkeldesc;
    @Column
    private String vidKec;
    @Column
    private String vkecdesc;
    @Column
    private String vidCity;
    @Column
    private String vcitydesc;
    @Column
    private String vidProv;
    @Column
    private String vprovdesc;
    @Column
    private String vpostcode;
    
    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVkeldesc() {
        return vkeldesc;
    }

    public void setVkeldesc(String vkeldesc) {
        this.vkeldesc = vkeldesc;
    }

    public String getVidKec() {
        return vidKec;
    }

    public void setVidKec(String vidKec) {
        this.vidKec = vidKec;
    }

    public String getVkecdesc() {
        return vkecdesc;
    }

    public void setVkecdesc(String vkecdesc) {
        this.vkecdesc = vkecdesc;
    }

    public String getVidCity() {
        return vidCity;
    }

    public void setVidCity(String vidCity) {
        this.vidCity = vidCity;
    }

    public String getVcitydesc() {
        return vcitydesc;
    }

    public void setVcitydesc(String vcitydesc) {
        this.vcitydesc = vcitydesc;
    }

    public String getVidProv() {
        return vidProv;
    }

    public void setVidProv(String vidProv) {
        this.vidProv = vidProv;
    }

    public String getVprovdesc() {
        return vprovdesc;
    }

    public void setVprovdesc(String vprovdesc) {
        this.vprovdesc = vprovdesc;
    }

    public String getVpostcode() {
        return vpostcode;
    }

    public void setVpostcode(String vpostcode) {
        this.vpostcode = vpostcode;
    }
}
