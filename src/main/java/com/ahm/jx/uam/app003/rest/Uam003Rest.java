/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app003.service.Uam003Service;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmjxuamMstservice;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * @author sigit
 */
@Controller
@RequestMapping("/uam003")
public class Uam003Rest {

    private final String appId = "AHMJXUAM003";

    @Autowired
    @Qualifier("uam003Service")
    private Uam003Service uam003Service;

    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

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

    @RequestMapping(value = "insert", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond insertMenu(HttpServletRequest httpServletRequest,
            @RequestBody Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservices,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            dtoRespond = uam003Service.insert(httpServletRequest, httpServletResponse,
                    uam003VoAhmjxuamMstservices, cookieDims, appId);
        } catch (ConstraintViolationException dive) {
            dive.printStackTrace();
            dtoRespond.setDetailMsg("Gagal Insert Integrity Constraint");
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

    @RequestMapping(value = "update", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond updateMenus(HttpServletRequest httpServletRequest,
            @RequestBody Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservice,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            Uam003VoAhmjxuamMstservice oldObj = uam003Service.getServiceById(uam003VoAhmjxuamMstservice.getVid());
            if (oldObj != null) {
                dtoRespond = uam003Service.update(httpServletRequest, httpServletResponse,
                        uam003VoAhmjxuamMstservice, cookieDims, appId, oldObj);
            } else {
                dtoRespond.setStat(CommonConstant._404);
                dtoRespond.setMsg(CommonConstant._404Msg);
            }
            return dtoRespond;
        } catch (HibernateOptimisticLockingFailureException holfe) {
            holfe.printStackTrace();
            Uam003VoAhmjxuamMstservice temp = uam003Service.getServiceById(uam003VoAhmjxuamMstservice.getVid());
            if (temp != null) {
                List<Uam003VoAhmjxuamMstservice> list = new ArrayList<Uam003VoAhmjxuamMstservice>();
                list.add(temp);
                dtoRespond.setRows(list);
            }
            dtoRespond.setStat(CommonConstant._409);
            dtoRespond.setMsg(CommonConstant._409Msg);
            dtoRespond.setDetailMsg("Update failed data was updated or deleted by another user");
            return dtoRespond;
        } catch (Exception e) {
            e.printStackTrace();
            dtoRespond.setMsg(e.getMessage());
            dtoRespond.setStat(CommonConstant._0);
            return dtoRespond;
        }
    }

}
