/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.service.impl;

import com.ahm.jx.app000.dao.AhmjxuamHdrrlaccessDao;
import com.ahm.jx.app000.model.AhmjxuamHdrrlaccess;
import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.app000.vo.VoAhmjxuamMstusers;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app006.service.Uam006Service;
import com.ahm.jx.uam.app006.vo.Uam006VoAhmjxuamHdrrlaccess;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ahm.jx.uam.app006.dao.Uam006AhmjxuamHdrrlaccessDao;
import com.ahm.jx.uam.app006.dao.Uam006AhmjxuamMstmenuDao;
import com.ahm.jx.uam.app006.dao.Uam006AhmjxuamMstrolesDao;

/**
 *
 * @author george
 */
@Service("uam006Service")
@Transactional(readOnly = true)
public class Uam006ServiceImpl implements Uam006Service {

    @Autowired
    @Qualifier("uam006AhmjxuamHdrrlaccessDao")
    private Uam006AhmjxuamHdrrlaccessDao uam006AhmjxuamHdrrlaccessDao;
    @Autowired
    @Qualifier("ahmjxuamHdrrlaccessDao")
    private AhmjxuamHdrrlaccessDao ahmjxuamHdrrlaccessDao;
    @Autowired
    @Qualifier("uam006AhmjxuamMstmenuDao")
    private Uam006AhmjxuamMstmenuDao uam006AhmjxuamMstmenuDao;
    @Autowired
    @Qualifier("uam006AhmjxuamMstrolesDao")
    private Uam006AhmjxuamMstrolesDao uam006AhmjxuamMstrolesDao;
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    public int getPagingCountAhmjxuamHdrrlaccess(Map<String, Object> filters) {
        return uam006AhmjxuamHdrrlaccessDao.getPagingCountAhmjxuamHdrrlaccess(filters);
    }

    public List<Uam006VoAhmjxuamHdrrlaccess> getPagingDataAhmjxuamHdrrlaccess(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam006AhmjxuamHdrrlaccessDao.getPagingDataAhmjxuamHdrrlaccess(first, pageSize, sortField, sortOrder, filters);
    }

    public int getPagingCountAhmjxuamMstusers(Map<String, Object> filters) {
        return uam006AhmjxuamMstmenuDao.getPagingCountAhmsuamMstmenus(filters);
    }

    public List<VoAhmjxuamMstmenus> getPagingDataAhmjxuamMstmenus(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam006AhmjxuamMstmenuDao.getPagingDataAhmdsh1cMstmenus(first, pageSize, sortField, sortOrder, filters);
    }

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters) {
        return uam006AhmjxuamMstrolesDao.getPagingCountAhmjxuamMstroles(filters);

    }

    public List<VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam006AhmjxuamMstrolesDao.getPagingDataAhmjxuamMstroles(first, pageSize, sortField, sortOrder, filters);
    }

    @Transactional(readOnly = false)
    public DtoRespond insertRoleAccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam006VoAhmjxuamHdrrlaccess uam006VoAhmjxuamHdrrlaccess, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            String parent = uam006AhmjxuamMstmenuDao.getParentId(uam006VoAhmjxuamHdrrlaccess.getVidAhmjxuamMstmenus());

            while (parent != null) {
                if (!uam006AhmjxuamMstmenuDao.isParentExist(parent, uam006VoAhmjxuamHdrrlaccess.getVidAhmjxuamMstroles())) {
                    AhmjxuamHdrrlaccess parentMenu = new AhmjxuamHdrrlaccess();
                    parentMenu.setVidAhmjxuamMstroles(uam006VoAhmjxuamHdrrlaccess.getVidAhmjxuamMstroles());
                    parentMenu.setVidAhmjxuamMstmenus(parent);
                    ahmjxuamHdrrlaccessDao.save(parentMenu, username);
                }
                parent = uam006AhmjxuamMstmenuDao.getParentId(parent);
            }

            AhmjxuamHdrrlaccess ahmjxuamHdrrlaccess = new AhmjxuamHdrrlaccess();
            ahmjxuamHdrrlaccess.setVidAhmjxuamMstroles(uam006VoAhmjxuamHdrrlaccess.getVidAhmjxuamMstroles());
            ahmjxuamHdrrlaccess.setVidAhmjxuamMstmenus(uam006VoAhmjxuamHdrrlaccess.getVidAhmjxuamMstmenus());
            ahmjxuamHdrrlaccessDao.save(ahmjxuamHdrrlaccess, username);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setDetailMsg("Role Access berhasil di-assign");
            return dtoRespond;
        }
        return dtoRespond;
    }

    @Transactional(readOnly = false)
    public DtoRespond delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam006VoAhmjxuamHdrrlaccess> uam006VoAhmjxuamHdrrlaccess, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            for (Uam006VoAhmjxuamHdrrlaccess uam006VoAhmjxuamMstusrrol : uam006VoAhmjxuamHdrrlaccess) {
                try {
                    AhmjxuamHdrrlaccess ahmjxuamHdrrlaccess = ahmjxuamHdrrlaccessDao.get(uam006VoAhmjxuamMstusrrol.getVid());
                    if (ahmjxuamHdrrlaccess != null) {
                        String parent = uam006AhmjxuamMstmenuDao.getParentId(ahmjxuamHdrrlaccess.getVidAhmjxuamMstmenus());
                        String role = ahmjxuamHdrrlaccess.getVidAhmjxuamMstroles();
                        String vid = uam006VoAhmjxuamMstusrrol.getVid();
                        while (true) {
                            if (parent == null) {
                                ahmjxuamHdrrlaccessDao.delete(vid);
                                break;
                            }
                            if (uam006AhmjxuamHdrrlaccessDao.isHasNeighbour(vid, role, parent)) {
                                ahmjxuamHdrrlaccessDao.delete(vid);
                                parent = null;
                            } else {
                                ahmjxuamHdrrlaccess = uam006AhmjxuamHdrrlaccessDao.getParentRoleAccess(role, parent);
                                ahmjxuamHdrrlaccessDao.delete(vid);
                                if (ahmjxuamHdrrlaccess != null) {
                                    parent = uam006AhmjxuamMstmenuDao.getParentId(ahmjxuamHdrrlaccess.getVidAhmjxuamMstmenus());
                                    role = ahmjxuamHdrrlaccess.getVidAhmjxuamMstroles();
                                    vid = ahmjxuamHdrrlaccess.getVid();
                                }
                            }
                        }
                    }
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

    public DtoRespondPaging pagingRoleAccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            int count = getPagingCountAhmjxuamHdrrlaccess(dtoParamPaging.getSearch());
            List<Uam006VoAhmjxuamHdrrlaccess> listData = getPagingDataAhmjxuamHdrrlaccess(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(), dtoParamPaging.getOrder(),
                    dtoParamPaging.getSearch());
            dtoRespondPaging.setRows(listData);
            dtoRespondPaging.setTotal(count);
        }
        return dtoRespondPaging;
    }

    public DtoRespondPaging getLovMenu(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            dtoRespondPaging.setTotal(getPagingCountAhmjxuamMstusers(dtoParamPaging.getSearch()));
            dtoRespondPaging.setRows(getPagingDataAhmjxuamMstmenus(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(),
                    dtoParamPaging.getOrder(), dtoParamPaging.getSearch()));
        }
        return dtoRespondPaging;
    }

    public DtoRespondPaging getLovRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
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
}
