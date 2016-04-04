/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.service.impl;

import com.ahm.jx.app000.model.AhmjxuamMstusrrols;
import com.ahm.jx.app000.vo.VoAhmjxuamMstusers;
import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.rest.DashboardRest;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app005.service.Uam005Service;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmjxuamMstusrrols;
import com.ahm.jx.uam.app005.util.Uam005Util;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ahm.jx.uam.app005.dao.Uam005AhmjxuamMstrolesDao;
import com.ahm.jx.uam.app005.dao.Uam005AhmjxuamMstusersDao;
import com.ahm.jx.uam.app005.dao.Uam005AhmjxuamMstusrrolsDao;

/**
 *
 * @author Fransisca
 */
@Service("uam005Service")
@Transactional(readOnly = true)
public class Uam005ServiceImpl implements Uam005Service {

    @Autowired
    @Qualifier("uam005AhmjxuamMstusrrolsDao")
    private Uam005AhmjxuamMstusrrolsDao uam005AhmjxuamMstusrrolsDao;
    @Autowired
    @Qualifier("uam005AhmjxuamMstusersDao")
    private Uam005AhmjxuamMstusersDao uam005AhmjxuamMstusersDao;
    @Autowired
    @Qualifier("uam005AhmjxuamMstrolesDao")
    private Uam005AhmjxuamMstrolesDao uam005AhmjxuamMstrolesDao;
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    public Uam005VoAhmjxuamMstusrrols getUserrolesById(String vid) {
        return uam005AhmjxuamMstusrrolsDao.getUserRoleById(vid);
    }

    public int getPagingCountAhmjxuamMstusrrols(Map<String, Object> filters) {
        return uam005AhmjxuamMstusrrolsDao.getPagingCountAhmjxuamMstusrrols(filters);
    }

    public List<Uam005VoAhmjxuamMstusrrols> getPagingDataAhmjxuamMstusrrols(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam005AhmjxuamMstusrrolsDao.getPagingDataAhmjxuamMstusrrols(first, pageSize, sortField, sortOrder, filters);
    }

    public int getPagingCountAhmjxuamMstusers(Map<String, Object> filters) {
        return uam005AhmjxuamMstusersDao.getPagingCountAhmsuamMstusers(filters);
    }

    public List<VoAhmjxuamMstusers> getPagingDataAhmjxuamMstusers(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam005AhmjxuamMstusersDao.getPagingDataAhmjxh1cMstusers(first, pageSize, sortField, sortOrder, filters);
    }

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters) {
        return uam005AhmjxuamMstrolesDao.getPagingCountAhmjxuamMstroles(filters);

    }

    public List<VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam005AhmjxuamMstrolesDao.getPagingDataAhmjxuamMstroles(first, pageSize, sortField, sortOrder, filters);
    }

    public DtoRespondPaging pagingUserRoles(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            int count = getPagingCountAhmjxuamMstusrrols(dtoParamPaging.getSearch());
            List<Uam005VoAhmjxuamMstusrrols> listData = getPagingDataAhmjxuamMstusrrols(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(), dtoParamPaging.getOrder(),
                    dtoParamPaging.getSearch());
            dtoRespondPaging.setRows(listData);
            dtoRespondPaging.setTotal(count);
        }
        return dtoRespondPaging;
    }

    public DtoRespondPaging getLovUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            dtoRespondPaging.setTotal(getPagingCountAhmjxuamMstusers(dtoParamPaging.getSearch()));
            dtoRespondPaging.setRows(getPagingDataAhmjxuamMstusers(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(),
                    dtoParamPaging.getOrder(), dtoParamPaging.getSearch()));
        }
        return dtoRespondPaging;
    }

    public DtoRespondPaging getLovRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            dtoRespondPaging.setTotal(getPagingCountAhmjxuamMstroles(dtoParamPaging.getSearch()));
            dtoRespondPaging.setRows(getPagingDataAhmjxuamMstroles(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(),
                    dtoParamPaging.getOrder(), dtoParamPaging.getSearch()));
        }
        return dtoRespondPaging;
    }

    @Transactional(readOnly = false)
    public DtoRespond insertUserRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam005VoAhmjxuamMstusrrols uam005VoAhmjxuamMstusrrols, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            AhmjxuamMstusrrols ahmjxuamMstusrrols = new AhmjxuamMstusrrols();
            ahmjxuamMstusrrols.setVid(uam005VoAhmjxuamMstusrrols.getVid());
            ahmjxuamMstusrrols.setIver(uam005VoAhmjxuamMstusrrols.getIver());
            ahmjxuamMstusrrols.setVidAhmjxuamMstroles(uam005VoAhmjxuamMstusrrols.getVidAhmjxuamMstroles());
            ahmjxuamMstusrrols.setVidAhmjxuamMstusers(uam005VoAhmjxuamMstusrrols.getVidAhmjxuamMstusers());
            ahmjxuamMstusrrols.setVstatus("T");
            uam005AhmjxuamMstusrrolsDao.save(ahmjxuamMstusrrols, username);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setDetailMsg("User role berhasil ditambahkan");
            return dtoRespond;
        }
        return dtoRespond;
    }

    @Transactional(readOnly = false)
    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam005VoAhmjxuamMstusrrols uam005VoAhmjxuamMstusrrols, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        try {
            if (dtoRespond.getStat().equals(CommonConstant._200)) {
                AhmjxuamMstusrrols ahmjxuamMstusrrols = new AhmjxuamMstusrrols();
                ahmjxuamMstusrrols.setVid(uam005VoAhmjxuamMstusrrols.getVid());
                ahmjxuamMstusrrols.setCreateBy(uam005VoAhmjxuamMstusrrols.getCreateBy());
                ahmjxuamMstusrrols.setCreateDate(uam005VoAhmjxuamMstusrrols.getCreateDate());
                ahmjxuamMstusrrols.setIver(uam005VoAhmjxuamMstusrrols.getIver());
                ahmjxuamMstusrrols.setVidAhmjxuamMstroles(uam005VoAhmjxuamMstusrrols.getVidAhmjxuamMstroles());
                ahmjxuamMstusrrols.setVidAhmjxuamMstusers(uam005VoAhmjxuamMstusrrols.getVidAhmjxuamMstusers());
                ahmjxuamMstusrrols.setVstatus(Uam005Util.convertStatus(uam005VoAhmjxuamMstusrrols.getVstatus()));
                uam005AhmjxuamMstusrrolsDao.update(ahmjxuamMstusrrols, username);
                dtoRespond.setStat(CommonConstant._200);
                dtoRespond.setMsg(CommonConstant._200Msg);
                dtoRespond.setDetailMsg("Update berhasil");

            }
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return dtoRespond;
    }

    @Transactional(readOnly = false)
    public DtoRespond delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam005VoAhmjxuamMstusrrols> uam005VoAhmjxuamMstusrrols, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            for (Uam005VoAhmjxuamMstusrrols uam005VoAhmjxuamMstusrrol : uam005VoAhmjxuamMstusrrols) {
                try {
                    uam005AhmjxuamMstusrrolsDao.delete(uam005VoAhmjxuamMstusrrol.getVid());
                    dtoRespond.setDetailMsg("User role berhasil dihapus");
                } catch (Exception e) {
                    e.printStackTrace();
                    dtoRespond.setStat(CommonConstant._500);
                    dtoRespond.setMsg(CommonConstant._500Msg);
                    dtoRespond.setDetailMsg(e.getMessage());
                    break;
                }
            }
        }
        return dtoRespond;
    }

    public Uam005AhmjxuamMstusrrolsDao getUam005AhmjxuamMstusrrolsDao() {
        return uam005AhmjxuamMstusrrolsDao;
    }

    public void setUam005AhmjxuamMstusrrolsDao(Uam005AhmjxuamMstusrrolsDao uam005AhmjxuamMstusrrolsDao) {
        this.uam005AhmjxuamMstusrrolsDao = uam005AhmjxuamMstusrrolsDao;
    }

    public Uam005AhmjxuamMstusersDao getH1c005Ahmdsh1cMstusersDao() {
        return uam005AhmjxuamMstusersDao;
    }

    public void setH1c005Ahmdsh1cMstusersDao(Uam005AhmjxuamMstusersDao h1c005Ahmdsh1cMstusersDao) {
        this.uam005AhmjxuamMstusersDao = h1c005Ahmdsh1cMstusersDao;
    }

    public Uam005AhmjxuamMstrolesDao getH1c005Ahmdsh1cMstrolesDao() {
        return uam005AhmjxuamMstrolesDao;
    }

    public void setH1c005Ahmdsh1cMstrolesDao(Uam005AhmjxuamMstrolesDao h1c005Ahmdsh1cMstrolesDao) {
        this.uam005AhmjxuamMstrolesDao = h1c005Ahmdsh1cMstrolesDao;
    }

    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }
}
