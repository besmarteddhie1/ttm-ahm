/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app007.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app005.service.Uam005Service;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmjxuamMstusrrols;
import com.ahm.jx.uam.app007.service.Uam007Service;
import com.ahm.jx.uam.app007.vo.Uam007VoAhmjxuamMstsvcrols;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
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
@RequestMapping("/uam007")
public class Uam007Rest {

    private final String appId = "AHMJXUAM007";
    @Autowired
    @Qualifier("uam007Service")
    private Uam007Service uam007Service;

    @RequestMapping(value = "insert", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond insertUserRole(HttpServletRequest httpServletRequest,
            @RequestBody Uam007VoAhmjxuamMstsvcrols uam007VoAhmjxuamMstsvcrols,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            dtoRespond = uam007Service.insertSvcRole(httpServletRequest, httpServletResponse,
            		uam007VoAhmjxuamMstsvcrols, cookieDims, appId);
        } catch (DataIntegrityViolationException dive) {
            dive.printStackTrace();
            dtoRespond.setDetailMsg("Gagal Insert ");
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

//    @RequestMapping(value = "update", method = RequestMethod.POST,
//            consumes = {MediaType.APPLICATION_JSON_VALUE},
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    DtoRespond updateSvcRole(HttpServletRequest httpServletRequest,
//            @RequestBody Uam007VoAhmjxuamMstsvcrols uam007VoAhmjxuamMstsvcrols,
//            HttpServletResponse httpServletResponse,
//            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
//        DtoRespond dtoRespond = new DtoRespond();
//        try {
////        	Uam007VoAhmjxuamMstsvcrols oldObj = uam007Service.getSvcrolesById(uam007VoAhmjxuamMstsvcrols.getVid());
////            if (oldObj != null) {
//            	uam007VoAhmjxuamMstsvcrols.setCreateBy(oldObj.getCreateBy());
//            	uam007VoAhmjxuamMstsvcrols.setCreateDate(oldObj.getCreateDate());
//                dtoRespond = uam007Service.update(httpServletRequest, httpServletResponse,
//                		uam007VoAhmjxuamMstsvcrols, cookieDims, appId);
//            } else {
//                dtoRespond.setStat(CommonConstant._404);
//                dtoRespond.setMsg(CommonConstant._404Msg);
//                dtoRespond.setDetailMsg("Data tidak ditemukan");
//            }
//            return dtoRespond;
//        } catch (HibernateOptimisticLockingFailureException holfe) {
//            holfe.printStackTrace();
//            Uam007VoAhmjxuamMstsvcrols temp = uam007Service.getSvcrolesById(uam007VoAhmjxuamMstsvcrols.getVid());
//            if (temp != null) {
//                List<Uam007VoAhmjxuamMstsvcrols> list = new ArrayList<Uam007VoAhmjxuamMstsvcrols>();
//                list.add(temp);
//                dtoRespond.setRows(list);
//            }
//            dtoRespond.setStat(CommonConstant._409);
//            dtoRespond.setMsg(CommonConstant._409Msg);
////            dtoRespond.setStat("509");            
////            dtoRespond.setMsg("Conflict");
//            dtoRespond.setDetailMsg("Update failed data was updated or deleted by another user");
//            return dtoRespond;
//        } catch (Exception e) {
//            e.printStackTrace();
//            dtoRespond.setMsg(e.getMessage());
//            dtoRespond.setStat(CommonConstant._0);
//            return dtoRespond;
//        }
//    }

    @RequestMapping(value = "delete", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond deleteSvcRole(HttpServletRequest httpServletRequest,
            @RequestBody List<Uam007VoAhmjxuamMstsvcrols> uam007VoAhmjxuamMstsvcrols,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = uam007Service.delete(httpServletRequest, httpServletResponse, uam007VoAhmjxuamMstsvcrols, cookieDims, appId);
        return dtoRespond;
    }

    @RequestMapping(value = "paging", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging pagingSvcRoles(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {

        DtoRespondPaging respondPaging = uam007Service.pagingSvcRoles(httpServletRequest,
                httpServletResponse, dtoParamPaging, cookieDims, appId);
        return respondPaging;
    }

    @RequestMapping(value = "lovrole", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging lovRole(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {
        DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
        dtoRespondPaging = uam007Service.getLovRole(httpServletRequest, httpServletResponse, dtoParamPaging,
                cookieDims, appId);
        return dtoRespondPaging;
    }

    @RequestMapping(value = "lovscv", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging lovSvc(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {
        DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
        dtoRespondPaging = uam007Service.getLovSvc(httpServletRequest, httpServletResponse, dtoParamPaging,
                cookieDims, appId);
        return dtoRespondPaging;
    }

}
