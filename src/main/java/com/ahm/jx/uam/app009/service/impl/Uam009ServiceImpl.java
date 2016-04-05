/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app009.service.impl;

import com.ahm.jx.app000.dao.AhmjxuamHdrrlaccessDao;
import com.ahm.jx.app000.model.AhmjxuamHdrrlaccess;
import com.ahm.jx.app000.model.AhmjxuamHstappusgs;
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
import com.ahm.jx.uam.app009.service.Uam009Service;
import com.ahm.jx.uam.app009.vo.Uam009VoAhmjxuamHstappusgs;
import java.sql.Timestamp;
import java.util.Date;
import com.ahm.jx.uam.app009.dao.Uam009AhmjxuamHstappusgsDao;

/**
 *
 * @author ferdy
 */
@Service("uam009Service")
@Transactional(readOnly = true)
public class Uam009ServiceImpl implements Uam009Service {

    @Autowired
    @Qualifier("uam009AhmjxuamHstappusgsDao")
    private Uam009AhmjxuamHstappusgsDao uam009AhmjxuamHstappusgsDao;
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    public DtoRespond listActive(HttpServletRequest httpServletRequest, String token,Integer diff) {
        DtoRespond dtoRespond = new DtoRespond();
        if (validateToken(token, httpServletRequest)) {
            List<Uam009VoAhmjxuamHstappusgs> list = uam009AhmjxuamHstappusgsDao.getActive(diff);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setRows(list);            
        } else {
            dtoRespond.setStat(CommonConstant._401);
            dtoRespond.setMsg(CommonConstant._401Msg);
        }
        return dtoRespond;
    }
    
     public boolean validateToken(String cookieDims,
            HttpServletRequest httpServletRequest) {
        boolean result = false;
        Object obj = httpServletRequest.getSession().getAttribute(CommonConstant.cookieDims);
        Object objTimeOut = httpServletRequest.getSession().getAttribute(CommonConstant.sessionTimeOut);

        if ((obj != null) && (objTimeOut != null)) {
            String sessionId = obj + "";
            if (cookieDims.equals(sessionId)) {
                Date date = (Date) objTimeOut;
                Date now = new Date();
                Timestamp timestampNow = new Timestamp(now.getTime());
                long diffInMiliSecond = Math.abs(timestampNow.getTime() - date.getTime());
                long diffInMinutes = diffInMiliSecond / 1000 / 60;
                if (diffInMinutes < CommonConstant.timeOut) {
                    return true;
                }
            }
        }
        return result;
    }
     
//     public DtoRespondPaging pagingAppsUsage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
//        DtoRespondPaging dtoRespondPaging;
//        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
//                token, appId);
//        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
//            int count = getPagingCount(dtoParamPaging.getSearch());
//            List<Uam009VoAhmjxuamHstappusgs> listData = getPagingData(dtoParamPaging.getOffset(),
//                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(), dtoParamPaging.getOrder(),
//                    dtoParamPaging.getSearch());
//            dtoRespondPaging.setRows(listData);
//            dtoRespondPaging.setTotal(count);
//        }
//        return dtoRespondPaging;
//    }
//     
//     public int getPagingCount(Map<String, Object> filters) {
//        return uam009AhmjxuamHstappusgsDao.getPagingCount(filters);
//    }
//
//    public List<Uam009VoAhmjxuamHstappusgs> getPagingData(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
//        return uam009AhmjxuamHstappusgsDao.getPagingData(first, pageSize, sortField, sortOrder, filters);
//    }
}
