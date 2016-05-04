package com.ahm.jx.ttm.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("partner")
public class SynchronizePartner implements AbstractSynchronizer {
	
	@Inject
	Logger log;

	@Override
	public void doRunner() {		
	}

}
