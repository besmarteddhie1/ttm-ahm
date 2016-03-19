/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.vo;

import java.math.BigInteger;

/**
 *
 * @author achmad.ha
 */
public class VoCounterApp {
    
    private String vid;
    private String menuId;
    private String appId;
    private String user;
    private BigInteger counter;
    private Integer bulan;
    private Integer tahun;
    private Integer iver;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }
    
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public BigInteger getCounter() {
        return counter;
    }

    public void setCounter(BigInteger counter) {
        this.counter = counter;
    }

    public Integer getBulan() {
        return bulan;
    }

    public void setBulan(Integer bulan) {
        this.bulan = bulan;
    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }
    
    public Integer getIver() {
        return iver;
    }

    public void setIver(Integer iver) {
        this.iver = iver;
    }
    
    
}
