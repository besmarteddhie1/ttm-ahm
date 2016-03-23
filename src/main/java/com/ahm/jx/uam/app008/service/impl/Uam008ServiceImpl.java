/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app008.service.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstappsDao;
import com.ahm.jx.app000.model.AhmjxuamMstapps;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app008.dao.Uam008AhmjxuamMstappsDao;
import com.ahm.jx.uam.app008.service.Uam008Service;
import com.ahm.jx.uam.app008.util.Uam008Util;
import com.ahm.jx.uam.app008.vo.Uam008VoAhmjxuamMstapps;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sigit
 */
@Service("uam008Service")
@Transactional(readOnly = false)
public class Uam008ServiceImpl implements Uam008Service {

    @Autowired
    @Qualifier("uam008AhmjxuamMstappsDao")
    private Uam008AhmjxuamMstappsDao uam008AhmjxuamMstappsDao;

    @Autowired
    @Qualifier("ahmjxuamMstappsDao")
    private AhmjxuamMstappsDao ahmjxuamMstappsDao;

    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    @Override
    public int getPagingCountAhmjxuamMstapps(Map<String, Object> filters) {
        return uam008AhmjxuamMstappsDao.getPagingCountAhmjxuamMstapps(filters);
    }

    @Override
    public List<Uam008VoAhmjxuamMstapps> getPagingDataAhmjxuamMstapps(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam008AhmjxuamMstappsDao.getPagingDataAhmjxuamMstapps(first, pageSize, sortField, sortOrder, filters);
    }

    @Override
    public DtoRespond disableState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam008VoAhmjxuamMstapps> list, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();

        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            for (Uam008VoAhmjxuamMstapps uam008VoAhmjxuamMstapps : list) {
                String id = uam008VoAhmjxuamMstapps.getVid();

                System.out.println("VID UPdate " + id);

                AhmjxuamMstapps ahmjxuamMstapps = ahmjxuamMstappsDao.get(id);
                ahmjxuamMstapps.setVstat("F");

                ahmjxuamMstappsDao.update(ahmjxuamMstapps, username);
            }
            dtoRespond.setDetailMsg("Service telah dinonaktifkan");
        }

        return dtoRespond;
    }

    @Override
    public DtoRespondPaging pagingApps(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging,
            String token, String appId) {
        DtoRespondPaging dtoRespondPaging;

        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse, token, appId);

        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            int count = getPagingCountAhmjxuamMstapps(dtoParamPaging.getSearch());
            List<Uam008VoAhmjxuamMstapps> listData = getPagingDataAhmjxuamMstapps(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(), dtoParamPaging.getOrder(),
                    dtoParamPaging.getSearch());
            dtoRespondPaging.setRows(listData);
            dtoRespondPaging.setTotal(count);
        }

        return dtoRespondPaging;
    }

    @Override
    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam008VoAhmjxuamMstapps uam008VoAhmjxuamMstapps, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();

        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            AhmjxuamMstapps ahmjxuamMstapps = new AhmjxuamMstapps();
            ahmjxuamMstapps.setVid(uam008VoAhmjxuamMstapps.getVid());
            ahmjxuamMstapps.setVname(uam008VoAhmjxuamMstapps.getVname());
            ahmjxuamMstapps.setVdesc(uam008VoAhmjxuamMstapps.getVdesc());
            ahmjxuamMstapps.setVstat("T");

            uam008AhmjxuamMstappsDao.save(ahmjxuamMstapps, username);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setDetailMsg("Penambahan Apps berhasil!");
            return dtoRespond;
        }

        return dtoRespond;
    }

    @Override
    public DtoRespond update(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Uam008VoAhmjxuamMstapps uam008VoAhmjxuamMstapps,
            String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();

        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            AhmjxuamMstapps ahmjxuamMstapps = new AhmjxuamMstapps();

            System.out.println("------> uam008VoAhmjxuamMstapps.getVstat(): " + uam008VoAhmjxuamMstapps.getVstat());

            ahmjxuamMstapps.setVid(uam008VoAhmjxuamMstapps.getVid());
            ahmjxuamMstapps.setIver(uam008VoAhmjxuamMstapps.getIver());
            ahmjxuamMstapps.setCreateBy(uam008VoAhmjxuamMstapps.getVcrea());
            ahmjxuamMstapps.setCreateDate(uam008VoAhmjxuamMstapps.getDcrea());
            ahmjxuamMstapps.setVname(uam008VoAhmjxuamMstapps.getVname());
            ahmjxuamMstapps.setVdesc(uam008VoAhmjxuamMstapps.getVdesc());
            ahmjxuamMstapps.setVstat(Uam008Util.convertStatus(uam008VoAhmjxuamMstapps.getVstat()));

            System.out.println("------> ahmjxuamMstapps.getVid(): " + ahmjxuamMstapps.getVid());
            System.out.println("------> ahmjxuamMstapps.getIver(): " + ahmjxuamMstapps.getIver());
            System.out.println("------> ahmjxuamMstapps.getCreateBy(): " + ahmjxuamMstapps.getCreateBy());
            System.out.println("------> ahmjxuamMstapps.getCreateDate(): " + ahmjxuamMstapps.getCreateDate());
            System.out.println("------> ahmjxuamMstapps.getVname(): " + ahmjxuamMstapps.getVname());
            System.out.println("------> ahmjxuamMstapps.getVdesc(): " + ahmjxuamMstapps.getVdesc());
            System.out.println("------> ahmjxuamMstapps.getVstat(): " + ahmjxuamMstapps.getVstat());

            uam008AhmjxuamMstappsDao.update(ahmjxuamMstapps, username);

            System.out.println("------> End of update");

        }

        return dtoRespond;
    }

    @Override
    public Uam008VoAhmjxuamMstapps getAppsById(String vid) {
        AhmjxuamMstapps ahmjxuamMstapps = ahmjxuamMstappsDao.get(vid);

        Uam008VoAhmjxuamMstapps uam008VoAhmjxuamMstapps = null;
        if (ahmjxuamMstapps != null) {
            uam008VoAhmjxuamMstapps = new Uam008VoAhmjxuamMstapps();
            uam008VoAhmjxuamMstapps.setVid(vid);
            uam008VoAhmjxuamMstapps.setVname(ahmjxuamMstapps.getVname());
            uam008VoAhmjxuamMstapps.setVdesc(ahmjxuamMstapps.getVdesc());
            uam008VoAhmjxuamMstapps.setVcrea(ahmjxuamMstapps.getCreateBy());
            uam008VoAhmjxuamMstapps.setDcrea(ahmjxuamMstapps.getCreateDate());
            uam008VoAhmjxuamMstapps.setVstat(Uam008Util.convertStatus(ahmjxuamMstapps.getVstat()));
            uam008VoAhmjxuamMstapps.setIver(ahmjxuamMstapps.getIver());
        }
        return uam008VoAhmjxuamMstapps;

    }

}
