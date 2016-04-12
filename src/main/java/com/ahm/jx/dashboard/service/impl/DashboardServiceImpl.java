/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.service.impl;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahm.jx.app000.dao.AhmdsbscDtlsettingDao;
import com.ahm.jx.app000.model.AhmjxuamMstpartner;
import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.app000.model.AhmjxuamTxnbookmark;
import com.ahm.jx.app000.vo.VoAhmdsbscDtlsetting;
import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmjxuamMstpartner;
import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondAppInfo;
import com.ahm.jx.common.rest.dto.DtoRespondLogin;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.common.util.RestUtil;
import com.ahm.jx.common.util.RsaSignatureUtils;
import com.ahm.jx.dashboard.dao.DashboardAhmdsbscTxnappcountDao;
import com.ahm.jx.dashboard.dao.DashboardAhmjxuamHdrrlaccessDao;
import com.ahm.jx.dashboard.dao.DashboardAhmjxuamMstmenusDao;
import com.ahm.jx.dashboard.dao.DashboardAhmjxuamMstpartnerDao;
import com.ahm.jx.dashboard.dao.DashboardAhmjxuamMstusersDao;
import com.ahm.jx.dashboard.dao.DashboardAhmjxuamTxnbookmarkDao;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.dashboard.vo.VoAppInfo;
import com.ahm.jx.dashboard.vo.VoBookmark;
import com.ahm.jx.dashboard.vo.VoChangePassword;
import com.ahm.jx.dashboard.vo.VoCounterApp;
import com.ahm.jx.ttm.dao.UamUserDao;
import com.ahm.jx.ttm.model.AhmjxUamUser;
import com.twmacinta.util.MD5;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author achmad.ha
 */

@Service("dashboardService")
@Transactional(readOnly = true)
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	UamUserDao userDao;
	
	@Autowired
    @Qualifier("dashboardAhmjxuamMstusersDao")
    private DashboardAhmjxuamMstusersDao dashboardAhmjxuamMstusersDao;
    
    @Autowired
    @Qualifier("dashboardAhmdsbscTxnappcountDao")
    private DashboardAhmdsbscTxnappcountDao dashboardAhmdsbscTxnappcountDao;
    
    @Autowired
    @Qualifier("dashboardAhmjxuamMstmenusDao")
    private DashboardAhmjxuamMstmenusDao dashboardAhmjxuamMstmenusDao;
    
    @Autowired
    @Qualifier("dashboardAhmjxuamHdrrlaccessDao")
    private DashboardAhmjxuamHdrrlaccessDao dashboardAhmjxuamHdrrlaccessDao;
    
    @Autowired
    @Qualifier("dashboardAhmjxuamMstpartnerDao")
    private DashboardAhmjxuamMstpartnerDao dashboardAhmjxuamMstpartnerDao;
    
    @Autowired
    @Qualifier("dashboardAhmjxuamTxnbookmarkDao")
    private DashboardAhmjxuamTxnbookmarkDao dashboardAhmjxuamTxnbookmarkDao;
    
    @Autowired
    @Qualifier("ahmdsbscDtlsettingDao")
    private AhmdsbscDtlsettingDao ahmdsbscDtlsettingDao;

    public List<VoAhmjxuamMstmenus> getMenuByUser(String userName) {
        return dashboardAhmjxuamMstusersDao.getMenuByUser(userName);
    }

    @Transactional(readOnly = false)
    public DtoRespond login(String userName, String password,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        AhmjxuamMstusers ahmjxuamMstusers = new AhmjxuamMstusers();
        ahmjxuamMstusers = dashboardAhmjxuamMstusersDao.getAhmjxuamMstuserByUsername(userName);
        if (ahmjxuamMstusers != null) {
            String passMD5 = new MD5(password).asHex();

            System.out.println("---> passMD5: " + passMD5);

            if (ahmjxuamMstusers.getVpassword().equals(passMD5)) {
                VoAhmjxuamMstpartner voAhmjxuamMstpartner = getDealerInfoByUser(userName);
                System.out.println("---------> vdealercode: " + voAhmjxuamMstpartner.getVdealercode().toString());

                if (validateLicenseInDatabase(voAhmjxuamMstpartner.getVdealercode())) {
                    dtoRespond = RestUtil.success();
                    httpServletRequest.getSession().setAttribute(CommonConstant.cookieDimsUser, userName);
                    setCookieToken(httpServletRequest, httpServletResponse);

                    ahmjxuamMstusers.setVtoken(httpServletRequest.getSession().getAttribute(CommonConstant.cookieDims).toString());
                    ahmjxuamMstusers.setDtokenexp((Date) httpServletRequest.getSession().getAttribute(CommonConstant.sessionTimeOut));
                    ahmjxuamMstusers.setVipaddress(httpServletRequest.getRemoteAddr().toString());

                    dashboardAhmjxuamMstusersDao.update(ahmjxuamMstusers, userName);

                    System.out.println("------>" + httpServletRequest.getSession().getAttribute(CommonConstant.cookieDims).toString());
                } else {
                    dtoRespond.setStat(CommonConstant._401);
                    dtoRespond.setMsg("Your License is invalid");
                }
            } else {
                dtoRespond.setStat(CommonConstant._401);
                dtoRespond.setMsg("Username/Pasword is invalid");
            }
        } else {
            dtoRespond.setStat(CommonConstant._401);
            dtoRespond.setMsg("Username/Pasword is invalid");
        }
        return dtoRespond;
    }

    public DtoRespond logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = RestUtil.success();
        httpServletRequest.getSession().invalidate();
        return dtoRespond;
    }

    @Transactional
    public DtoRespondLogin dashboardInformation(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String token) {
    	
    	Authentication principal = SecurityContextHolder.getContext().getAuthentication();
    	AhmjxUamUser user = userDao.findOneByUserName(principal.getName());
    	
        //List<VoAhmjxuamMstmenus> list = getMenuByUser(username);
        
        DtoRespondLogin dtoRespondLogin = new DtoRespondLogin();
        dtoRespondLogin.setStat(CommonConstant._200);
        dtoRespondLogin.setMsg(CommonConstant._200Msg);
        dtoRespondLogin.setRows(user.getMenus());
        dtoRespondLogin.setUserName(user.getUserName());
        
        /*
        if (validateToken(token, httpServletRequest)) {
            String username = getUsername(httpServletRequest);
            List<VoAhmjxuamMstmenus> list = getMenuByUser(username);
            dtoRespondLogin.setStat(CommonConstant._200);
            dtoRespondLogin.setMsg(CommonConstant._200Msg);
            dtoRespondLogin.setRows(list);
            dtoRespondLogin.setUserName(username);
            VoAhmjxuamMstpartner voAhmjxuamMstpartner = getDealerInfoByUser(username);
            dtoRespondLogin.setDealerCode(voAhmjxuamMstpartner.getVdealercode());
            dtoRespondLogin.setDealerName(voAhmjxuamMstpartner.getVname());
        } else {
            dtoRespondLogin.setStat(CommonConstant._401);
            dtoRespondLogin.setMsg(CommonConstant._401Msg);
        }
        */
        return dtoRespondLogin;
    }

    @Transactional(readOnly = false)
    public DtoRespondAppInfo appInformation(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, VoAppInfo voAppInfo, String token) {
        DtoRespondAppInfo dtoRespondAppInfo = new DtoRespondAppInfo();
        if (validateToken(token, httpServletRequest)) {
            String username = (String) httpServletRequest.getSession().getAttribute(CommonConstant.cookieDimsUser);
            if (authorization(username, voAppInfo.getAppId())) {
                VoCounterApp voCounterApp = new VoCounterApp();
                voCounterApp.setMenuId(voAppInfo.getMenuId());
                voCounterApp.setAppId(voAppInfo.getAppId());
                try {
                    addCounter(voCounterApp, username);
                    List<VoAhmjxuamMstroles> listVoAhmjxuamMstroles = dashboardAhmjxuamMstusersDao.getRoleByAppAndUser(username, voAppInfo.getMenuId());

                    if (listVoAhmjxuamMstroles != null) {
                        String[] tempRole = new String[listVoAhmjxuamMstroles.size()];
                        String[] roleVid = new String[listVoAhmjxuamMstroles.size()];
                        for (int i = 0; i < listVoAhmjxuamMstroles.size(); i++) {
                            tempRole[i] = listVoAhmjxuamMstroles.get(i).getVrolesId();
                            roleVid[i] = listVoAhmjxuamMstroles.get(i).getVid();
                        }
                        dtoRespondAppInfo.setRole(tempRole);
                        dtoRespondAppInfo.setCustomRoleAccess(dashboardAhmjxuamHdrrlaccessDao.getDetailRoleAccess(roleVid));
                    }
                    dtoRespondAppInfo.setStat(CommonConstant._200);
                    dtoRespondAppInfo.setMsg(CommonConstant._200Msg);
                } catch (Exception e) {
                    e.printStackTrace();
                    dtoRespondAppInfo.setStat(CommonConstant._500);
                }
            } else {
                dtoRespondAppInfo.setStat(CommonConstant._401);
                dtoRespondAppInfo.setMsg("Authorization");
            }
        } else {
            dtoRespondAppInfo.setStat(CommonConstant._401);
            dtoRespondAppInfo.setMsg("Validate Token");
        }
        return dtoRespondAppInfo;
    }

    public boolean authorization(String userName, String appId) {
        VoAhmjxuamMstmenus voAhmjxuamMstmenus = dashboardAhmjxuamMstusersDao.getMenuByUserByAppid(userName, appId);
        if (voAhmjxuamMstmenus != null) {
            return true;
        }
        return false;
    }

    public HttpServletResponse setCookieToken(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        System.out.println("---> randomUUIDString: " + randomUUIDString);

        Cookie cookieToken = new Cookie(CommonConstant.cookieDims, randomUUIDString);
        cookieToken.setPath(";Path=/;HttpOnly;");
//        cookieToken.setSecure(true);
        httpServletResponse.addCookie(cookieToken);
        httpServletRequest.getSession().setAttribute(CommonConstant.cookieDims, randomUUIDString);
        Date date = new Date();
        httpServletRequest.getSession().setAttribute(CommonConstant.sessionTimeOut, date);
        return httpServletResponse;
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

    public boolean validateAndAuthorization(String cookieDims, HttpServletRequest httpServletRequest,
            String userName, String appId) {
        boolean result = false;
        //autentikasi
        if (validateToken(cookieDims, httpServletRequest)) {
            //authorization 
            String username = (String) httpServletRequest.getSession().getAttribute(CommonConstant.cookieDimsUser);
            if (authorization(username, appId)) {
                return true;
            }
        }
        return result;
    }

    public DtoRespond authenticationAndAuthorization(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String token, String username, String appId) {
        return authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
    }

    public DtoRespondPaging authenticationAndAuthorizationPaging(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            String token, String username, String appId) {
        return authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse, token, appId);
    }

    @Transactional(readOnly = false)
    private VoCounterApp addCounter(VoCounterApp voCounterApp, String username) {
        VoAhmjxuamMstmenus voAhmjxuamMstmenus = dashboardAhmjxuamMstmenusDao.getMenuByMenuIdAndAppId(voCounterApp.getMenuId(), voCounterApp.getAppId());
        if (voAhmjxuamMstmenus != null) {
            dashboardAhmdsbscTxnappcountDao.addCounter(voCounterApp, username);
        } else {
            return null;
        }
        return voCounterApp;
    }

    public DtoRespond authenticationAndAuthorization(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond.setStat(CommonConstant._200);
        dtoRespond.setMsg(CommonConstant._200Msg);
        
        /* TODO: Temp, Security Handled by Spring
        if (this.validateToken(token, httpServletRequest)) {
            String username = (String) httpServletRequest.getSession().getAttribute(CommonConstant.cookieDimsUser);
            if (this.authorization(username, appId)) {
                dtoRespond.setStat(CommonConstant._200);
                dtoRespond.setMsg(CommonConstant._200Msg);
            } else {
                dtoRespond.setStat(CommonConstant._401);
                dtoRespond.setMsg(CommonConstant._401Msg);
                dtoRespond.setDetailMsg(CommonConstant.msgNotAuthorization);
            }
        } else {
            dtoRespond.setStat(CommonConstant._401);
            dtoRespond.setMsg(CommonConstant._401Msg);
            dtoRespond.setDetailMsg(CommonConstant.msgNotAuthentication);
        }
        */
        return dtoRespond;
    }

    public DtoRespondPaging authenticationAndAuthorizationPaging(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String token, String appId) {
    	
        DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
        dtoRespondPaging.setStat(CommonConstant._200);
        dtoRespondPaging.setMsg(CommonConstant._200Msg);
        
        /* TODO: Temp, Security Handled by Spring
        if (validateToken(token, httpServletRequest)) {
            String username = (String) httpServletRequest.getSession().getAttribute(CommonConstant.cookieDimsUser);
            if (authorization(username, appId)) {
                dtoRespondPaging.setStat(CommonConstant._200);
                dtoRespondPaging.setMsg(CommonConstant._200Msg);
            } else {
                dtoRespondPaging.setStat(CommonConstant._401);
                dtoRespondPaging.setMsg(CommonConstant._401Msg);
                dtoRespondPaging.setDetailMsg(CommonConstant.msgNotAuthorization);
            }
        } else {
            dtoRespondPaging.setStat(CommonConstant._401);
            dtoRespondPaging.setMsg(CommonConstant._401Msg);
            dtoRespondPaging.setDetailMsg(CommonConstant.msgNotAuthentication);
        }
        */
        return dtoRespondPaging;
    }

    public String tokenizer(String filename, String token) {
        StringTokenizer st = new StringTokenizer(filename, token);
        String result = "";
        while (st.hasMoreTokens()) {
            result = st.nextToken();
        }
        return result;
    }

    public String generatePdfReportUrl(String reportTitle, List listData, Map<String, Object> params, String username) {
        JasperPrint jasperPrint = generateJasperPrintReport(reportTitle, listData, params, username);
        UUID uuid = UUID.randomUUID();
        String url = CommonConstant.REPORT_FOLDER + "pdftemp";
        File dir = new File(url);
        if (!dir.exists()) {
            dir.mkdir();
        }
        url += "/" + uuid + ".pdf";
        try {

            JasperExportManager.exportReportToPdfFile(jasperPrint, url);
            url = "/report/pdftemp/" + uuid + ".pdf";
            return url;
        } catch (JRException ex) {
            ex.printStackTrace();
            return "Error";
        }
    }

    private JasperPrint generateJasperPrintReport(String reportTitle, List listDatas, Map<String, Object> params, String username) {
        JasperPrint jasperPrint = null;
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        VoAhmjxuamMstpartner voAhmjxuamMstpartner = getDealerInfoByUser(username);
        try {
            Locale locale = new Locale("id", "ID");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", locale);
            params.put("vDlrname", voAhmjxuamMstpartner.getVname());
            params.put("vDlraddr", voAhmjxuamMstpartner.getVdealercode());
            params.put("vDlrcity", voAhmjxuamMstpartner.getVcity());
            params.put("vDlrphonenum", voAhmjxuamMstpartner.getVphonenum());
            params.put("vusername", username);
            params.put("dPrintdate", sdf.format(new Date()));
            params.put(JRParameter.REPORT_LOCALE, locale);
            String path = CommonConstant.REPORT_FOLDER + reportTitle + ".jasper";
            jasperPrint = JasperFillManager.fillReport(path, params,
                    new JRBeanCollectionDataSource(listDatas));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return jasperPrint;
    }

    public boolean validateLicenseInDatabase(String dealerCode) {
        AhmjxuamMstpartner mstpartner = dashboardAhmjxuamMstpartnerDao.findByDealerCode(dealerCode);
        if (mstpartner == null) {
            return false;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            RsaSignatureUtils rsasignutil = new RsaSignatureUtils();

            String plaintText = rsasignutil.getPlaintText(mstpartner.getVdealercode(),
                    mstpartner.getVaddress(), mstpartner.getVname(), mstpartner.getVowner(),
                    mstpartner.getVcity(), mstpartner.getVmdcode(), sdf.format(mstpartner.getDbegineff()),
                    sdf.format(mstpartner.getDendeff()), mstpartner.getNlevel() + "");

            // Generate certificate from existing data
            byte[] licCreation = rsasignutil.getRSASignatureMstdlrcodeStr(plaintText);
            // Compare to existing license in DB
            if (!AhmStringUtil.toHex(licCreation).equals(AhmStringUtil.toHex(mstpartner.getBcert()))) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean validateLicenseInFile(String dealerCode, String address, String name,
            String owner, String city, String mdCode, Date beginEff, Date endEff,
            String licType, String license) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        RsaSignatureUtils rsasignutil = new RsaSignatureUtils();

        try {
            String plaintText = rsasignutil.getPlaintText(dealerCode, address, name,
                    owner, city, mdCode, sdf.format(beginEff), sdf.format(endEff), licType);

            // Generate certificate from existing data
            byte[] licCreation = rsasignutil.getRSASignatureMstdlrcodeStr(plaintText);
            // Compare to existing license in DB
            if (!AhmStringUtil.toHex(licCreation).equals(license)) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Transactional(readOnly = false)
    public DtoRespond changePassword(VoChangePassword voChangePassword, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        String username = getUsername(httpServletRequest);

        if (voChangePassword.getNewPassword().equals(voChangePassword.getConfirmNewPassword())) {
            AhmjxuamMstusers ahmjxuamMstusers = dashboardAhmjxuamMstusersDao.getAhmjxuamMstuserByUsername(username);
            String oldPassMD5 = new MD5(voChangePassword.getOldPassword()).asHex();
            if (ahmjxuamMstusers.getVpassword().equals(oldPassMD5)) {
                String newPassMD5 = new MD5(voChangePassword.getNewPassword()).asHex();
                ahmjxuamMstusers.setVpassword(newPassMD5);
                if (dashboardAhmjxuamMstusersDao.update(ahmjxuamMstusers)) {
                    dtoRespond = RestUtil.success();
                } else {
                    dtoRespond.setStat(CommonConstant._500);
                    dtoRespond.setMsg(CommonConstant._500Msg);
                }
            } else {
                dtoRespond.setStat(CommonConstant._400);
                dtoRespond.setMsg(CommonConstant._400Msg);
                List<String> list = new ArrayList<String>();
                list.add("Password lama tidak sesuai");
                dtoRespond.setDtlMsg(list);
            }
        } else {
            dtoRespond.setStat(CommonConstant._400);
            dtoRespond.setMsg(CommonConstant._400Msg);
            List<String> list = new ArrayList<String>();
            list.add("Password baru dan password konfirmasi tidak sama");
            dtoRespond.setDtlMsg(list);
        }
        return dtoRespond;
    }

    public DtoRespond getBookmarkUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String username = getUsername(httpServletRequest);
        DtoRespond dtoRespond = new DtoRespond();
        if (username != null) {
            dtoRespond = RestUtil.success();
            List<VoAhmdsbscDtlsetting> listDefaultBookmark = ahmdsbscDtlsettingDao.getAhmdsbscDtlsettingByVidSettingVitemcodeVitemameVdlrcode("MST_BOOKMARK", null, null, null);

            List<VoAhmjxuamMstmenus> listUsrBookmark = dashboardAhmjxuamTxnbookmarkDao.getMenusBookmark(username);
            List<VoAhmjxuamMstmenus> listSysBookmark = dashboardAhmjxuamTxnbookmarkDao.getMenusBookmarkDefault(username);
            Map<String, VoBookmark> map = new HashMap<String, VoBookmark>();
            for (VoAhmjxuamMstmenus voAhmjxuamMstmenus : listSysBookmark) {
                VoBookmark voBookmark = new VoBookmark();
                voBookmark.setVapplicationId(voAhmjxuamMstmenus.getVapplicationId());
                voBookmark.setVtitle(voAhmjxuamMstmenus.getVtitle());
                voBookmark.setVurl(voAhmjxuamMstmenus.getVurl());
                voBookmark.setVicon(voAhmjxuamMstmenus.getVicon());
                voBookmark.setFlag("S");
                map.put(voAhmjxuamMstmenus.getVapplicationId(), voBookmark);
            }
            for (VoAhmjxuamMstmenus voAhmjxuamMstmenus : listUsrBookmark) {
                VoBookmark voBookmark = new VoBookmark();
                voBookmark.setVapplicationId(voAhmjxuamMstmenus.getVapplicationId());
                voBookmark.setVtitle(voAhmjxuamMstmenus.getVtitle());
                voBookmark.setVurl(voAhmjxuamMstmenus.getVurl());
                voBookmark.setVicon(voAhmjxuamMstmenus.getVicon());
                voBookmark.setFlag("D");
                map.put(voAhmjxuamMstmenus.getVapplicationId(), voBookmark);
            }
            List<VoBookmark> listBookMark = new ArrayList();
            for (Map.Entry<String, VoBookmark> entry : map.entrySet()) {
                VoBookmark voBookmark = entry.getValue();
                listBookMark.add(voBookmark);
            }
            if (listBookMark != null) {
                dtoRespond.setRows(listBookMark);
            }
        } else {
            dtoRespond = RestUtil.authenticationFailed();
        }
        return dtoRespond;

    }

    @Transactional(readOnly = false)
    public DtoRespond bookmarkMenu(String vAppId, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        String username = getUsername(httpServletRequest);
        DtoRespond dtoRespond = new DtoRespond();
        if (username != null) {
            AhmjxuamMstusers ahmjxuamMstusers = dashboardAhmjxuamMstusersDao.getAhmjxuamMstuserByUsername(username);
            VoAhmjxuamMstmenus voAhmjxuamMstmenus = dashboardAhmjxuamMstmenusDao.getMenuByAppId(vAppId);
            AhmjxuamTxnbookmark ahmjxuamTxnbookmark = new AhmjxuamTxnbookmark();
            ahmjxuamTxnbookmark.setVidAhmjxuamMstusers(ahmjxuamMstusers.getVid());
            ahmjxuamTxnbookmark.setVidAhmjxuamMstmenus(voAhmjxuamMstmenus.getVid());
            dashboardAhmjxuamTxnbookmarkDao.save(ahmjxuamTxnbookmark, username);
            dtoRespond = RestUtil.success();
        } else {
            dtoRespond = RestUtil.authenticationFailed();
        }
        return dtoRespond;
    }

    @Transactional(readOnly = false)
    public DtoRespond unbookmarkMenu(String vAppId, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        DtoRespond dtoRespond = new DtoRespond();
        String username = getUsername(httpServletRequest);
        System.out.println("vAppId : " + vAppId);
        String vidBookmark = dashboardAhmjxuamTxnbookmarkDao.getBookMarkVid(username, vAppId);
        System.out.println("vidBookmark : " + vidBookmark);
        if (vidBookmark != null) {
            dashboardAhmjxuamTxnbookmarkDao.delete(vidBookmark);
            dtoRespond = RestUtil.success();
        } else {
            dtoRespond = RestUtil.resourceNotFound();
        }
        return dtoRespond;
    }

    public String getUsername(HttpServletRequest httpServletRequest) {
        return (String) httpServletRequest.getSession().getAttribute(CommonConstant.cookieDimsUser);
    }

    public VoAhmjxuamMstpartner getDealerInfoByUser(String userName) {
        return dashboardAhmjxuamMstusersDao.getDealerInfoByUsername(userName);
    }

    public DashboardAhmjxuamMstusersDao getDashboardAhmjxuamMstusersDao() {
        return dashboardAhmjxuamMstusersDao;
    }

    public void setDashboardAhmjxuamMstusersDao(DashboardAhmjxuamMstusersDao dashboardAhmjxuamMstusersDao) {
        this.dashboardAhmjxuamMstusersDao = dashboardAhmjxuamMstusersDao;
    }

    public DashboardAhmdsbscTxnappcountDao getDashboardAhmdsbscTxnappcountDao() {
        return dashboardAhmdsbscTxnappcountDao;
    }

    public void setDashboardAhmdsbscTxnappcountDao(DashboardAhmdsbscTxnappcountDao dashboardAhmdsbscTxnappcountDao) {
        this.dashboardAhmdsbscTxnappcountDao = dashboardAhmdsbscTxnappcountDao;
    }

    public DashboardAhmjxuamMstmenusDao getDashboardAhmjxuamMstmenusDao() {
        return dashboardAhmjxuamMstmenusDao;
    }

    public void setDashboardAhmjxuamMstmenusDao(DashboardAhmjxuamMstmenusDao dashboardAhmjxuamMstmenusDao) {
        this.dashboardAhmjxuamMstmenusDao = dashboardAhmjxuamMstmenusDao;
    }

    public DashboardAhmjxuamHdrrlaccessDao getDashboardAhmjxuamHdrrlaccessDao() {
        return dashboardAhmjxuamHdrrlaccessDao;
    }

    public void setDashboardAhmjxuamHdrrlaccessDao(DashboardAhmjxuamHdrrlaccessDao dashboardAhmjxuamHdrrlaccessDao) {
        this.dashboardAhmjxuamHdrrlaccessDao = dashboardAhmjxuamHdrrlaccessDao;
    }

    public DashboardAhmjxuamMstpartnerDao getDashboardAhmjxuamMstpartnerDao() {
        return dashboardAhmjxuamMstpartnerDao;
    }

    public void setDashboardAhmjxuamMstpartnerDao(DashboardAhmjxuamMstpartnerDao dashboardAhmjxuamMstpartnerDao) {
        this.dashboardAhmjxuamMstpartnerDao = dashboardAhmjxuamMstpartnerDao;
    }

    public DashboardAhmjxuamTxnbookmarkDao getDashboardAhmjxuamTxnbookmarkDao() {
        return dashboardAhmjxuamTxnbookmarkDao;
    }

    public void setDashboardAhmjxuamTxnbookmarkDao(DashboardAhmjxuamTxnbookmarkDao dashboardAhmjxuamTxnbookmarkDao) {
        this.dashboardAhmjxuamTxnbookmarkDao = dashboardAhmjxuamTxnbookmarkDao;
    }

    public AhmdsbscDtlsettingDao getAhmdsbscDtlsettingDao() {
        return ahmdsbscDtlsettingDao;
    }

    public void setAhmdsbscDtlsettingDao(AhmdsbscDtlsettingDao ahmdsbscDtlsettingDao) {
        this.ahmdsbscDtlsettingDao = ahmdsbscDtlsettingDao;
    }
}
