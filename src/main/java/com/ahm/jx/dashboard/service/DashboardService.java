/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.service;

import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmjxuamMstpartner;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondAppInfo;
import com.ahm.jx.common.rest.dto.DtoRespondLogin;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.vo.VoAppInfo;
import com.ahm.jx.dashboard.vo.VoChangePassword;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author achmad.ha
 */
public interface DashboardService {

    public DtoRespond login(String userName, String password,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    public DtoRespond logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    public DtoRespondLogin dashboardInformation(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String token);

    public DtoRespondAppInfo appInformation(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, VoAppInfo voAppInfo, String token);

    public boolean authorization(String userName, String appId);

    public List<VoAhmjxuamMstmenus> getMenuByUser(String userName);

    public VoAhmjxuamMstpartner getDealerInfoByUser(String userName);

    public HttpServletResponse setCookieToken(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse);

    public boolean validateToken(String cookieDims, HttpServletRequest httpServletRequest);

    public boolean validateAndAuthorization(String cookieDims, HttpServletRequest httpServletRequest,
            String userName, String appId);

    public DtoRespond authenticationAndAuthorization(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String token, String username, String appId);

    public DtoRespondPaging authenticationAndAuthorizationPaging(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String token, String username, String appId);

    public DtoRespond authenticationAndAuthorization(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String token, String appId);

    public DtoRespondPaging authenticationAndAuthorizationPaging(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String token, String appId);

    public String getUsername(HttpServletRequest httpServletRequest);

    public String tokenizer(String filename, String token);

    public String generatePdfReportUrl(String reportTitle, List listData, Map<String, Object> params, String username);

    public boolean validateLicenseInDatabase(String dealerCode);

    public boolean validateLicenseInFile(String dealerCode, String address, String name,
            String owner, String city, String mdCode, Date beginEff, Date endEff,
            String licType, String license);

    public DtoRespond changePassword(VoChangePassword voChangePassword, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse);

    public DtoRespond getBookmarkUser(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse);

    public DtoRespond bookmarkMenu(String vAppId, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse);

    public DtoRespond unbookmarkMenu(String vAppId, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse);
}
