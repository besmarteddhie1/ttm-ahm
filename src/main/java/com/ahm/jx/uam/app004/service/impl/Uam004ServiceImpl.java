package com.ahm.jx.uam.app004.service.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstmenusDao;
import com.ahm.jx.app000.model.AhmjxuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app004.service.Uam004Service;
import com.ahm.jx.uam.app004.vo.Uam004VoAhmjxuamMstmenus;
import com.ahm.jx.common.util.AhmStringUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ahm.jx.uam.app004.dao.Uam004AhmjxuamMstmenusDao;

/**
 *
 * @author Elisa
 */
@Service("uam004Service")
@Transactional(readOnly = true)
public class Uam004ServiceImpl implements Uam004Service {

    @Autowired
    @Qualifier("uam004AhmjxuamMstmenusDao")
    private Uam004AhmjxuamMstmenusDao uam004AhmjxuamMstmenusDao;
    @Autowired
    @Qualifier("ahmjxuamMstmenusDao")
    private AhmjxuamMstmenusDao ahmjxuamMstmenusDao;
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    private List<String> listIcon = Arrays.asList(
            "glyphicon glyphicon-asterisk",
            "glyphicon glyphicon-plus",
            "glyphicon glyphicon-euro",
            "glyphicon glyphicon-minus",
            "glyphicon glyphicon-cloud",
            "glyphicon glyphicon-envelope",
            "glyphicon glyphicon-pencil",
            "glyphicon glyphicon-glass",
            "glyphicon glyphicon-music",
            "glyphicon glyphicon-search",
            "glyphicon glyphicon-heart",
            "glyphicon glyphicon-star",
            "glyphicon glyphicon-star-empty",
            "glyphicon glyphicon-user",
            "glyphicon glyphicon-film",
            "glyphicon glyphicon-th-large",
            "glyphicon glyphicon-th",
            "glyphicon glyphicon-th-list",
            "glyphicon glyphicon-ok",
            "glyphicon glyphicon-remove",
            "glyphicon glyphicon-zoom-in",
            "glyphicon glyphicon-zoom-out",
            "glyphicon glyphicon-off",
            "glyphicon glyphicon-signal",
            "glyphicon glyphicon-cog",
            "glyphicon glyphicon-trash",
            "glyphicon glyphicon-home",
            "glyphicon glyphicon-file",
            "glyphicon glyphicon-time",
            "glyphicon glyphicon-road",
            "glyphicon glyphicon-download-alt",
            "glyphicon glyphicon-download",
            "glyphicon glyphicon-upload",
            "glyphicon glyphicon-inbox",
            "glyphicon glyphicon-play-circle",
            "glyphicon glyphicon-repeat",
            "glyphicon glyphicon-refresh",
            "glyphicon glyphicon-list-alt",
            "glyphicon glyphicon-lock",
            "glyphicon glyphicon-flag",
            "glyphicon glyphicon-headphones",
            "glyphicon glyphicon-volume-off",
            "glyphicon glyphicon-volume-down",
            "glyphicon glyphicon-volume-up",
            "glyphicon glyphicon-qrcode",
            "glyphicon glyphicon-barcode",
            "glyphicon glyphicon-tag",
            "glyphicon glyphicon-tags",
            "glyphicon glyphicon-book",
            "glyphicon glyphicon-bookmark",
            "glyphicon glyphicon-print",
            "glyphicon glyphicon-camera",
            "glyphicon glyphicon-font",
            "glyphicon glyphicon-bold",
            "glyphicon glyphicon-italic",
            "glyphicon glyphicon-text-height",
            "glyphicon glyphicon-text-width",
            "glyphicon glyphicon-align-left",
            "glyphicon glyphicon-align-center",
            "glyphicon glyphicon-align-right",
            "glyphicon glyphicon-align-justify",
            "glyphicon glyphicon-list",
            "glyphicon glyphicon-indent-left",
            "glyphicon glyphicon-indent-right",
            "glyphicon glyphicon-facetime-video",
            "glyphicon glyphicon-picture",
            "glyphicon glyphicon-map-marker",
            "glyphicon glyphicon-adjust",
            "glyphicon glyphicon-tint",
            "glyphicon glyphicon-edit",
            "glyphicon glyphicon-share",
            "glyphicon glyphicon-check",
            "glyphicon glyphicon-move",
            "glyphicon glyphicon-step-backward",
            "glyphicon glyphicon-fast-backward",
            "glyphicon glyphicon-backward",
            "glyphicon glyphicon-play",
            "glyphicon glyphicon-pause",
            "glyphicon glyphicon-stop",
            "glyphicon glyphicon-forward",
            "glyphicon glyphicon-fast-forward",
            "glyphicon glyphicon-step-forward",
            "glyphicon glyphicon-eject",
            "glyphicon glyphicon-chevron-left",
            "glyphicon glyphicon-chevron-right",
            "glyphicon glyphicon-plus-sign",
            "glyphicon glyphicon-minus-sign",
            "glyphicon glyphicon-remove-sign",
            "glyphicon glyphicon-ok-sign",
            "glyphicon glyphicon-question-sign",
            "glyphicon glyphicon-info-sign",
            "glyphicon glyphicon-screenshot",
            "glyphicon glyphicon-remove-circle",
            "glyphicon glyphicon-ok-circle",
            "glyphicon glyphicon-ban-circle",
            "glyphicon glyphicon-arrow-left",
            "glyphicon glyphicon-arrow-right",
            "glyphicon glyphicon-arrow-up",
            "glyphicon glyphicon-arrow-down",
            "glyphicon glyphicon-share-alt",
            "glyphicon glyphicon-resize-full",
            "glyphicon glyphicon-resize-small",
            "glyphicon glyphicon-exclamation-sign",
            "glyphicon glyphicon-gift",
            "glyphicon glyphicon-leaf",
            "glyphicon glyphicon-fire",
            "glyphicon glyphicon-eye-open",
            "glyphicon glyphicon-eye-close",
            "glyphicon glyphicon-warning-sign",
            "glyphicon glyphicon-plane",
            "glyphicon glyphicon-calendar",
            "glyphicon glyphicon-random",
            "glyphicon glyphicon-comment",
            "glyphicon glyphicon-magnet",
            "glyphicon glyphicon-chevron-up",
            "glyphicon glyphicon-chevron-down",
            "glyphicon glyphicon-retweet",
            "glyphicon glyphicon-shopping-cart",
            "glyphicon glyphicon-folder-close",
            "glyphicon glyphicon-folder-open",
            "glyphicon glyphicon-resize-vertical",
            "glyphicon glyphicon-resize-horizontal",
            "glyphicon glyphicon-hdd",
            "glyphicon glyphicon-bullhorn",
            "glyphicon glyphicon-bell",
            "glyphicon glyphicon-certificate",
            "glyphicon glyphicon-thumbs-up",
            "glyphicon glyphicon-thumbs-down",
            "glyphicon glyphicon-hand-right",
            "glyphicon glyphicon-hand-left",
            "glyphicon glyphicon-hand-up",
            "glyphicon glyphicon-hand-down",
            "glyphicon glyphicon-circle-arrow-right",
            "glyphicon glyphicon-circle-arrow-left",
            "glyphicon glyphicon-circle-arrow-up",
            "glyphicon glyphicon-circle-arrow-down",
            "glyphicon glyphicon-globe",
            "glyphicon glyphicon-wrench",
            "glyphicon glyphicon-tasks",
            "glyphicon glyphicon-filter",
            "glyphicon glyphicon-briefcase",
            "glyphicon glyphicon-fullscreen",
            "glyphicon glyphicon-dashboard",
            "glyphicon glyphicon-paperclip",
            "glyphicon glyphicon-heart-empty",
            "glyphicon glyphicon-link",
            "glyphicon glyphicon-phone",
            "glyphicon glyphicon-pushpin",
            "glyphicon glyphicon-usd",
            "glyphicon glyphicon-gdp",
            "glyphicon glyphicon-sort",
            "glyphicon glyphicon-sort-by-alphabet",
            "glyphicon glyphicon-sort-by-alphabet-alt",
            "glyphicon glyphicon-sort-by-order",
            "glyphicon glyphicon-sort-by-order-alt",
            "glyphicon glyphicon-sort-by-attributes",
            "glyphicon glyphicon-unchecked",
            "glyphicon glyphicon-expand",
            "glyphicon glyphicon-collapse-down",
            "glyphicon glyphicon-collapse-up",
            "glyphicon glyphicon-log-in",
            "glyphicon glyphicon-flash",
            "glyphicon glyphicon-log-out",
            "glyphicon glyphicon-new-window",
            "glyphicon glyphicon-record",
            "glyphicon glyphicon-save",
            "glyphicon glyphicon-open",
            "glyphicon glyphicon-saved",
            "glyphicon glyphicon-import",
            "glyphicon glyphicon-export",
            "glyphicon glyphicon-send",
            "glyphicon glyphicon-floppy-disk",
            "glyphicon glyphicon-floppy-saved",
            "glyphicon glyphicon-floppy-removed",
            "glyphicon glyphicon-floppy-save",
            "glyphicon glyphicon-floppy-open",
            "glyphicon glyphicon-credit-card",
            "glyphicon glyphicon-transfer",
            "glyphicon glyphicon-cutlery",
            "glyphicon glyphicon-header",
            "glyphicon glyphicon-compressed",
            "glyphicon glyphicon-earphone",
            "glyphicon glyphicon-phone-alt",
            "glyphicon glyphicon-tower",
            "glyphicon glyphicon-stats",
            "glyphicon glyphicon-sd-video",
            "glyphicon glyphicon-hd-video",
            "glyphicon glyphicon-subtitles",
            "glyphicon glyphicon-sound-stereo",
            "glyphicon glyphicon-sound-dolby",
            "glyphicon glyphicon-sound-5-1",
            "glyphicon glyphicon-sound-6-1",
            "glyphicon glyphicon-sound-7-1",
            "glyphicon glyphicon-copyright-mark",
            "glyphicon glyphicon-registration-mark",
            "glyphicon glyphicon-cloud-download",
            "glyphicon glyphicon-cloud-upload",
            "glyphicon glyphicon-tree-conifer",
            "glyphicon glyphicon-tree-deciduous");

    public DtoRespond getListIcon(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            dtoRespond.setDetailMsg("Success");
            dtoRespond.setRows(listIcon);
        }

        return dtoRespond;
    }

    public int getPagingCountAhmjxuamMstmenus(Map<String, Object> filters, boolean isLov) {
        return uam004AhmjxuamMstmenusDao.getPagingCountAhmjxuamMstmenus(filters, isLov);
    }

    public List<Uam004VoAhmjxuamMstmenus> getPagingDataAhmjxuamMstmenus(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters, boolean isLov) {
        return uam004AhmjxuamMstmenusDao.getPagingDataAhmjxuamMstmenus(first, pageSize, sortField, sortOrder, filters, isLov);
    }

    public DtoRespondPaging pagingMenu(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
//        System.out.println("Ini token+username+appid" +token + "----" +username + "----" +appId + "----" +httpServletRequest + "----" +httpServletResponse);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            int count = getPagingCountAhmjxuamMstmenus(dtoParamPaging.getSearch(), false);
            List<Uam004VoAhmjxuamMstmenus> listData = getPagingDataAhmjxuamMstmenus(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(), dtoParamPaging.getOrder(),
                    dtoParamPaging.getSearch(), false);
            dtoRespondPaging.setRows(listData);
            dtoRespondPaging.setTotal(count);
        }
        return dtoRespondPaging;
    }

    @Transactional(readOnly = false)
    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam004VoAhmjxuamMstmenus uam004VoAhmjxuamMstmenus, String token, String appId) {
        DtoRespond dtoRespond = new DtoRespond();
//        System.out.println("Ini token+username+appid" +token + "----" +username + "----" +appId + "----" +httpServletRequest + "----" +httpServletResponse);
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            AhmjxuamMstmenus ahmjxuamMstmenus = new AhmjxuamMstmenus();
            String vappId = uam004VoAhmjxuamMstmenus.getVapplicationId();
            if (vappId.equals("")) {
                vappId = null;
            }
            String vurl = uam004VoAhmjxuamMstmenus.getVurl();
            if (vurl.equals("")) {
                vurl = null;
            }
            ahmjxuamMstmenus.setVapplicationId(uam004VoAhmjxuamMstmenus.getVapplicationId());
            ahmjxuamMstmenus.setVmenuId(uam004VoAhmjxuamMstmenus.getVmenuId());
            ahmjxuamMstmenus.setVtitle(uam004VoAhmjxuamMstmenus.getVtitle());
            ahmjxuamMstmenus.setVurl(uam004VoAhmjxuamMstmenus.getVurl());
            ahmjxuamMstmenus.setVparent(uam004VoAhmjxuamMstmenus.getVparent().equals("") ? null : uam004VoAhmjxuamMstmenus.getVparent());
            ahmjxuamMstmenus.setVstat("T");
            ahmjxuamMstmenus.setVicon(uam004VoAhmjxuamMstmenus.getVicon());
            uam004AhmjxuamMstmenusDao.save(ahmjxuamMstmenus, username);
            dtoRespond.setMsg(CommonConstant._200Msg);
            dtoRespond.setStat(CommonConstant._200);
            dtoRespond.setDetailMsg("Penambahan Menu berhasil!");
            return dtoRespond;
        }
        return dtoRespond;
    }

    @Transactional(readOnly = false)
    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam004VoAhmjxuamMstmenus uam004VoAhmjxuamMstmenus, String token, String appId, Uam004VoAhmjxuamMstmenus oldObj) {
        DtoRespond dtoRespond = new DtoRespond();
//        System.out.println("Ini token+username+appid" +token + "----" +username + "----" +appId + "----" +httpServletRequest + "----" +httpServletResponse);
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        try {
            if (dtoRespond.getStat().equals(CommonConstant._200)) {
                AhmjxuamMstmenus ahmjxuamMstmenus = new AhmjxuamMstmenus();
                ahmjxuamMstmenus.setVid(uam004VoAhmjxuamMstmenus.getVid());
                ahmjxuamMstmenus.setCreateBy(uam004VoAhmjxuamMstmenus.getCreateBy());
                ahmjxuamMstmenus.setCreateDate(uam004VoAhmjxuamMstmenus.getCreateDate());
                ahmjxuamMstmenus.setIver(uam004VoAhmjxuamMstmenus.getIver());
                ahmjxuamMstmenus.setVicon(uam004VoAhmjxuamMstmenus.getVicon());
                String vappId = uam004VoAhmjxuamMstmenus.getVapplicationId();
                if (vappId.equals("")) {
                    vappId = null;
                }
                ahmjxuamMstmenus.setVapplicationId(vappId);
                ahmjxuamMstmenus.setVmenuId(uam004VoAhmjxuamMstmenus.getVmenuId());
                ahmjxuamMstmenus.setVtitle(uam004VoAhmjxuamMstmenus.getVtitle());
                String vurl = uam004VoAhmjxuamMstmenus.getVurl();
                if (vurl.equals("")) {
                    vurl = null;
                }
                ahmjxuamMstmenus.setVurl(vurl);
                ahmjxuamMstmenus.setVparent(uam004VoAhmjxuamMstmenus.getVidparent());
                if (!uam004VoAhmjxuamMstmenus.getVstat().equals(uam004AhmjxuamMstmenusDao.getStatDesc(oldObj.getVstat()))) {
                    String newStat;
                    if (oldObj.getVstat().equals("T")) {
                        newStat = "F";
                        List<AhmjxuamMstmenus> children = uam004AhmjxuamMstmenusDao.getChildrenMenu(uam004VoAhmjxuamMstmenus.getVid());
                        for (AhmjxuamMstmenus child : children) {
                            child.setVstat(newStat);
                            ahmjxuamMstmenusDao.update(child, username);
                        }
                    } else {
                        newStat = "T";
                    }
                    ahmjxuamMstmenus.setVstat(newStat);
                } else {
                    ahmjxuamMstmenus.setVstat(oldObj.getVstat());
                }
                uam004AhmjxuamMstmenusDao.update(ahmjxuamMstmenus, username);
                dtoRespond.setStat(CommonConstant._200);
                dtoRespond.setMsg(CommonConstant._200Msg);
                dtoRespond.setDetailMsg("Perubahan data menu berhasil!");
            }
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return dtoRespond;
    }

    public DtoRespondPaging getLovParent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
        DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
//        System.out.println("Ini token+username+appid" +token + "----" +username + "----" +appId + "----" +httpServletRequest + "----" +httpServletResponse);
        dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest, httpServletResponse,
                token, appId);
        if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
            dtoRespondPaging.setTotal(getPagingCountAhmjxuamMstmenus(dtoParamPaging.getSearch(), true));
            dtoRespondPaging.setRows(getPagingDataAhmjxuamMstmenus(dtoParamPaging.getOffset(),
                    dtoParamPaging.getLimit(), dtoParamPaging.getSort(),
                    dtoParamPaging.getOrder(), dtoParamPaging.getSearch(), true));
        }
        return dtoRespondPaging;
    }

    public AhmjxuamMstmenusDao getAhmjxuamMstmenusDao() {
        return ahmjxuamMstmenusDao;
    }

    public void setAhmjxuamMstmenusDao(AhmjxuamMstmenusDao ahmjxuamMstmenusDao) {
        this.ahmjxuamMstmenusDao = ahmjxuamMstmenusDao;
    }

    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public Uam004AhmjxuamMstmenusDao getUam004AhmjxuamMstmenusDao() {
        return uam004AhmjxuamMstmenusDao;
    }

    public void setUam004AhmjxuamMstmenusDao(Uam004AhmjxuamMstmenusDao uam004AhmjxuamMstmenusDao) {
        this.uam004AhmjxuamMstmenusDao = uam004AhmjxuamMstmenusDao;
    }

    @Transactional(readOnly = false)
    public DtoRespond disableState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam004VoAhmjxuamMstmenus> list, String token, String appId) {
        DtoRespond dtoRespond;
        String username = dashboardService.getUsername(httpServletRequest);
        dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token, appId);
        if (dtoRespond.getStat().equals(CommonConstant._200)) {
            for (Uam004VoAhmjxuamMstmenus uam004VoAhmjxuamMstmenu : list) {
                String id = uam004VoAhmjxuamMstmenu.getVid();

                System.out.println("VID UPdate " + id);

                AhmjxuamMstmenus ahmjxuamMstmenus = ahmjxuamMstmenusDao.get(id);
                ahmjxuamMstmenus.setVstat("F");
                ahmjxuamMstmenusDao.update(ahmjxuamMstmenus, username);

                List<AhmjxuamMstmenus> children = uam004AhmjxuamMstmenusDao.getChildrenMenu(id);
                for (AhmjxuamMstmenus child : children) {
                    child.setVstat("F");
                    ahmjxuamMstmenusDao.update(child, username);
                }
            }
        }
        return dtoRespond;
    }

    public Uam004VoAhmjxuamMstmenus getMenuById(String vid) {
        AhmjxuamMstmenus ahmjxuamMstmenus = ahmjxuamMstmenusDao.get(vid);
        Uam004VoAhmjxuamMstmenus vo = null;
        if (ahmjxuamMstmenus != null) {
            vo = new Uam004VoAhmjxuamMstmenus();
            vo.setVid(ahmjxuamMstmenus.getVid());
            vo.setIver(ahmjxuamMstmenus.getIver());
            vo.setCreateBy(ahmjxuamMstmenus.getCreateBy());
            vo.setCreateDate(ahmjxuamMstmenus.getCreateDate());
            vo.setVapplicationId(ahmjxuamMstmenus.getVapplicationId());
            vo.setVidparent(ahmjxuamMstmenus.getVparent());
            vo.setVparent(ahmjxuamMstmenus.getAhmjxuamMstmenus().getVtitle());
            vo.setVmenuId(ahmjxuamMstmenus.getVmenuId());
            vo.setVstat(ahmjxuamMstmenus.getVstat());
            vo.setVtitle(ahmjxuamMstmenus.getVtitle());
            vo.setVurl(ahmjxuamMstmenus.getVurl());
        }
        return vo;
    }
}
