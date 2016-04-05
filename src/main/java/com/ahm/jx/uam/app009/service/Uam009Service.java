/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app009.service;

import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ferdy
 */
public interface Uam009Service {

    public DtoRespond listActive(HttpServletRequest httpServletRequest, String token, Integer diff);
    
//    public DtoRespondPaging pagingAppsUsage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);
    
    public boolean validateToken(String cookieDims, HttpServletRequest httpServletRequest);
    
}
