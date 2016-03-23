/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app009.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sigit
 */
@Controller
@RequestMapping("/uam009")
public class Uam009Rest {

    private final String appId = "AHMJXUAM009";

    @RequestMapping(value = "paging", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging pagingRole(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoRespondPaging dtoRespondPaging) {

        DtoRespondPaging respondPaging = new DtoRespondPaging();

        return respondPaging;
    }
}
