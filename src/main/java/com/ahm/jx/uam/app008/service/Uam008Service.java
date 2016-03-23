/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app008.service;

import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app008.vo.Uam008VoAhmjxuamMstapps;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sigit
 */
public interface Uam008Service {

    public int getPagingCountAhmjxuamMstapps(Map<String, Object> filters);

    public List<Uam008VoAhmjxuamMstapps> getPagingDataAhmjxuamMstapps(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public DtoRespond disableState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam008VoAhmjxuamMstapps> list, String token, String appId);

    public DtoRespondPaging pagingApps(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam008VoAhmjxuamMstapps uam008VoAhmjxuamMstapps, String token, String appId);

    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam008VoAhmjxuamMstapps uam008VoAhmjxuamMstapps, String token, String appId);

    public Uam008VoAhmjxuamMstapps getAppsById(String vid);

}
