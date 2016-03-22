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
public class Uam005VoAhmjxuamMstusrrols implements Serializable {

    private String vidAhmjxuamMstusers;
    private String vidAhmjxuamMstroles;
    private String ahmjxuamMstusers;
    private String ahmjxuamMstroles;
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

    public String getVidAhmjxuamMstusers() {
        return vidAhmjxuamMstusers;
    }

    public void setVidAhmjxuamMstusers(String vidAhmjxuamMstusers) {
        this.vidAhmjxuamMstusers = vidAhmjxuamMstusers;
    }

    public String getVidAhmjxuamMstroles() {
        return vidAhmjxuamMstroles;
    }

    public void setVidAhmjxuamMstroles(String vidAhmjxuamMstroles) {
        this.vidAhmjxuamMstroles = vidAhmjxuamMstroles;
    }

    public String getAhmjxuamMstusers() {
        return ahmjxuamMstusers;
    }

    public void setAhmjxuamMstusers(String ahmjxuamMstusers) {
        this.ahmjxuamMstusers = ahmjxuamMstusers;
    }

    public String getAhmjxuamMstroles() {
        return ahmjxuamMstroles;
    }

    public void setAhmjxuamMstroles(String ahmjxuamMstroles) {
        this.ahmjxuamMstroles = ahmjxuamMstroles;
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
