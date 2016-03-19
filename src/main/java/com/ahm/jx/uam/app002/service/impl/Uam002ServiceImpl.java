/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app002.service.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstrolesDao;
import com.ahm.jx.app000.model.AhmjxuamMstroles;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app002.vo.Uam002VoAhmjxuamMstroles;
import com.ahm.jx.uam.app002.util.Uam002Util;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ahm.jx.uam.app002.service.Uam002Service;
import com.ahm.jx.uam.app002.dao.Uam002AhmjxuamMstrolesDao;

/**
 *
 * @author indriHtb
 */
@Service("uam002Service")
@Transactional(readOnly = true)
public class Uam002ServiceImpl implements Uam002Service {

    @Autowired
    @Qualifier("uam002AhmjxuamMstrolesDao")
    private Uam002AhmjxuamMstrolesDao uam002AhmjxuamMstrolesDao;

    @Autowired
    @Qualifier("ahmjxuamMstrolesDao")
    private AhmjxuamMstrolesDao ahmjxuamMstrolesDao;

    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    @Override
    @Transactional(readOnly = false)
    public DtoRespond disableRoleState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam002VoAhmjxuamMstroles> list, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            for (Uam002VoAhmjxuamMstroles uam002VoAhmjxuamMstroles : list) {
                String id = uam002VoAhmjxuamMstroles.getVid();

                System.out.println("VID UPdate " + id);

                AhmjxuamMstroles ahmjxuamMstroles = ahmjxuamMstrolesDao.get(id);
                ahmjxuamMstroles.setVrolesStatus("F");

                ahmjxuamMstrolesDao.update(ahmjxuamMstroles, username);
            }
            dtoRespond.setDetailMsg("Role telah dinonaktifkan");
        }
        return dtoRespond;
    }

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters) {
        return uam002AhmjxuamMstrolesDao.getPagingCountAhmjxuamMstroles(filters);
    }

    public List<Uam002VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam002AhmjxuamMstrolesDao.getPagingDataAhmjxuamMstroles(first, pageSize, sortField, sortOrder, filters);
    }

    public DtoRespondPaging pagingRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            int count = getPagingCountAhmjxuamMstroles(dtoParamPaging.getSearch());
            List<Uam002VoAhmjxuamMstroles> listData = getPagingDataAhmjxuamMstroles(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(), dtoParamPaging.getOrder(),
                    dtoParamPaging.getSearch());
            dtoRespondPaging.setRows(listData);
            dtoRespondPaging.setTotal(count);
        }
        return dtoRespondPaging;
    }

    @Transactional(readOnly = false)
    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam002VoAhmjxuamMstroles uam002VoAhmjxuamMstroles, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            AhmjxuamMstroles ahmjxuamMstroles = new AhmjxuamMstroles();
            ahmjxuamMstroles.setVrolesId(uam002VoAhmjxuamMstroles.getVrolesId());
            ahmjxuamMstroles.setVrolesName(uam002VoAhmjxuamMstroles.getVrolesName());
            ahmjxuamMstroles.setVrolesDesc(uam002VoAhmjxuamMstroles.getVrolesDesc());
            ahmjxuamMstroles.setVrolesStatus("T");
            uam002AhmjxuamMstrolesDao.save(ahmjxuamMstroles, username);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setDetailMsg("Penambahan role berhasil");
            return dtoRespond;
        }
        return dtoRespond;
    }

    @Transactional(readOnly = false)
    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam002VoAhmjxuamMstroles uam002VoAhmjxuamMstroles, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            AhmjxuamMstroles ahmjxuamMstroles = new AhmjxuamMstroles();
            ahmjxuamMstroles.setCreateBy(uam002VoAhmjxuamMstroles.getVcrea());
            ahmjxuamMstroles.setCreateDate(uam002VoAhmjxuamMstroles.getDcrea());
            ahmjxuamMstroles.setVid(uam002VoAhmjxuamMstroles.getVid());
            ahmjxuamMstroles.setIver(uam002VoAhmjxuamMstroles.getIver());
            ahmjxuamMstroles.setVrolesId(uam002VoAhmjxuamMstroles.getVrolesId());
            ahmjxuamMstroles.setVrolesName(uam002VoAhmjxuamMstroles.getVrolesName());
            ahmjxuamMstroles.setVrolesDesc(uam002VoAhmjxuamMstroles.getVrolesDesc());
            //ahmdsuamMstroles.setVrolesStatus(uam003VoAhmdsuamMstroles.getvrolesStatus());
            ahmjxuamMstroles.setVrolesStatus(Uam002Util.convertStatus(uam002VoAhmjxuamMstroles.getVrolesStatus()));
            uam002AhmjxuamMstrolesDao.update(ahmjxuamMstroles, username);

            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setDetailMsg("Update berhasil");
        }
        return dtoRespond;
    }

    public Uam002AhmjxuamMstrolesDao getUam002AhmjxuamMstrolesDao() {
        return uam002AhmjxuamMstrolesDao;
    }

    public void setUam002AhmjxuamMstrolesDao(Uam002AhmjxuamMstrolesDao uam002AhmjxuamMstrolesDao) {
        this.uam002AhmjxuamMstrolesDao = uam002AhmjxuamMstrolesDao;
    }

    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public AhmjxuamMstrolesDao getAhmjxuamMstrolesDao() {
        return ahmjxuamMstrolesDao;
    }

    public void setAhmjxuamMstrolesDao(AhmjxuamMstrolesDao ahmjxuamMstrolesDao) {
        this.ahmjxuamMstrolesDao = ahmjxuamMstrolesDao;
    }

    public Uam002VoAhmjxuamMstroles getRoleById(String vid) {
        AhmjxuamMstroles ahmjxuamMstroles = ahmjxuamMstrolesDao.get(vid);
        Uam002VoAhmjxuamMstroles vo = null;
        if (ahmjxuamMstroles != null) {
            vo = new Uam002VoAhmjxuamMstroles();
            vo.setVid(ahmjxuamMstroles.getVid());
            vo.setIver(ahmjxuamMstroles.getIver());
            vo.setVcrea(ahmjxuamMstroles.getCreateBy());
            vo.setDcrea(ahmjxuamMstroles.getCreateDate());
            vo.setVrolesDesc(ahmjxuamMstroles.getVrolesDesc());
            vo.setVrolesId(ahmjxuamMstroles.getVrolesId());
            vo.setVrolesName(ahmjxuamMstroles.getVrolesName());
            vo.setVrolesStatus(Uam002Util.convertStatus(ahmjxuamMstroles.getVrolesStatus()));
        }
        return vo;
    }
}
