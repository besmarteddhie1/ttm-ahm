/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app002.service;

import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app002.vo.Uam002VoAhmjxuamMstroles;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author indriHtb
 */
public interface Uam002Service {

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters);

    public List<Uam002VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public DtoRespond disableRoleState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam002VoAhmjxuamMstroles> list, String token, String appId);

    public DtoRespondPaging pagingRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam002VoAhmjxuamMstroles uam002VoAhmjxuamMstroles, String token, String appId);

    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam002VoAhmjxuamMstroles uam002VoAhmjxuamMstroles, String token, String appId);

    public Uam002VoAhmjxuamMstroles getRoleById(String vid);
}
