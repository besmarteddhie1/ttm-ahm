package com.ahm.jx.ttm.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class SynchDataTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron="1 */10 * * * MON-FRI")
    public void UpdatePartner() {
        System.out.println("Update By Cron " + dateFormat.format(new Date()));
    }    
}