package com.ahm.jx.ttm.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ahmjxttm_desa")
@Inheritance(strategy = InheritanceType.JOINED)
public class AhmjxttmDesa extends AhmjxMstGeoBoundary {

	private static final long serialVersionUID = -3924746405125486367L;

}
