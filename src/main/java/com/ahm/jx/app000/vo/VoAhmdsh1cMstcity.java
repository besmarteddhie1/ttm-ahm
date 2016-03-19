/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.vo;

import com.ahm.jx.common.json.CustomDateDeserializer;
import com.ahm.jx.common.json.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

/**
 *
 * @author achmad.ha
 */
public class VoAhmdsh1cMstcity {
    
    private String vid;
    
    private String vidcity;
    
    private String vidprov;
    
    private String vcitydesc;
    
    @JsonSerialize(using=CustomDateSerializer.class)
    private Date dbgneff;
    
    @JsonSerialize(using=CustomDateSerializer.class)
    private Date dendeff;    
    
    private String vb2bstat;
    
    private String vidb2b;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVidcity() {
        return vidcity;
    }

    public void setVidcity(String vidcity) {
        this.vidcity = vidcity;
    }

    public String getVidprov() {
        return vidprov;
    }

    public void setVidprov(String vidprov) {
        this.vidprov = vidprov;
    }

    public String getVcitydesc() {
        return vcitydesc;
    }

    public void setVcitydesc(String vcitydesc) {
        this.vcitydesc = vcitydesc;
    }

    public Date getDbgneff() {
        return dbgneff;
    }

    public void setDbgneff(Date dbgneff) {
        this.dbgneff = dbgneff;
    }

    public Date getDendeff() {
        return dendeff;
    }

    public void setDendeff(Date dendeff) {
        this.dendeff = dendeff;
    }

    public String getVb2bstat() {
        return vb2bstat;
    }

    public void setVb2bstat(String vb2bstat) {
        this.vb2bstat = vb2bstat;
    }

    public String getVidb2b() {
        return vidb2b;
    }

    public void setVidb2b(String vidb2b) {
        this.vidb2b = vidb2b;
    }
}
