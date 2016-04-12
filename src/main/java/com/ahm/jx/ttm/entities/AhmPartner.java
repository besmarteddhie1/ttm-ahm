
package com.ahm.jx.ttm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ahm.jx.ttm.model.AhmBaseEntity;

/*
 * Table ini berisi data Dealer, untuk H1, H2 dan H3 coba di redesign
 * -- apri
 */

@Entity
@Table(name = "ahmjxuam_mstpartner")
public class AhmPartner extends AhmBaseEntity {

	private static final long serialVersionUID = 1123754243149467367L;

    @Column(name="vdealercode")
    private String idDealer;
    
    @Column(name="vmdcode")
    private String idMainDealer;
    
    @Column(name="vmddealercode")
    private String mdDealerCode;    
        
    @Column(name="vname")
    private String name;
    
    @Column(name="vowner")
    private String owner;
    
    @Column(name="vaddress")
    private String address;
    
    @Column(name="vphonenum")
    private String phoneNum;
    
    @Column(name="npit")
    private Integer pit;
    
    @Column(name="nlevel")
    private Integer level;

	public String getIdDealer() {
		return idDealer;
	}

	public void setIdDealer(String idDealer) {
		this.idDealer = idDealer;
	}

	public String getIdMainDealer() {
		return idMainDealer;
	}

	public void setIdMainDealer(String idMainDealer) {
		this.idMainDealer = idMainDealer;
	}

	public String getMdDealerCode() {
		return mdDealerCode;
	}

	public void setMdDealerCode(String mdDealerCode) {
		this.mdDealerCode = mdDealerCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getPit() {
		return pit;
	}

	public void setPit(Integer pit) {
		this.pit = pit;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}    
}
