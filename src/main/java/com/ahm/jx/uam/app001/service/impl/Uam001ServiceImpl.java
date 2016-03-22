/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app001.service.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstusersDao;
import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app001.util.Uam001Util;
import com.ahm.jx.uam.app001.vo.Uam001VoAhmjxuamMstuser;
import com.ahm.jx.uam.app001.vo.Uam001Vodlr;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.twmacinta.util.MD5;
import com.ahm.jx.uam.app001.dao.Uam001AhmjxuamMstpartnerDao;
import com.ahm.jx.uam.app001.dao.Uam001AhmjxuamMstuserDao;
import com.ahm.jx.uam.app001.service.Uam001Service;

/**
 *
 * @author lexys.jo
 */
@Service("uam001Service")
@Transactional(readOnly = true)
public class Uam001ServiceImpl implements Uam001Service {

//    @Autowired
//    @Qualifier("ahmdsbscDtlsettingDao")
//    private AhmdsbscDtlsettingDao ahmdsbscDtlsettingDao;
    @Autowired
    @Qualifier("uam001AhmjxuamMstuserDao")
    private Uam001AhmjxuamMstuserDao uam001AhmjxuamMstuserDao;
    @Autowired
    @Qualifier("ahmjxuamMstusersDao")
    private AhmjxuamMstusersDao ahmjxuamMstusersDao;
    @Autowired
    @Qualifier("uam001AhmjxuamMstpartnerDao")
    private Uam001AhmjxuamMstpartnerDao uam001AhmjxuamMstpartnerDao;
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

//    public Uam002VoAhmdsuamMstuser getUserById(String vid) {
//        return uam002AhmdsuamMstuserDao.getUserById(vid);
//    }
    public int getPagingCountAhmjxuamMstuser(Map<String, Object> filters) {
        return uam001AhmjxuamMstuserDao.getPagingCountAhmjxuamMstuser(filters);
    }

    public List<Uam001VoAhmjxuamMstuser> getPagingDataAhmjxuamMstuser(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam001AhmjxuamMstuserDao.getPagingDataAhmjxuamMstuser(first, pageSize, sortField, sortOrder, filters);
    }

    public DtoRespondPaging pagingUser(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging,
            String token, String appId) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            int count = getPagingCountAhmjxuamMstuser(dtoParamPaging.getSearch());
            List<Uam001VoAhmjxuamMstuser> listData = getPagingDataAhmjxuamMstuser(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(), dtoParamPaging.getOrder(),
                    dtoParamPaging.getSearch());
            dtoRespondPaging.setRows(listData);
            dtoRespondPaging.setTotal(count);
        }
        return dtoRespondPaging;
    }

    public Uam001AhmjxuamMstuserDao getUam001AhmjxuamMstuserDao() {
        return uam001AhmjxuamMstuserDao;
    }

    public void setUam002AhmjxuamMstuserDao(Uam001AhmjxuamMstuserDao ahmjxuamMstuserDao) {
        this.uam001AhmjxuamMstuserDao = ahmjxuamMstuserDao;
    }

    @Transactional(readOnly = false)
    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam001VoAhmjxuamMstuser uam001VoAhmjxuamMstuser, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            AhmjxuamMstusers ahmjxuamMstusers = new AhmjxuamMstusers();
            ahmjxuamMstusers.setVid(uam001VoAhmjxuamMstuser.getVid());
            ahmjxuamMstusers.setVusername(uam001VoAhmjxuamMstuser.getVusername());
            ahmjxuamMstusers.setVidAhmjxuamMstpartner(uam001VoAhmjxuamMstuser.getVidDlr());
            String passMD5 = new MD5(Uam001Util.INIT_PASSWORD).asHex();
            ahmjxuamMstusers.setVpassword(passMD5);
            ahmjxuamMstusers.setVstat("T");
            //System.out.println("Nilai : " + uam002VoAhmdsuamMstuser.getVusername() + "--" + uam002VoAhmdsuamMstuser.getVpassword() + "--" + uam002VoAhmdsuamMstuser.getVstat());
            uam001AhmjxuamMstuserDao.save(ahmjxuamMstusers, username);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setDetailMsg("Penambahan User berhasil!");
            return dtoRespond;
        }
        return dtoRespond;
    }

    @Transactional(readOnly = false)
    public DtoRespond update(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Uam001VoAhmjxuamMstuser uam001VoAhmjxuamMstuser,
            String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();

        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            AhmjxuamMstusers ahmjxuamMstusers = new AhmjxuamMstusers();
            System.out.println("Nilai : " + uam001VoAhmjxuamMstuser.getVid() + "--" + uam001VoAhmjxuamMstuser.getVusername() + "--" + uam001VoAhmjxuamMstuser.getVpassword() + "--" + uam001VoAhmjxuamMstuser.getVstat());
            ahmjxuamMstusers.setVid(uam001VoAhmjxuamMstuser.getVid());
            ahmjxuamMstusers.setCreateBy(uam001VoAhmjxuamMstuser.getVcrea());
            ahmjxuamMstusers.setCreateDate(uam001VoAhmjxuamMstuser.getDcrea());
            ahmjxuamMstusers.setVusername(uam001VoAhmjxuamMstuser.getVusername());
            ahmjxuamMstusers.setVpassword(uam001VoAhmjxuamMstuser.getVpassword());
            ahmjxuamMstusers.setVstat(Uam001Util.convertStatus(uam001VoAhmjxuamMstuser.getVstat()));
            ahmjxuamMstusers.setIver(uam001VoAhmjxuamMstuser.getIver());
            ahmjxuamMstusersDao.update(ahmjxuamMstusers, username);

        }
        return dtoRespond;
    }

    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @Override
    @Transactional(readOnly = false)
    public DtoRespond disableState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam001VoAhmjxuamMstuser> list, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            for (Uam001VoAhmjxuamMstuser uam001VoAhmjxuamMstuser : list) {
                String id = uam001VoAhmjxuamMstuser.getVid();

                System.out.println("VID UPdate " + id);

                AhmjxuamMstusers ahmjxuamMstusers = ahmjxuamMstusersDao.get(id);
                ahmjxuamMstusers.setVstat("F");

                ahmjxuamMstusersDao.update(ahmjxuamMstusers, username);
            }
            dtoRespond.setDetailMsg("User telah dinonaktifkan");
        }
        return dtoRespond;
    }

    @Override
    @Transactional(readOnly = false)
    public DtoRespond resetPassword(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam001VoAhmjxuamMstuser> list, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            for (Uam001VoAhmjxuamMstuser uam001VoAhmjxuamMstuser : list) {
                String id = uam001VoAhmjxuamMstuser.getVid();

                AhmjxuamMstusers ahmjxuamMstusers = ahmjxuamMstusersDao.get(id);
                String passMD5 = new MD5(Uam001Util.INIT_PASSWORD).asHex();
                ahmjxuamMstusers.setVpassword(passMD5);
                //System.out.println("VID -- "+ahmdsuamMstusers.getVid()+"PasswordLama  --"+pass+"PasswordBaru --"+passMD5);
                ahmjxuamMstusersDao.update(ahmjxuamMstusers, username);
            }
            dtoRespond.setDetailMsg("Password telah di-reset");
        }
        return dtoRespond;
    }

    public Uam001VoAhmjxuamMstuser getUserById(String vid) {
        AhmjxuamMstusers ahmjxuamMstusers = ahmjxuamMstusersDao.get(vid);
        Uam001VoAhmjxuamMstuser uam001VoAhmjxuamMstuser = null;
        if (ahmjxuamMstusers != null) {
            uam001VoAhmjxuamMstuser = new Uam001VoAhmjxuamMstuser();
            uam001VoAhmjxuamMstuser.setVid(vid);
            uam001VoAhmjxuamMstuser.setVusername(ahmjxuamMstusers.getVusername());
            uam001VoAhmjxuamMstuser.setVpassword(ahmjxuamMstusers.getVpassword());
            uam001VoAhmjxuamMstuser.setVcrea(ahmjxuamMstusers.getCreateBy());
            uam001VoAhmjxuamMstuser.setDcrea(ahmjxuamMstusers.getCreateDate());
            uam001VoAhmjxuamMstuser.setVstat(Uam001Util.convertStatus(ahmjxuamMstusers.getVstat()));
            uam001VoAhmjxuamMstuser.setIver(ahmjxuamMstusers.getIver());
        }
        return uam001VoAhmjxuamMstuser;
    }

    public DtoRespondPaging getLovDealer(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            dtoRespondPaging.setTotal(getPagingCountAhmjxuamMstpartner(dtoParamPaging.getSearch()));
            dtoRespondPaging.setRows(getPagingDataAhmjxuamMstpartner(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(),
                    dtoParamPaging.getOrder(), dtoParamPaging.getSearch()));
        }
        return dtoRespondPaging;
    }

    private List<Uam001Vodlr> getPagingDataAhmjxuamMstpartner(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam001AhmjxuamMstpartnerDao.getPagingDataAhmjxuamMstpartner(first, pageSize, sortField, sortOrder, filters);
    }

    private int getPagingCountAhmjxuamMstpartner(Map<String, Object> filters) {
        return uam001AhmjxuamMstpartnerDao.getPagingCountAhmjxuamMstpartner(filters);
    }
}
