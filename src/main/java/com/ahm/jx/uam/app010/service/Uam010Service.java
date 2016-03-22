/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app010.service;

import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hendra.fs
 */
public interface Uam010Service {

    public DtoRespondPaging pagingDealerLicense(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging,
            String token, String appId);

    public DtoRespond extractFile(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, String targetFile,
            String token, String appId);
}
