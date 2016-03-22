/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app001.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app001.vo.Uam001VoAhmjxuamMstuser;
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
import com.ahm.jx.uam.app001.service.Uam001Service;

/**
 *
 * @author lexys.jo
 */
@Controller
@RequestMapping("/uam001")
public class Uam001Rest {

    private final String appId = "AHMJXUAM001";
    @Autowired
    @Qualifier("uam001Service")
    private Uam001Service uam001Service;
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    @RequestMapping(value = "lovdealer", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging lovDealer(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = uam001Service.getLovDealer(httpServletRequest, httpServletResponse, dtoParamPaging,
                cookieDims, appId);
        return dtoRespondPaging;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond insertUser(HttpServletRequest httpServletRequest,
            @RequestBody Uam001VoAhmjxuamMstuser uam001VoAhmjxuamMstUser,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            System.out.println("Versi Rest insert Data trial : " + uam001VoAhmjxuamMstUser.getVstat() + "--" + uam001VoAhmjxuamMstUser.getVusername() + "--" + uam001VoAhmjxuamMstUser.getVpassword());
            dtoRespond = uam001Service.insert(httpServletRequest, httpServletResponse,
                    uam001VoAhmjxuamMstUser, cookieDims, appId);
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

    @RequestMapping(value = "paging", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging pagingUser(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {

        DtoRespondPaging respondPaging = uam001Service.pagingUser(httpServletRequest,
                httpServletResponse, dtoParamPaging, cookieDims, appId);
        return respondPaging;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond updateUser(HttpServletRequest httpServletRequest,
            @RequestBody Uam001VoAhmjxuamMstuser uam001VoAhmjxuamMstuser,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            System.out.println("Versi Rest Data : " + uam001VoAhmjxuamMstuser.getVid() + "--" + uam001VoAhmjxuamMstuser.getVusername() + "--" + uam001VoAhmjxuamMstuser.getVpassword());
            Uam001VoAhmjxuamMstuser oldObj = uam001Service.getUserById(uam001VoAhmjxuamMstuser.getVid());
            if (oldObj != null) {
                dtoRespond = uam001Service.update(httpServletRequest, httpServletResponse, uam001VoAhmjxuamMstuser, cookieDims, appId);
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
            Uam001VoAhmjxuamMstuser temp = uam001Service.getUserById(uam001VoAhmjxuamMstuser.getVid());
            if (temp != null) {
                List<Uam001VoAhmjxuamMstuser> list = new ArrayList<Uam001VoAhmjxuamMstuser>();
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
    DtoRespond disableState(HttpServletRequest httpServletRequest,
            @RequestBody List<Uam001VoAhmjxuamMstuser> uam001VoAhmjxuamMstusers,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            dtoRespond = uam001Service.disableState(httpServletRequest, httpServletResponse,
                    uam001VoAhmjxuamMstusers, cookieDims, appId);
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

    @RequestMapping(value = "reset", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond resetPassword(HttpServletRequest httpServletRequest,
            @RequestBody List<Uam001VoAhmjxuamMstuser> uam001VoAhmjxuamMstusers,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            dtoRespond = uam001Service.resetPassword(httpServletRequest, httpServletResponse,
                    uam001VoAhmjxuamMstusers, cookieDims, appId);
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
