/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.service.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstservicesDao;
import com.ahm.jx.app000.model.AhmjxuamMstservices;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app003.dao.Uam003AhmjxuamMstservicesDao;
import com.ahm.jx.uam.app003.service.Uam003Service;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmjxuamMstservice;
import java.util.List;
import java.util.Map;
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
@Service("uam003Service")
@Transactional(readOnly = true)
public class Uam003ServiceImpl implements Uam003Service {

    @Autowired
    @Qualifier("uam003AhmjxuamMstservicesDao")
    private Uam003AhmjxuamMstservicesDao uam003AhmjxuamMstservicesDao;

    @Autowired
    @Qualifier("ahmjxuamMstservicesDao")
    private AhmjxuamMstservicesDao ahmjxuamMstservicesDao;

    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    @Override
    public int getPagingCountAhmjxuamMstservice(Map<String, Object> filters, boolean isLov) {
        return uam003AhmjxuamMstservicesDao.getPagingCountAhmjxuamMstservices(filters, isLov);
    }

    @Override
    public List<Uam003VoAhmjxuamMstservice> getPagingDataAhmjxuamMstservice(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters, boolean isLov) {
        return uam003AhmjxuamMstservicesDao.getPagingDataAhmjxuamMstservices(first, pageSize, sortField, sortOrder, filters, isLov);
    }

    @Override
    public DtoRespond disableState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam003VoAhmjxuamMstservice> list, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();

        return dtoRespond;
    }

    @Override
    public DtoRespondPaging pagingService(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging;

        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse, token, appId);

        return dtoRespondPaging;
    }

    @Override
    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservice, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();

        return dtoRespond;
    }

    @Override
    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservice, String token, String appId, Uam003VoAhmjxuamMstservice oldObj) {
        DtoRespond dtoRespond = new DtoRespond();

        return dtoRespond;
    }

    @Override
    public Uam003VoAhmjxuamMstservice getServiceById(String vid) {
        AhmjxuamMstservices ahmjxuamMstservices = ahmjxuamMstservicesDao.get(vid);

        Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservice = null;

        return uam003VoAhmjxuamMstservice;
    }

}
