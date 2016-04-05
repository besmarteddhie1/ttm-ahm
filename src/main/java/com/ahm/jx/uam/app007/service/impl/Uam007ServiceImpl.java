/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app007.service.impl;

import com.ahm.jx.app000.dao.AhmjxuamHdrrlaccessDao;
import com.ahm.jx.app000.dao.AhmjxuamMstsvcrolsDao;
import com.ahm.jx.app000.dao.AhmjxuamMstusrrolsDao;
import com.ahm.jx.app000.model.AhmjxuamMstsvcrols;
import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.app000.vo.VoAhmjxuamMstservices;
import com.ahm.jx.app000.vo.VoAhmjxuamMstusers;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.rest.DashboardRest;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app007.dao.Uam007AhmjxuamMstrolesDao;
import com.ahm.jx.uam.app007.dao.Uam007AhmjxuamMstsvcrolsDao;
import com.ahm.jx.uam.app007.dao.Uam007AhmjxuamMstsvcsDao;
import com.ahm.jx.uam.app007.service.Uam007Service;
import com.ahm.jx.uam.app007.vo.Uam007VoAhmjxuamMstsvcrols;
//import com.ahm.jx.uam.app005.util.Uam005Util;
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


/**
 *
 * @author Ferdy
 */
@Service("uam007Service")
@Transactional(readOnly = true)
public class Uam007ServiceImpl implements Uam007Service {

    
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;
    
    @Autowired
    @Qualifier("ahmjxuamMstsvcrolsDao")
    private AhmjxuamMstsvcrolsDao ahmjxuamMstsvcrolsDao;
    
    @Autowired
    @Qualifier("uam007AhmjxuamMstsvcrolsDao")
    private Uam007AhmjxuamMstsvcrolsDao uam007AhmjxuamMstsvcrolsDao;
    
    @Autowired
    @Qualifier("uam007AhmjxuamMstrolesDao")
    private Uam007AhmjxuamMstrolesDao uam007AhmjxuamMstrolesDao;
    
    @Autowired
    @Qualifier("uam007AhmjxuamMstsvcsDao")
    private Uam007AhmjxuamMstsvcsDao uam007AhmjxuamMstsvcsDao;

//    public Uam007VoAhmjxuamMstsvcrols getSvcrolesById(String vid) {
//        return uam007AhmjxuamMstsvcrolsDao.getSvcRoleById(vid);
//    }

    public int getPagingCountAhmjxuamMstsvcRols(Map<String, Object> filters) {
        return uam007AhmjxuamMstsvcrolsDao.getPagingCountAhmjxuamMstsvcrols(filters);
    }

    public List<Uam007VoAhmjxuamMstsvcrols> getPagingDataAhmjxuamMstsvcrols(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam007AhmjxuamMstsvcrolsDao.getPagingDataAhmjxuamMstsvcrols(first, pageSize, sortField, sortOrder, filters);
    }

    public int getPagingCountAhmjxuamMstsvcs(Map<String, Object> filters) {
        return uam007AhmjxuamMstsvcsDao.getPagingCountAhmjxuamMstsvcs(filters);
    }

    public List<VoAhmjxuamMstservices> getPagingDataAhmjxuamMstsvcs(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam007AhmjxuamMstsvcsDao.getPagingDataAhmjxuamMstsvcs(first, pageSize, sortField, sortOrder, filters);
    }

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters) {
        return uam007AhmjxuamMstrolesDao.getPagingCountAhmjxuamMstroles(filters);

    }

    public List<VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam007AhmjxuamMstrolesDao.getPagingDataAhmjxuamMstroles(first, pageSize, sortField, sortOrder, filters);
    }

    public DtoRespondPaging pagingSvcRoles(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            int count = getPagingCountAhmjxuamMstsvcRols(dtoParamPaging.getSearch());
            List<Uam007VoAhmjxuamMstsvcrols> listData = getPagingDataAhmjxuamMstsvcrols(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(), dtoParamPaging.getOrder(),
                    dtoParamPaging.getSearch());
            dtoRespondPaging.setRows(listData);
            dtoRespondPaging.setTotal(count);
        }
        return dtoRespondPaging;
    }

    public DtoRespondPaging getLovSvc(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            dtoRespondPaging.setTotal(getPagingCountAhmjxuamMstsvcRols(dtoParamPaging.getSearch()));
            dtoRespondPaging.setRows(getPagingDataAhmjxuamMstsvcrols(dtoParamPaging.getOffset(),
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
    public DtoRespond insertSvcRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam007VoAhmjxuamMstsvcrols uam007VoAhmjxuamMstsvcrols, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            AhmjxuamMstsvcrols ahmjxuamMstsvcrols = new AhmjxuamMstsvcrols();
            ahmjxuamMstsvcrols.setVid(uam007VoAhmjxuamMstsvcrols.getVid());
            ahmjxuamMstsvcrols.setIver(uam007VoAhmjxuamMstsvcrols.getIver());
            ahmjxuamMstsvcrols.setVidAhmjxuamMstroles(uam007VoAhmjxuamMstsvcrols.getVidAhmjxuamMstroles());
            ahmjxuamMstsvcrols.setVidAhmjxuamMstservices(uam007VoAhmjxuamMstsvcrols.getVidAhmjxuamMstservices());
//            ahmjxuamMstusrrols.setVstatus("T");
            ahmjxuamMstsvcrolsDao.save(ahmjxuamMstsvcrols, username);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setDetailMsg("User role berhasil ditambahkan");
            return dtoRespond;
        }
        return dtoRespond;
    }

    @Transactional(readOnly = false)
    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam007VoAhmjxuamMstsvcrols uam007VoAhmjxuamMstsvcrols, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        try {
            if (dtoRespond.getStat().equals(CommonConstant._200)) {
                AhmjxuamMstsvcrols ahmjxuamMstsvcrols = new AhmjxuamMstsvcrols();
                ahmjxuamMstsvcrols.setVid(uam007VoAhmjxuamMstsvcrols.getVid());
                ahmjxuamMstsvcrols.setCreateBy(uam007VoAhmjxuamMstsvcrols.getCreateBy());
                ahmjxuamMstsvcrols.setCreateDate(uam007VoAhmjxuamMstsvcrols.getCreateDate());
                ahmjxuamMstsvcrols.setIver(uam007VoAhmjxuamMstsvcrols.getIver());
                ahmjxuamMstsvcrols.setVidAhmjxuamMstroles(uam007VoAhmjxuamMstsvcrols.getVidAhmjxuamMstroles());
                ahmjxuamMstsvcrols.setVidAhmjxuamMstservices(uam007VoAhmjxuamMstsvcrols.getVidAhmjxuamMstservices());
                ahmjxuamMstsvcrolsDao.update(ahmjxuamMstsvcrols, username);
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
    public DtoRespond delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam007VoAhmjxuamMstsvcrols> uam007VoAhmjxuamMstsvcrols, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            for (Uam007VoAhmjxuamMstsvcrols uam007VoAhmjxuamMstsvcrol : uam007VoAhmjxuamMstsvcrols) {
                try {
                	ahmjxuamMstsvcrolsDao.delete(uam007VoAhmjxuamMstsvcrol.getVid());
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

    public Uam007AhmjxuamMstsvcrolsDao getUam007AhmjxuamMstsvcrolsDao() {
        return uam007AhmjxuamMstsvcrolsDao;
    }

    public void setUam007AhmjxuamMstsvcrolsDao(Uam007AhmjxuamMstsvcrolsDao uam007AhmjxuamMstsvcrolsDao) {
        this.uam007AhmjxuamMstsvcrolsDao = uam007AhmjxuamMstsvcrolsDao;
    }

    public Uam007AhmjxuamMstsvcsDao getH1c005Ahmdsh1cMstusersDao() {
        return uam007AhmjxuamMstsvcsDao;
    }

    public void setUam007AhmjxuamMstsvcsDao(Uam007AhmjxuamMstsvcsDao uam007AhmjxuamMstsvcsDao) {
        this.uam007AhmjxuamMstsvcsDao = uam007AhmjxuamMstsvcsDao;
    }

    public Uam007AhmjxuamMstrolesDao getUam007AhmjxuamMstrolesDao() {
        return uam007AhmjxuamMstrolesDao;
    }

    public void setUam007AhmjxuamMstrolesDao(Uam007AhmjxuamMstrolesDao uam007AhmjxuamMstrolesDao) {
        this.uam007AhmjxuamMstrolesDao = uam007AhmjxuamMstrolesDao;
    }

    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }


}
