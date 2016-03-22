package com.ahm.jx.uam.app004.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.uam.app004.service.Uam004Service;
import com.ahm.jx.uam.app004.vo.Uam004VoAhmjxuamMstmenus;
import com.ahm.jx.common.util.AhmStringUtil;
//import com.ahm.jx.h1c.app004.vo.H1c004VoAhmdsh1cHdrunitinvmd;
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
 * @author Elisa
 */
@Controller
@RequestMapping("/uam004")
public class Uam004Rest {

    private final String appId = "AHMJXUAM004";
    @Autowired
    @Qualifier("uam004Service")
    private Uam004Service uam004Service;
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    @RequestMapping(value = "geticon", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond getIcon(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = uam004Service
                .getListIcon(httpServletRequest, httpServletResponse,
                        cookieDims, appId);
        return dtoRespond;
    }

    public Uam004Service getUam004Service() {
        return uam004Service;
    }

    public void setUam004Service(Uam004Service uam004Service) {
        this.uam004Service = uam004Service;
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
    DtoRespondPaging pagingMenu(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {
        DtoRespondPaging respondPaging = uam004Service.pagingMenu(httpServletRequest,
                httpServletResponse, dtoParamPaging, cookieDims, appId);
        return respondPaging;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond insertMenu(HttpServletRequest httpServletRequest,
            @RequestBody Uam004VoAhmjxuamMstmenus uam004VoAhmjxuamMstmenus,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            dtoRespond = uam004Service.insert(httpServletRequest, httpServletResponse,
                    uam004VoAhmjxuamMstmenus, cookieDims, appId);
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
            @RequestBody Uam004VoAhmjxuamMstmenus uam004VoAhmjxuamMstmenus,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            Uam004VoAhmjxuamMstmenus oldObj = uam004Service.getMenuById(uam004VoAhmjxuamMstmenus.getVid());
            if (oldObj != null) {
                dtoRespond = uam004Service.update(httpServletRequest, httpServletResponse,
                        uam004VoAhmjxuamMstmenus, cookieDims, appId, oldObj);
            } else {
                dtoRespond.setStat(CommonConstant._404);
                dtoRespond.setMsg(CommonConstant._404Msg);
            }
            return dtoRespond;
        } catch (HibernateOptimisticLockingFailureException holfe) {
            holfe.printStackTrace();
            Uam004VoAhmjxuamMstmenus temp = uam004Service.getMenuById(uam004VoAhmjxuamMstmenus.getVid());
            if (temp != null) {
                List<Uam004VoAhmjxuamMstmenus> list = new ArrayList<Uam004VoAhmjxuamMstmenus>();
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
            @RequestBody List<Uam004VoAhmjxuamMstmenus> uam004VoAhmjxuamMstmenus,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try {
            dtoRespond = uam004Service.disableState(httpServletRequest, httpServletResponse,
                    uam004VoAhmjxuamMstmenus, cookieDims, appId);
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

    @RequestMapping(value = "getLovParent", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging getlovParent(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {
        DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
        dtoRespondPaging = uam004Service.getLovParent(httpServletRequest, httpServletResponse, dtoParamPaging, cookieDims, appId);
        return dtoRespondPaging;
    }
}
