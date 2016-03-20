
package com.ahm.jx.ttm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * Table ini berisi data Dealer, untuk H1, H2 dan H3 coba di redesign
 * -- apri
 */

@Entity
@Table(name = "ahmdsh1c_mstpartner")
public class AhmPartner extends AhmBaseEntity {

	private static final long serialVersionUID = 1123754243149467367L;

    @Column(name="vidahmprtncode")
    private String idAhmCode;
    
	@Column(name="vidprtncode")
    private String partnerCode;
    
    @Column(name="vpartnerdesc")
    private String name;
        
    @Column(name="vtypert")
    private String typeRT;
            
    @Column(name="vpicname")
    private String picName;
    
    @Column(name="vstat")
    private boolean status;    
    
    @Column(name="vaddress")
    private String alamat;
    
    @Column(name="VID_AHMDSH1C_MSTKELURAHAN")
    private String kelurahan;
    
    @Column(name="VB2BSTAT")
    private Boolean statusB2B;
        
    @Column(name="VIDB2B")
    private String idB2B;
    
    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String dealerCode;

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(String kelurahan) {
		this.kelurahan = kelurahan;
	}

	public Boolean getStatusB2B() {
		return statusB2B;
	}

	public void setStatusB2B(Boolean statusB2B) {
		this.statusB2B = statusB2B;
	}

	public String getTypeRT() {
		return typeRT;
	}

	public void setTypeRT(String typeRT) {
		this.typeRT = typeRT;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public String getIdAhmCode() {
		return idAhmCode;
	}

	public void setIdAhmCode(String idAhmCode) {
		this.idAhmCode = idAhmCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getIdB2B() {
		return idB2B;
	}

	public void setIdB2B(String idB2B) {
		this.idB2B = idB2B;
	}
    
}
