package com.ahm.jx.ttm.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/*
 * CREATE TABLE IF NOT EXISTS `ahmjxuam_mstpartner` (
  `BCERT` longblob NOT NULL,
  `DBEGINEFF` datetime NOT NULL,
  `DENDEFF` datetime NOT NULL,
  `NLEVEL` int(11) NOT NULL,
  `NPIT` int(11) DEFAULT NULL,
  `VADDRESS` varchar(100) NOT NULL,
  `VCITY` varchar(45) NOT NULL,
  `VDEALERCODE` varchar(6) NOT NULL,
  `VMDCODE` varchar(6) NOT NULL,
  `VMDDLRCODE` varchar(6) DEFAULT NULL,
  `VNAME` varchar(35) DEFAULT NULL,
  `VOWNER` varchar(30) NOT NULL,
  `VPHONENUM` varchar(50) NOT NULL,
  PRIMARY KEY (`VID`),
  UNIQUE KEY `UK_53v0q4j54ucfn967cxlkldulg` (`VDEALERCODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 */

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(columnDefinition="vtypeahm")
@Table(name="ahmjxuam_mstpartner")
public class AbstractPartner extends AhmBaseEntity {
	
	private static final long serialVersionUID = 6927186437039445315L;
	
	public final static String type_dealer = "1";
	public final static String type_main_dealer = "2";
}
