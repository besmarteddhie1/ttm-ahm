/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.service;

import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.app000.vo.VoAhmjxuamMstusers;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmjxuamMstusrrols;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fransisca
 */
public interface Uam005Service {

    public int getPagingCountAhmjxuamMstusrrols(Map<String, Object> filters);

    public List<Uam005VoAhmjxuamMstusrrols> getPagingDataAhmjxuamMstusrrols(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public Uam005VoAhmjxuamMstusrrols getUserrolesById(String vid);
//    public List<VoAhmdsbscDtlsetting> getDetailSettingTipeWarehouse();

    public int getPagingCountAhmjxuamMstusers(Map<String, Object> filters);

    public List<VoAhmjxuamMstusers> getPagingDataAhmjxuamMstusers(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters);

    public List<VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public DtoRespondPaging pagingUserRoles(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespondPaging getLovUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespondPaging getLovRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespond insertUserRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam005VoAhmjxuamMstusrrols uam005VoAhmjxuamMstusrrols, String token, String appId);

    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam005VoAhmjxuamMstusrrols uam005VoAhmjxuamMstusrrols, String token, String appId);

    public DtoRespond delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam005VoAhmjxuamMstusrrols> uam005VoAhmjxuamMstusrrols, String token, String appId);
}
