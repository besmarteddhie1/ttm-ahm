package com.ahm.jx.ttm.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.ahm.jx.ttm.model.AhmBaseEntity;


@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(columnDefinition="vtypeahm")
@Table(name="ahmjxuam_mstpartner")
public class AbstractPartner extends AhmBaseEntity {
	
	private static final long serialVersionUID = 6927186437039445315L;
	
	public final static String type_dealer = "1";
	public final static String type_main_dealer = "2";
}
