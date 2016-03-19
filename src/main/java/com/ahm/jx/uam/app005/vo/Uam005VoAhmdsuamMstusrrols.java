/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Fransisca
 */
public class Uam005VoAhmdsuamMstusrrols implements Serializable {

    private String vidAhmdsuamMstusers;
    private String vidAhmdsuamMstroles;
    private String ahmdsuamMstusers;
    private String ahmdsuamMstroles;
    private String vid;
    private Integer iver;
    private String vusername;
    private String vstatus;
    private String createBy;
    private Date createDate;

    public String getVstatus() {
        return vstatus;
    }

    public void setVstatus(String vstatus) {
        this.vstatus = vstatus;
    }

    public String getVusername() {
        return vusername;
    }

    public void setVusername(String vusername) {
        this.vusername = vusername;
    }

    public String getVrolesName() {
        return vrolesName;
    }

    public void setVrolesName(String vrolesName) {
        this.vrolesName = vrolesName;
    }
    private String vrolesName;

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

    public String getVidAhmdsuamMstusers() {
        return vidAhmdsuamMstusers;
    }

    public void setVidAhmdsuamMstusers(String vidAhmdsuamMstusers) {
        this.vidAhmdsuamMstusers = vidAhmdsuamMstusers;
    }

    public String getVidAhmdsuamMstroles() {
        return vidAhmdsuamMstroles;
    }

    public void setVidAhmdsuamMstroles(String vidAhmdsuamMstroles) {
        this.vidAhmdsuamMstroles = vidAhmdsuamMstroles;
    }

    public String getAhmdsuamMstusers() {
        return ahmdsuamMstusers;
    }

    public void setAhmdsuamMstusers(String ahmdsuamMstusers) {
        this.ahmdsuamMstusers = ahmdsuamMstusers;
    }

    public String getAhmdsuamMstroles() {
        return ahmdsuamMstroles;
    }

    public void setAhmdsuamMstroles(String ahmdsuamMstroles) {
        this.ahmdsuamMstroles = ahmdsuamMstroles;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
}
