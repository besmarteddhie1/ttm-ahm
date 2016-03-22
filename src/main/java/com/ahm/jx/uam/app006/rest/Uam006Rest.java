/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app006.service.Uam006Service;
import com.ahm.jx.uam.app006.vo.Uam006VoAhmjxuamHdrrlaccess;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author george
 */
@Controller
@RequestMapping("/uam006")
public class Uam006Rest {

    private final String appId = "AHMJXUAM006";
    @Autowired
    @Qualifier("uam006Service")
    private Uam006Service uam006Service;

    @RequestMapping(value = "insert", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond insertRoleAccess(HttpServletRequest httpServletRequest,
            @RequestBody Uam006VoAhmjxuamHdrrlaccess uam006VoAhmjxuamMstusrrols,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            dtoRespond = uam006Service.insertRoleAccess(httpServletRequest, httpServletResponse,
                    uam006VoAhmjxuamMstusrrols, cookieDims, appId);
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

    @RequestMapping(value = "delete", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond deleteRoleAccess(HttpServletRequest httpServletRequest,
            @RequestBody List<Uam006VoAhmjxuamHdrrlaccess> uam006VoAhmjxuamMstusrrols,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond;
        dtoRespond = uam006Service.delete(httpServletRequest, httpServletResponse, uam006VoAhmjxuamMstusrrols, cookieDims, appId);
        return dtoRespond;
    }

    @RequestMapping(value = "paging", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging pagingRoleAccess(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {

        DtoRespondPaging respondPaging = uam006Service.pagingRoleAccess(httpServletRequest,
                httpServletResponse, dtoParamPaging, cookieDims, appId);
        return respondPaging;
    }

    @RequestMapping(value = "lovmenu", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging lovMenu(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = uam006Service.getLovMenu(httpServletRequest, httpServletResponse, dtoParamPaging,
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
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = uam006Service.getLovRole(httpServletRequest, httpServletResponse, dtoParamPaging,
                cookieDims, appId);
        return dtoRespondPaging;
    }
}
