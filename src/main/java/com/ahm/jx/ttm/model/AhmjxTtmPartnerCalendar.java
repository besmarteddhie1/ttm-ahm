package com.ahm.jx.ttm.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ahmjxttm_partner_calendar")
public class AhmjxTtmPartnerCalendar extends AhmjxMstCalendar {

	private static final long serialVersionUID = 8092524056193275862L;

	@ManyToOne
	@JoinColumn(name="vuidpartner")
	private AhmjxTtmPartner partner;
}
