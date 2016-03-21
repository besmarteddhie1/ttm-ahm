/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app005.service.Uam005Service;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmjxuamMstusrrols;
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
 * @author Fransisca
 */

@Controller
@RequestMapping("/uam005")
public class Uam005Rest {

    private final String appId = "AHMJXUAM005";
    @Autowired
    @Qualifier("uam005Service")
    private Uam005Service uam005Service;

    @RequestMapping(value = "insert", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond insertUserRole(HttpServletRequest httpServletRequest,
            @RequestBody Uam005VoAhmjxuamMstusrrols uam005VoAhmjxuamMstusrrols,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            dtoRespond = uam005Service.insertUserRole(httpServletRequest, httpServletResponse,
                    uam005VoAhmjxuamMstusrrols, cookieDims, appId);
        } catch (DataIntegrityViolationException dive) {
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
    DtoRespond updateUserRole(HttpServletRequest httpServletRequest,
            @RequestBody Uam005VoAhmjxuamMstusrrols uam005VoAhmjxuamMstusrrols,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            Uam005VoAhmjxuamMstusrrols oldObj = uam005Service.getUserrolesById(uam005VoAhmjxuamMstusrrols.getVid());
            if (oldObj != null) {
                uam005VoAhmjxuamMstusrrols.setCreateBy(oldObj.getCreateBy());
                uam005VoAhmjxuamMstusrrols.setCreateDate(oldObj.getCreateDate());
                dtoRespond = uam005Service.update(httpServletRequest, httpServletResponse,
                        uam005VoAhmjxuamMstusrrols, cookieDims, appId);
            } else {
                dtoRespond.setStat(CommonConstant._404);
                dtoRespond.setMsg(CommonConstant._404Msg);
                dtoRespond.setDetailMsg("Data tidak ditemukan");
            }
            return dtoRespond;
        } catch (HibernateOptimisticLockingFailureException holfe) {
            holfe.printStackTrace();
            Uam005VoAhmjxuamMstusrrols temp = uam005Service.getUserrolesById(uam005VoAhmjxuamMstusrrols.getVid());
            if (temp != null) {
                List<Uam005VoAhmjxuamMstusrrols> list = new ArrayList<Uam005VoAhmjxuamMstusrrols>();
                list.add(temp);
                dtoRespond.setRows(list);
            }
            dtoRespond.setStat(CommonConstant._409);
            dtoRespond.setMsg(CommonConstant._409Msg);
//            dtoRespond.setStat("509");            
//            dtoRespond.setMsg("Conflict");
            dtoRespond.setDetailMsg("Update failed data was updated or deleted by another user");
            return dtoRespond;
        } catch (Exception e) {
            e.printStackTrace();
            dtoRespond.setMsg(e.getMessage());
            dtoRespond.setStat(CommonConstant._0);
            return dtoRespond;
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond deleteUserrole(HttpServletRequest httpServletRequest,
            @RequestBody List<Uam005VoAhmjxuamMstusrrols> uam005VoAhmjxuamMstusrrols,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = uam005Service.delete(httpServletRequest, httpServletResponse, uam005VoAhmjxuamMstusrrols, cookieDims, appId);
        return dtoRespond;
    }

    @RequestMapping(value = "paging", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging pagingUserRoles(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {

        DtoRespondPaging respondPaging = uam005Service.pagingUserRoles(httpServletRequest,
                httpServletResponse, dtoParamPaging, cookieDims, appId);
        return respondPaging;
    }

    @RequestMapping(value = "lovuser", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging lovUser(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {
        DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
        dtoRespondPaging = uam005Service.getLovUser(httpServletRequest, httpServletResponse, dtoParamPaging,
                cookieDims, appId);
        return dtoRespondPaging;
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
        dtoRespondPaging = uam005Service.getLovRole(httpServletRequest, httpServletResponse, dtoParamPaging,
                cookieDims, appId);
        return dtoRespondPaging;
    }
}
