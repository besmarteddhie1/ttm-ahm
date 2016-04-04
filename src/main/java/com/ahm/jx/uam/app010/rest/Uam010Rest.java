/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app010.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.ahm.jx.uam.app010.service.Uam010Service;

/**
 *
 * @author hendra.fs
 */
@Controller
@RequestMapping("/uam010")
public class Uam010Rest {

    private final String appId = "AHMJXUAM010";
    private final String FILE_EXTENSION = "lic";
    private final String SESSION_KEY_IMAGE = "AHMJXUAM010FILE";
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;
    @Autowired
    @Qualifier("uam010Service")
    private Uam010Service uam010Service;

    @RequestMapping(value = "paging", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging pagingDealerLicense(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
            @RequestBody DtoParamPaging dtoParamPaging) {
        DtoRespondPaging respondPaging = uam010Service.pagingDealerLicense(httpServletRequest,
                httpServletResponse, dtoParamPaging, cookieDims, appId);
        return respondPaging;
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public @ResponseBody
    DtoRespond uploadLicense(@RequestParam(value = "fileToUpload", required = true) MultipartFile multipartFile,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {

        System.out.println("Masuk Upload");
        List<String> listMsg = new ArrayList<String>();
        DtoRespond dtoRespond = new DtoRespond();

        if (multipartFile.isEmpty() || multipartFile == null) {
            listMsg.add("No file uploaded");
            dtoRespond.setMsg(CommonConstant._500Msg);
            dtoRespond.setStat(CommonConstant._500);
            dtoRespond.setDtlMsg(listMsg);
        } else {
            String extension = dashboardService.tokenizer(multipartFile.getOriginalFilename(), ".");
            System.out.println("extension : " + extension);
            if (FILE_EXTENSION.equals(extension.toLowerCase())) {
                try {
                    String filename = multipartFile.getOriginalFilename();
                    String targetFile = CommonConstant.tempFolder + filename;
                    multipartFile.transferTo(new File(targetFile));
                    httpServletRequest.getSession().setAttribute(SESSION_KEY_IMAGE, targetFile);
                    dtoRespond = uam010Service.extractFile(httpServletRequest,
                            httpServletResponse, targetFile, cookieDims, appId);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    listMsg.add(ex.getMessage());
                    dtoRespond.setDtlMsg(listMsg);
                    dtoRespond.setMsg(CommonConstant._500Msg);
                    dtoRespond.setStat(CommonConstant._500);
                } catch (IllegalStateException ex) {
                    ex.printStackTrace();
                    listMsg.add(ex.getMessage());
                    dtoRespond.setDtlMsg(listMsg);
                    dtoRespond.setMsg(CommonConstant._500Msg);
                    dtoRespond.setStat(CommonConstant._500);
                }
            } else {
                listMsg.add("File extensions not permitted");
                dtoRespond.setDtlMsg(listMsg);
                dtoRespond.setMsg(CommonConstant._500Msg);
                dtoRespond.setStat(CommonConstant._500);
            }
        }

        return dtoRespond;
    }

    // Setter Getter
    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public Uam010Service getUam010Service() {
        return uam010Service;
    }

    public void setUam010Service(Uam010Service uam010Service) {
        this.uam010Service = uam010Service;
    }
}
