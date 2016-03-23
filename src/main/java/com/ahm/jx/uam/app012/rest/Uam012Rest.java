/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app012.rest;

import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app012.service.Uam012Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sigit
 */
@Controller
@RequestMapping("/uam012")
public class Uam012Rest {

    private final String appId = "AHMJXUAM012";

//    @Autowired
//    @Qualifier("uam012Service")
    private Uam012Service uam012Service;

    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

}
