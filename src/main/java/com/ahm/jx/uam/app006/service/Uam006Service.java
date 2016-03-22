/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.service;

import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app006.vo.Uam006VoAhmjxuamHdrrlaccess;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author george
 */
public interface Uam006Service {

    public DtoRespond insertRoleAccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam006VoAhmjxuamHdrrlaccess uam006VoAhmdsuamMstusrrols, String token, String appId);

    public DtoRespond delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam006VoAhmjxuamHdrrlaccess> uam006VoAhmdsuamMstusrrols, String token, String appId);

    public DtoRespondPaging pagingRoleAccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespondPaging getLovMenu(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespondPaging getLovRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);
    
}
