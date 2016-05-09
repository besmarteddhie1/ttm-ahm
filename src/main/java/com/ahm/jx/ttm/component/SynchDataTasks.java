package com.ahm.jx.ttm.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ahm.jx.ttm.service.AbstractSynchronizer;

@Component
public class SynchDataTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
//    @Inject
//    @Qualifier("partner")
//    AbstractSynchronizer syncPartner;

    @Scheduled(cron="1 */10 * * * MON-FRI")
    public void UpdatePartner() {
//    	syncPartner.doRunner();
        System.out.println("Update By Cron " + dateFormat.format(new Date()));
    }    
}