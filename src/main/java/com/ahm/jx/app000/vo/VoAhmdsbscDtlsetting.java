/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.vo;

import javax.persistence.Column;

/**
 *
 * @author achmad.ha
 */
public class VoAhmdsbscDtlsetting {    
    
    private String vid;
    
    private String vidAhmdsbscHdrsetting;
    
    private String vitemcode;

    private String vitemname;
    
    private String vitemdesc;
    
    private String vstatus;
    
    private String vdlrcode;
    
    private Integer iver;

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

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public Integer getIver() {
        return iver;
    }

    public void setIver(Integer iver) {
        this.iver = iver;
    }
}
