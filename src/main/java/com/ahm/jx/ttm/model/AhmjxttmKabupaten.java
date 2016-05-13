package com.ahm.jx.ttm.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ahmjxttm_kabupaten")
@Inheritance(strategy = InheritanceType.JOINED)
public class AhmjxttmKabupaten extends AhmjxMstGeoBoundary {

	private static final long serialVersionUID = 2899546569376715755L;

}
