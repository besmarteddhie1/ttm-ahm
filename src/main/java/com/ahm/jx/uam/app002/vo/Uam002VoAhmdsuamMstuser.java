/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app002.vo;

import java.util.Date;

/**
 *
 * @author lexys.jo
 */
public class Uam002VoAhmdsuamMstuser {

    private String vid;
    private String vusername;
    private String vpassword;
    private String vidDlr;
    private String vstat;
    private String vcrea;
    private Date dcrea;
    private  Integer iver; 

    public String getVidDlr() {
        return vidDlr;
    }

    public void setVidDlr(String vidDlr) {
        this.vidDlr = vidDlr;
    }

    public String getVusername() {
        return vusername;
    }

    public void setVusername(String vusername) {
        this.vusername = vusername;
    }
    
    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    
    public String getVstat() {
        return vstat;
    }

    public void setVstat(String vstat) {
        this.vstat = vstat;
    }

    public Integer getIver() {
        return iver;
    }

    public void setIver(Integer iver) {
        this.iver = iver;
    }

    public String getVpassword() {
        return vpassword;
    }

    public void setVpassword(String vpassword) {
        this.vpassword = vpassword;
    }

    public String getVcrea() {
        return vcrea;
    }

    public void setVcrea(String vcrea) {
        this.vcrea = vcrea;
    }

    public Date getDcrea() {
        return dcrea;
    }

    public void setDcrea(Date dcrea) {
        this.dcrea = dcrea;
    }
    
    
    
}
