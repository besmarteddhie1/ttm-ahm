/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app008.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app008.service.Uam008Service;
import com.ahm.jx.uam.app008.vo.Uam008VoAhmjxuamMstapps;
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
@RequestMapping("/uam008")
public class Uam008Rest {

    private final String appId = "AHMJXUAM008";

    @Autowired
    @Qualifier("uam008Service")
    private Uam008Service uam008Service;

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
            @RequestBody DtoParamPaging dtoParamPaging) {

        DtoRespondPaging respondPaging = uam008Service.pagingApps(httpServletRequest,
                httpServletResponse, dtoParamPaging, cookieDims, appId);

        return respondPaging;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond insert(HttpServletRequest httpServletRequest,
            @RequestBody Uam008VoAhmjxuamMstapps uam008VoAhmjxuamMstapps,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();

        try {
//            System.out.println("Versi Rest insert Data trial : " + uam008VoAhmjxuamMstapps.getVstat() + "--" + uam008VoAhmjxuamMstapps.getVusername() + "--" + uam001VoAhmjxuamMstUser.getVpassword());
            dtoRespond = uam008Service.insert(httpServletRequest, httpServletResponse,
                    uam008VoAhmjxuamMstapps, cookieDims, appId);
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
    DtoRespond update(HttpServletRequest httpServletRequest,
            @RequestBody Uam008VoAhmjxuamMstapps uam008VoAhmjxuamMstapps,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();

        try {
            System.out.println("Versi Rest Data : " + uam008VoAhmjxuamMstapps.getVid() + "--" + uam008VoAhmjxuamMstapps.getVname() + "--" + uam008VoAhmjxuamMstapps.getVdesc());

            Uam008VoAhmjxuamMstapps oldObj = uam008Service.getAppsById(uam008VoAhmjxuamMstapps.getVid());

            System.out.println("------> oldObj.getVid(): " + oldObj.getVid());
            System.out.println("------> oldObj:getIver(): " + oldObj.getIver());
            if (oldObj != null) {
                dtoRespond = uam008Service.update(httpServletRequest, httpServletResponse, uam008VoAhmjxuamMstapps, cookieDims, appId);
                dtoRespond.setStat(CommonConstant._200);
                dtoRespond.setMsg(CommonConstant._200Msg);
                dtoRespond.setDetailMsg("Update berhasil!");
            } else {
                dtoRespond.setStat(CommonConstant._404);
                dtoRespond.setMsg(CommonConstant._404Msg);
                dtoRespond.setDetailMsg("Data tidak ditemukan");
            }
            return dtoRespond;
        } catch (HibernateOptimisticLockingFailureException holfe) {
            holfe.printStackTrace();
            Uam008VoAhmjxuamMstapps temp = uam008Service.getAppsById(uam008VoAhmjxuamMstapps.getVid());
            if (temp != null) {
                List<Uam008VoAhmjxuamMstapps> list = new ArrayList<Uam008VoAhmjxuamMstapps>();
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

    @RequestMapping(value = "disable", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond disable(HttpServletRequest httpServletRequest,
            @RequestBody List<Uam008VoAhmjxuamMstapps> uam008VoAhmjxuamMstapps,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();

        try {
            dtoRespond = uam008Service.disableState(httpServletRequest, httpServletResponse,
                    uam008VoAhmjxuamMstapps, cookieDims, appId);
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
