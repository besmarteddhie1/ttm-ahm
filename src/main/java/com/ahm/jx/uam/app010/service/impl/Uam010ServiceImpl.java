/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app010.service.impl;

import com.ahm.jx.app000.model.AhmjxuamMstpartner;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app010.vo.Uam010VoAhmjxuamMstpartner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ahm.jx.uam.app010.dao.Uam010AhmjxuamMstpartnerDao;
import com.ahm.jx.uam.app010.service.Uam010Service;

/**
 *
 * @author hendra.fs
 */
@Service("uam010Service")
@Transactional(readOnly = true)
public class Uam010ServiceImpl implements Uam010Service {

    @Autowired
    @Qualifier("uam010AhmjxuamMstpartnerDao")
    private Uam010AhmjxuamMstpartnerDao uam010AhmjxuamMstpartnerDao;
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    public DtoRespondPaging pagingDealerLicense(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging,
            String token, String appId) {
        DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            int count = getPagingCountAhmjxuamMstpartner(dtoParamPaging.getSearch());
            List<Uam010VoAhmjxuamMstpartner> listData = getPagingDataAhmjxuamMstpartner(
                    dtoParamPaging.getOffset(), dtoParamPaging.getLimit(), dtoParamPaging.getSort(),
                    dtoParamPaging.getOrder(), dtoParamPaging.getSearch());
            dtoRespondPaging.setRows(listData);
            dtoRespondPaging.setTotal(count);
        }

        return dtoRespondPaging;
    }

    @Transactional(readOnly = false)
    public DtoRespond extractFile(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            String targetFile, String token, String appId) {
        DtoRespond dtoRespond = null;
        List<String> dtlMsg = new ArrayList<String>();

        dtoRespond = dashboardService
                .authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equalsIgnoreCase(CommonConstant._200)) {
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            String username = dashboardService.getUsername(httpServletRequest);
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ";";

            try {
                br = new BufferedReader(new FileReader(targetFile));
                AhmjxuamMstpartner ahmjxuamMstpartner;
                while ((line = br.readLine()) != null) {
                    // use comma as separator
                    String[] license = line.split(cvsSplitBy);

                    // Validate license
                    if (!dashboardService.validateLicenseInFile(license[0], license[1], license[2],
                            license[3], license[5], license[6], sdf.parse(license[7]),
                            sdf.parse(license[8]), license[9], license[13])) {
                        dtlMsg.add("License tidak valid");
                        dtoRespond.setStat(CommonConstant._500);
                        dtoRespond.setMsg(CommonConstant._500Msg);
                        dtoRespond.setDtlMsg(dtlMsg);
                        return dtoRespond;
                    } else {
                        ahmjxuamMstpartner = uam010AhmjxuamMstpartnerDao.findByDealerCode(license[0]);
                        if (ahmjxuamMstpartner != null) {
                            ahmjxuamMstpartner.setVaddress(license[1]);
                            ahmjxuamMstpartner.setVname(license[2]);
                            ahmjxuamMstpartner.setVowner(license[3]);
                            ahmjxuamMstpartner.setVphonenum(license[4]);
                            ahmjxuamMstpartner.setVcity(license[5]);
                            ahmjxuamMstpartner.setVmdcode(license[6]);
                            ahmjxuamMstpartner.setDbegineff(sdf.parse(license[7]));
                            ahmjxuamMstpartner.setDendeff(sdf.parse(license[8]));
                            ahmjxuamMstpartner.setNlevel(Integer.parseInt(license[9]));

                            if ((license[10] != null) && !(license[10].equals(""))) {
                                ahmjxuamMstpartner.setNpit(Integer.parseInt(license[10]));
                            }

                            byte[] bCert = AhmStringUtil.toByte(license[13]);
                            ahmjxuamMstpartner.setBcert(bCert);
                            uam010AhmjxuamMstpartnerDao.update(ahmjxuamMstpartner, username);
                        } else {
                            ahmjxuamMstpartner = new AhmjxuamMstpartner();
                            ahmjxuamMstpartner.setVdealercode(license[0]);
                            ahmjxuamMstpartner.setVaddress(license[1]);
                            ahmjxuamMstpartner.setVname(license[2]);
                            ahmjxuamMstpartner.setVowner(license[3]);
                            ahmjxuamMstpartner.setVphonenum(license[4]);
                            ahmjxuamMstpartner.setVcity(license[5]);
                            ahmjxuamMstpartner.setVmdcode(license[6]);
                            ahmjxuamMstpartner.setDbegineff(sdf.parse(license[7]));
                            ahmjxuamMstpartner.setDendeff(sdf.parse(license[8]));
                            ahmjxuamMstpartner.setNlevel(Integer.parseInt(license[9]));

                            if ((license[10] != null) && !(license[10].equals(""))) {
                                ahmjxuamMstpartner.setNpit(Integer.parseInt(license[10]));
                            }

                            byte[] bCert = AhmStringUtil.toByte(license[13]);
                            ahmjxuamMstpartner.setBcert(bCert);
                            uam010AhmjxuamMstpartnerDao.save(ahmjxuamMstpartner, username);
                        }

                        dtlMsg.add("Proses Upload License Berhasil");
                        dtoRespond.setStat(CommonConstant._200);
                        dtoRespond.setMsg(CommonConstant._200Msg);
                        dtoRespond.setDtlMsg(dtlMsg);
                        return dtoRespond;
                    }
                }

                // Masuk kesini hanya jika file kosong
                dtlMsg.add("File kosong");
                dtoRespond.setStat(CommonConstant._500);
                dtoRespond.setMsg(CommonConstant._500Msg);
                dtoRespond.setDtlMsg(dtlMsg);
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return dtoRespond;
    }

    public int getPagingCountAhmjxuamMstpartner(Map<String, Object> filters) {
        return (uam010AhmjxuamMstpartnerDao.getPagingCountAhmjxuamMstpartner(filters));
    }

    public List<Uam010VoAhmjxuamMstpartner> getPagingDataAhmjxuamMstpartner(int first, int pageSize,
            String sortField, String sortOrder, Map<String, Object> filters) {
        return uam010AhmjxuamMstpartnerDao.getPagingDataAhmjxuamMstpartner(first, pageSize,
                sortField, sortOrder, filters);
    }

    // Setter Getter
    public Uam010AhmjxuamMstpartnerDao getUam010AhmjxuamMstpartnerDao() {
        return uam010AhmjxuamMstpartnerDao;
    }

    public void setUam010AhmjxuamMstpartnerDao(Uam010AhmjxuamMstpartnerDao uam010AhmjxuamMstpartnerDao) {
        this.uam010AhmjxuamMstpartnerDao = uam010AhmjxuamMstpartnerDao;
    }

    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }
}
