/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app002.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app002.vo.Uam002VoAhmjxuamMstroles;
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
import com.ahm.jx.uam.app002.service.Uam002Service;

/**
 *
 * @author indriHtb
 */
@Controller
@RequestMapping("/uam002")
public class Uam002Rest {

    private final String appId = "AHMJXUAM002";

    @Autowired
    @Qualifier("uam002Service")
    private Uam002Service uam002Service;

    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    public Uam002Service getUam002Service() {
        return uam002Service;
    }

    public void setUam002Service(Uam002Service uam002Service) {
        this.uam002Service = uam002Service;
    }

    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @RequestMapping(value = "paging", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging pagingRole(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {

        DtoRespondPaging respondPaging = uam002Service.pagingRole(httpServletRequest,
                httpServletResponse, dtoParamPaging, cookieDims, appId);
        return respondPaging;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond insertRole(HttpServletRequest httpServletRequest,
            @RequestBody Uam002VoAhmjxuamMstroles uam002VoAhmjxuamMstroles,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            dtoRespond = uam002Service.insert(httpServletRequest, httpServletResponse,
                    uam002VoAhmjxuamMstroles, cookieDims, appId);
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
    DtoRespond updateRole(HttpServletRequest httpServletRequest,
            @RequestBody Uam002VoAhmjxuamMstroles uam002VoAhmjxuamMstroles,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            Uam002VoAhmjxuamMstroles oldObj = uam002Service.getRoleById(uam002VoAhmjxuamMstroles.getVid());
            if (oldObj != null) {
                uam002VoAhmjxuamMstroles.setVcrea(oldObj.getVcrea());
                uam002VoAhmjxuamMstroles.setDcrea(oldObj.getDcrea());
                dtoRespond = uam002Service.update(httpServletRequest, httpServletResponse,
                        uam002VoAhmjxuamMstroles, cookieDims, appId);
            } else {
                dtoRespond.setStat(CommonConstant._404);
                dtoRespond.setMsg(CommonConstant._404Msg);
                dtoRespond.setDetailMsg("Data tidak ditemukan");
            }
            return dtoRespond;
        } catch (HibernateOptimisticLockingFailureException holfe) {
            holfe.printStackTrace();
            Uam002VoAhmjxuamMstroles temp = uam002Service.getRoleById(uam002VoAhmjxuamMstroles.getVid());
            if (temp != null) {
                List<Uam002VoAhmjxuamMstroles> list = new ArrayList<Uam002VoAhmjxuamMstroles>();
                list.add(temp);
                dtoRespond.setRows(list);
            }
            dtoRespond.setStat("409");
            dtoRespond.setMsg("Conflict");
            dtoRespond.setDetailMsg("Update failed data was updated or deleted by another user");
            return dtoRespond;
        } catch (Exception e) {
            e.printStackTrace();
            dtoRespond.setMsg(e.getMessage());
            dtoRespond.setStat(CommonConstant._0);
            return dtoRespond;
        }
    }

    @RequestMapping(value = "disable", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond disableRole(HttpServletRequest httpServletRequest,
            @RequestBody List<Uam002VoAhmjxuamMstroles> uam002VoAhmjxuamMstroles,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            dtoRespond = uam002Service.disableRoleState(httpServletRequest, httpServletResponse,
                    uam002VoAhmjxuamMstroles, cookieDims, appId);
            return dtoRespond;
        } catch (HibernateOptimisticLockingFailureException holfe) {
            holfe.printStackTrace();
            dtoRespond.setStat("409");
            dtoRespond.setMsg("Conflict");
            dtoRespond.setDetailMsg("Disable State failed data was updated or deleted by another user");
            return dtoRespond;
        } catch (Exception e) {
            e.printStackTrace();
            dtoRespond.setMsg(e.getMessage());
            dtoRespond.setStat(CommonConstant._0);
            return dtoRespond;
        }
    }
}
