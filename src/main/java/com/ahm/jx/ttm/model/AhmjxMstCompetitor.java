package com.ahm.jx.ttm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="ahmjxmst_competitor")
public class AhmjxMstCompetitor extends BaseEntity {

	private static final long serialVersionUID = -2500926500169885028L;
	
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name="idCompetitor")
	private Integer idCompetitor;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="namePos")
	private String namaPos;
		
	@Column(name="idProvinsi")
	private Integer idProvinsi;

	@Column(name="idKabupaten")
	private Integer idKabupaten;

	@Column(name="idKecamatan")
	private Integer idKecamatan;
	
	@Column(name="idKelurahan")
	private Integer idKelurahan;
	
	@Column(name="alamatPos")
	private String alamatPos;
	
	@Column(name="telp")
	private String telp;
	
	@Column(name="lat")
	private String lat;
	
	@Column(name="longi")
	private String longi;

	public Integer getIdCompetitor() {
		return idCompetitor;
	}

	public void setIdCompetitor(Integer idCompetitor) {
		this.idCompetitor = idCompetitor;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getNamaPos() {
		return namaPos;
	}

	public void setNamaPos(String namaPos) {
		this.namaPos = namaPos;
	}

	public Integer getIdProvinsi() {
		return idProvinsi;
	}

	public void setIdProvinsi(Integer idProvinsi) {
		this.idProvinsi = idProvinsi;
	}

	public Integer getIdKabupaten() {
		return idKabupaten;
	}

	public void setIdKabupaten(Integer idKabupaten) {
		this.idKabupaten = idKabupaten;
	}

	public Integer getIdKecamatan() {
		return idKecamatan;
	}

	public void setIdKecamatan(Integer idKecamatan) {
		this.idKecamatan = idKecamatan;
	}

	public Integer getIdKelurahan() {
		return idKelurahan;
	}

	public void setIdKelurahan(Integer idKelurahan) {
		this.idKelurahan = idKelurahan;
	}

	public String getAlamatPos() {
		return alamatPos;
	}

	public void setAlamatPos(String alamatPos) {
		this.alamatPos = alamatPos;
	}

	public String getTelp() {
		return telp;
	}

	public void setTelp(String telp) {
		this.telp = telp;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCompetitor == null) ? 0 : idCompetitor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AhmjxMstCompetitor other = (AhmjxMstCompetitor) obj;
		if (idCompetitor == null) {
			if (other.idCompetitor != null)
				return false;
		} else if (!idCompetitor.equals(other.idCompetitor))
			return false;
		return true;
	}

		
}
