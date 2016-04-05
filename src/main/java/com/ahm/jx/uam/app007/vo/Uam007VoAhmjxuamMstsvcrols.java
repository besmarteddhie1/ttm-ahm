/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app007.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ferdy
 */
public class Uam007VoAhmjxuamMstsvcrols implements Serializable {

   	private String vidAhmjxuamMstservices;
    private String vidAhmjxuamMstroles;
    private String vid;
    private String createBy;
    private Date createDate;
    private Integer iver;

    
	public Integer getIver() {
		return iver;
	}
	public void setIver(Integer iver) {
		this.iver = iver;
	}
	public String getVidAhmjxuamMstservices() {
		return vidAhmjxuamMstservices;
	}
	public void setVidAhmjxuamMstservices(String vidAhmjxuamMstservices) {
		this.vidAhmjxuamMstservices = vidAhmjxuamMstservices;
	}
	public String getVidAhmjxuamMstroles() {
		return vidAhmjxuamMstroles;
	}
	public void setVidAhmjxuamMstroles(String vidAhmjxuamMstroles) {
		this.vidAhmjxuamMstroles = vidAhmjxuamMstroles;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
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
