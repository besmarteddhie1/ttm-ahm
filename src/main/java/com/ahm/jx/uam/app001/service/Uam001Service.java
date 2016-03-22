/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app001.service;

import com.ahm.jx.app000.vo.VoAhmdsbscDtlsetting;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
//import com.ahm.jx.h1c.app006.vo.H1c006VoAhmdsh1cMstidwhs;
//import com.ahm.jx.h1c.app008.vo.H1c008VoAhmdsh1cMstemployee;
import com.ahm.jx.uam.app001.vo.Uam001VoAhmjxuamMstuser;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lexys.jo
 */
public interface Uam001Service {

    public int getPagingCountAhmjxuamMstuser(Map<String, Object> filters);

    public List<Uam001VoAhmjxuamMstuser> getPagingDataAhmjxuamMstuser(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public DtoRespondPaging pagingUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam001VoAhmjxuamMstuser uam001VoAhmjxuamMstuser, String token, String appId);

    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam001VoAhmjxuamMstuser uam001VoAhmjxuamMstuser, String token, String appId);

    public DtoRespond disableState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam001VoAhmjxuamMstuser> list, String token, String appId);

    public DtoRespond resetPassword(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam001VoAhmjxuamMstuser> list, String token, String appId);

    public Uam001VoAhmjxuamMstuser getUserById(String vid);

    public DtoRespondPaging getLovDealer(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

}
