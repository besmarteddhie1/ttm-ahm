/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app009.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app009.service.Uam009Service;

import ch.qos.logback.core.net.SyslogOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ferdy
 */
@Controller
@RequestMapping("/uam009")
public class Uam009Rest {

    private final String appId = "AHMJXUAM009";
    @Autowired
    @Qualifier("uam009Service")
    private Uam009Service uam009Service;

    @RequestMapping(value = "listActiveUser", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond listActiveUser(HttpServletRequest httpServletRequest,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        Integer diff = 0;
        dtoRespond = uam009Service.listActive(httpServletRequest, cookieDims,diff);
        return dtoRespond;
    }
    
    @RequestMapping(value = "listActiveMenu", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond listActiveMenu(HttpServletRequest httpServletRequest,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        Integer diff = 1;
        dtoRespond = uam009Service.listActive(httpServletRequest, cookieDims,diff);
        return dtoRespond;
    }
    
//    @RequestMapping(value = "paging", method = RequestMethod.POST,
//            consumes = {MediaType.APPLICATION_JSON_VALUE},
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    DtoRespondPaging pagingRole(HttpServletRequest httpServletRequest,
//            HttpServletResponse httpServletResponse,
//            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
//            @RequestBody DtoParamPaging dtoParamPaging) {
//
//        DtoRespondPaging respondPaging = uam009Service.pagingAppsUsage(httpServletRequest,
//                httpServletResponse, dtoParamPaging, cookieDims, appId);
//        return respondPaging;
//    }
    
    

}
