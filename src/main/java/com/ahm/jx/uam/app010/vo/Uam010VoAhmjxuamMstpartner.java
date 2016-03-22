/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app010.vo;

import com.ahm.jx.common.json.CustomDateDeserializer;
import com.ahm.jx.common.json.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

/**
 *
 * @author hendra.fs
 */
public class Uam010VoAhmjxuamMstpartner {

    private String vid;

    private String vdealercode;

    private String vname;

    private String vmdcode;

    private Integer nlevel;

    private String vlevel;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date dbegineff;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date dendeff;

    private Integer iver;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVdealercode() {
        return vdealercode;
    }

    public void setVdealercode(String vdealercode) {
        this.vdealercode = vdealercode;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVmdcode() {
        return vmdcode;
    }

    public void setVmdcode(String vmdcode) {
        this.vmdcode = vmdcode;
    }

    public Integer getNlevel() {
        return nlevel;
    }

    public void setNlevel(Integer nlevel) {
        this.nlevel = nlevel;
    }

    public String getVlevel() {
        return vlevel;
    }

    public void setVlevel(String vlevel) {
        this.vlevel = vlevel;
    }

    public Date getDbegineff() {
        return dbegineff;
    }

    public void setDbegineff(Date dbegineff) {
        this.dbegineff = dbegineff;
    }

    public Date getDendeff() {
        return dendeff;
    }

    public void setDendeff(Date dendeff) {
        this.dendeff = dendeff;
    }

    public Integer getIver() {
        return iver;
    }

    public void setIver(Integer iver) {
        this.iver = iver;
    }
}
