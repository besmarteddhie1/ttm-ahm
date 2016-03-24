/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.ttm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondAppInfo;
import com.ahm.jx.common.rest.dto.DtoRespondLogin;
import com.ahm.jx.common.util.BasicAuth;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.dashboard.vo.VoAppInfo;
import com.ahm.jx.dashboard.vo.VoChangePassword;

/**
 *
 * @author achmad.ha
 */

@RestController
@RequestMapping("/api/dashboardd")
public class DashboarddRest {

    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    @RequestMapping(value = "check", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public String check() {
        return "1"; 
    }
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public DtoRespond login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        String userName = BasicAuth.getUserName(httpServletRequest);
        String password = BasicAuth.getPassword(httpServletRequest);
        
        System.out.println("---> userName: " + userName);
        System.out.println("---> password: " + password);

        dtoRespond = dashboardService.login(userName, password,
                httpServletRequest, httpServletResponse);
        return dtoRespond;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond logout(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = dashboardService.logout(httpServletRequest, httpServletResponse);
        return dtoRespond;
    }

    @RequestMapping(value = "dashboard", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondLogin getDashboardInformation(
            HttpServletRequest httpServletRequest,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            HttpServletResponse httpServletResponse) {
        DtoRespondLogin dtoRespondLogin = new DtoRespondLogin();
        dtoRespondLogin = dashboardService.dashboardInformation(httpServletRequest,
                httpServletResponse, cookieDims);
        return dtoRespondLogin;
    }

    @RequestMapping(value = "appinfo", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondAppInfo appInformation(@RequestBody VoAppInfo voAppInfo,
            HttpServletRequest httpServletRequest,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            HttpServletResponse httpServletResponse) {
        DtoRespondAppInfo dtoRespondAppInfo = new DtoRespondAppInfo();

        if (voAppInfo.getAppId() != null) {
            if (!voAppInfo.getAppId().trim().equals("")) {
                dtoRespondAppInfo = dashboardService.appInformation(httpServletRequest, httpServletResponse,
                        voAppInfo, cookieDims);

            } else {
                dtoRespondAppInfo.setStat(CommonConstant._401);
            }
        } else {
            dtoRespondAppInfo.setStat(CommonConstant._401);
        }
        return dtoRespondAppInfo;
    }

    @RequestMapping(value = "changepass", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond changePassword(@RequestBody VoChangePassword voChangePassword,
            HttpServletRequest httpServletRequest,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = dashboardService.changePassword(voChangePassword, httpServletRequest, httpServletResponse);
        return dtoRespond;
    }

    @RequestMapping(value = "getuserbookmark", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond getBookmarkUser(
            HttpServletRequest httpServletRequest,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = dashboardService.getBookmarkUser(httpServletRequest, httpServletResponse);
        return dtoRespond;
    }

    @RequestMapping(value = "bookmarkmenu", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond bookmarkMenu(@RequestBody VoAppInfo voAppInfo,
            HttpServletRequest httpServletRequest,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = dashboardService.bookmarkMenu(voAppInfo.getAppId(), httpServletRequest, httpServletResponse);
        return dtoRespond;
    }

    @RequestMapping(value = "unbookmarkmenu", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond unbookmarkMenu(@RequestBody VoAppInfo voAppInfo,
            HttpServletRequest httpServletRequest,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = dashboardService.unbookmarkMenu(voAppInfo.getAppId(), httpServletRequest, httpServletResponse);
        return dtoRespond;
    }

    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }
}
