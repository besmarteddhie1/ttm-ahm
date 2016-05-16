package com.ahm.jx.ttm.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ahmjxttm_kecamatan")
@Inheritance(strategy = InheritanceType.JOINED)
public class AhmjxttmKecamatan extends AhmjxMstGeoBoundary {

	private static final long serialVersionUID = -4873202780525979005L;

}
