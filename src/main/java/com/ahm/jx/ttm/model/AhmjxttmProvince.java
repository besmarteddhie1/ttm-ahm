package com.ahm.jx.ttm.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ahmjxttm_province")
@Inheritance(strategy = InheritanceType.JOINED)
public class AhmjxttmProvince extends AhmjxMstGeoBoundary {

	private static final long serialVersionUID = 8744365494331679228L;

}
