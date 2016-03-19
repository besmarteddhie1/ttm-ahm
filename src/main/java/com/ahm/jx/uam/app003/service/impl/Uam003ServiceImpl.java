/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.service.impl;

import com.ahm.jx.app000.dao.AhmdsuamMstrolesDao;
import com.ahm.jx.app000.model.AhmdsuamMstroles;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app003.dao.Uam003AhmdsuamMstrolesDao;
import com.ahm.jx.uam.app003.service.Uam003Service;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmdsuamMstroles;
import com.ahm.jx.uam.app003.util.Uam003Util;
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
 * @author indriHtb
 */
@Service("uam003Service")
@Transactional(readOnly = true)
public class Uam003ServiceImpl implements Uam003Service {

    @Autowired
    @Qualifier("uam003AhmdsuamMstrolesDao")
    private Uam003AhmdsuamMstrolesDao uam003AhmdsuamMstrolesDao;
    @Autowired
    @Qualifier("ahmdsuamMstrolesDao")
    private AhmdsuamMstrolesDao ahmdsuamMstrolesDao;
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    @Override
    @Transactional(readOnly = false)
    public DtoRespond disableRoleState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam003VoAhmdsuamMstroles> list, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            for (Uam003VoAhmdsuamMstroles uam003VoAhmdsuamMstroles : list) {
                String id = uam003VoAhmdsuamMstroles.getVid();

                System.out.println("VID UPdate " + id);

                AhmdsuamMstroles ahmdsuamMstroles = ahmdsuamMstrolesDao.get(id);
                ahmdsuamMstroles.setVrolesStatus("F");

                ahmdsuamMstrolesDao.update(ahmdsuamMstroles, username);
            }
            dtoRespond.setDetailMsg("Role telah dinonaktifkan");
        }
        return dtoRespond;
    }

    public int getPagingCountAhmdsuamMstroles(Map<String, Object> filters) {
        return uam003AhmdsuamMstrolesDao.getPagingCountAhmdsuamMstroles(filters);
    }

    public List<Uam003VoAhmdsuamMstroles> getPagingDataAhmdsuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        return uam003AhmdsuamMstrolesDao.getPagingDataAhmdsuamMstroles(first, pageSize, sortField, sortOrder, filters);
    }

    public DtoRespondPaging pagingRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging;
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            int count = getPagingCountAhmdsuamMstroles(dtoParamPaging.getSearch());
            List<Uam003VoAhmdsuamMstroles> listData = getPagingDataAhmdsuamMstroles(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(), dtoParamPaging.getOrder(),
                    dtoParamPaging.getSearch());
            dtoRespondPaging.setRows(listData);
            dtoRespondPaging.setTotal(count);
        }
        return dtoRespondPaging;
    }

    @Transactional(readOnly = false)
    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam003VoAhmdsuamMstroles uam003VoAhmdsuamMstroles, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            AhmdsuamMstroles ahmdsuamMstroles = new AhmdsuamMstroles();
            ahmdsuamMstroles.setVrolesId(uam003VoAhmdsuamMstroles.getVrolesId());
            ahmdsuamMstroles.setVrolesName(uam003VoAhmdsuamMstroles.getVrolesName());
            ahmdsuamMstroles.setVrolesDesc(uam003VoAhmdsuamMstroles.getVrolesDesc());
            ahmdsuamMstroles.setVrolesStatus("T");
            uam003AhmdsuamMstrolesDao.save(ahmdsuamMstroles, username);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setDetailMsg("Penambahan role berhasil");
            return dtoRespond;
        }
        return dtoRespond;
    }

    @Transactional(readOnly = false)
    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam003VoAhmdsuamMstroles uam003VoAhmdsuamMstroles, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
                AhmdsuamMstroles ahmdsuamMstroles = new AhmdsuamMstroles();
                ahmdsuamMstroles.setCreateBy(uam003VoAhmdsuamMstroles.getVcrea());
                ahmdsuamMstroles.setCreateDate(uam003VoAhmdsuamMstroles.getDcrea());
                ahmdsuamMstroles.setVid(uam003VoAhmdsuamMstroles.getVid());
                ahmdsuamMstroles.setIver(uam003VoAhmdsuamMstroles.getIver());
                ahmdsuamMstroles.setVrolesId(uam003VoAhmdsuamMstroles.getVrolesId());
                ahmdsuamMstroles.setVrolesName(uam003VoAhmdsuamMstroles.getVrolesName());
                ahmdsuamMstroles.setVrolesDesc(uam003VoAhmdsuamMstroles.getVrolesDesc());
                //ahmdsuamMstroles.setVrolesStatus(uam003VoAhmdsuamMstroles.getvrolesStatus());
                ahmdsuamMstroles.setVrolesStatus(Uam003Util.convertStatus(uam003VoAhmdsuamMstroles.getVrolesStatus()));
                uam003AhmdsuamMstrolesDao.update(ahmdsuamMstroles, username);

                dtoRespond.setStat(CommonConstant._200);
                dtoRespond.setMsg(CommonConstant._200Msg);
                dtoRespond.setDetailMsg("Update berhasil");
        }
        return dtoRespond;
    }

    public Uam003AhmdsuamMstrolesDao getUam003AhmdsuamMstrolesDao() {
        return uam003AhmdsuamMstrolesDao;
    }

    public void setUam003AhmdsuamMstrolesDao(Uam003AhmdsuamMstrolesDao uam003AhmdsuamMstrolesDao) {
        this.uam003AhmdsuamMstrolesDao = uam003AhmdsuamMstrolesDao;
    }

    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public AhmdsuamMstrolesDao getAhmdsuamMstrolesDao() {
        return ahmdsuamMstrolesDao;
    }

    public void setAhmdsuamMstrolesDao(AhmdsuamMstrolesDao ahmdsuamMstrolesDao) {
        this.ahmdsuamMstrolesDao = ahmdsuamMstrolesDao;
    }

    public Uam003VoAhmdsuamMstroles getRoleById(String vid) {
        AhmdsuamMstroles ahmdsuamMstroles = ahmdsuamMstrolesDao.get(vid);
        Uam003VoAhmdsuamMstroles vo = null;
        if (ahmdsuamMstroles != null) {
            vo=new Uam003VoAhmdsuamMstroles();
            vo.setVid(ahmdsuamMstroles.getVid());
            vo.setIver(ahmdsuamMstroles.getIver());
            vo.setVcrea(ahmdsuamMstroles.getCreateBy());
            vo.setDcrea(ahmdsuamMstroles.getCreateDate());
            vo.setVrolesDesc(ahmdsuamMstroles.getVrolesDesc());
            vo.setVrolesId(ahmdsuamMstroles.getVrolesId());
            vo.setVrolesName(ahmdsuamMstroles.getVrolesName());
            vo.setVrolesStatus(Uam003Util.convertStatus(ahmdsuamMstroles.getVrolesStatus()));
        }
        return vo;
    }
}
