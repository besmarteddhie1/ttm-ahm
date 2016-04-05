/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app011.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app001.vo.Uam001VoAhmjxuamMstuser;
import com.ahm.jx.uam.app002.service.Uam002Service;
import com.ahm.jx.uam.app011.service.Uam011Service;
import com.ahm.jx.uam.app011.vo.Uam011VoAhmjxuamMstusers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;
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
@RequestMapping("/uam011")
public class Uam011Rest {

    private final String appId = "AHMJXUAM011";
    
    @Autowired
    @Qualifier("uam011Service")
    private Uam011Service uam011Service;

    @RequestMapping(value = "forgotUsername", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond forgotUsername(HttpServletRequest httpServletRequest,
    		@RequestBody Uam011VoAhmjxuamMstusers uam011VoAhmjxuamMstusers,
            HttpServletResponse httpServletResponse) {

    	DtoRespond dtoRespond = new DtoRespond();
    	try {
            dtoRespond = uam011Service.forgotUsername(httpServletRequest, httpServletResponse,
            		uam011VoAhmjxuamMstusers, appId);
        } catch (ConstraintViolationException dive) {
            dive.printStackTrace();
            dtoRespond.setDetailMsg("Gagal ");
            dtoRespond.setStat(CommonConstant._500);
            dtoRespond.setMsg(CommonConstant._500Msg);
            return dtoRespond;
        } catch (Exception e) {
            e.printStackTrace();
            dtoRespond.setStat(CommonConstant._500);
            dtoRespond.setMsg(CommonConstant._500Msg);
            dtoRespond.setDetailMsg(e.getMessage());
            return dtoRespond;
        }
        return dtoRespond;
    }

    @RequestMapping(value = "forgotPassword", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond forgotPassword(HttpServletRequest httpServletRequest,
    		@RequestBody Uam011VoAhmjxuamMstusers uam011VoAhmjxuamMstusers,
            HttpServletResponse httpServletResponse) {

    	DtoRespond dtoRespond = new DtoRespond();
    	try {
            dtoRespond = uam011Service.forgotPassword(httpServletRequest, httpServletResponse,
            		uam011VoAhmjxuamMstusers, appId);
        } catch (ConstraintViolationException dive) {
            dive.printStackTrace();
            dtoRespond.setDetailMsg("Gagal");
            dtoRespond.setStat(CommonConstant._500);
            dtoRespond.setMsg(CommonConstant._500Msg);
            return dtoRespond;
        } catch (Exception e) {
            e.printStackTrace();
            dtoRespond.setStat(CommonConstant._500);
            dtoRespond.setMsg(CommonConstant._500Msg);
            dtoRespond.setDetailMsg(e.getMessage());
            return dtoRespond;
        }
        return dtoRespond;
    }
}
