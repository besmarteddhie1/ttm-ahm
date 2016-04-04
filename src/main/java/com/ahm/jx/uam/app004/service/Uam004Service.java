package com.ahm.jx.uam.app004.service;

import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app004.vo.Uam004VoAhmjxuamMstmenus;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elisa
 */
public interface Uam004Service {

    public DtoRespond getListIcon(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            String token, String appId);

    public int getPagingCountAhmjxuamMstmenus(Map<String, Object> filters, boolean isLov);

    public List<Uam004VoAhmjxuamMstmenus> getPagingDataAhmjxuamMstmenus(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters, boolean isLov);

    public DtoRespondPaging pagingMenu(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam004VoAhmjxuamMstmenus uam004VoAhmjxuamMstmenus, String token, String appId);

    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam004VoAhmjxuamMstmenus uam004VoAhmjxuamMstmenus, String token, String appId, Uam004VoAhmjxuamMstmenus oldObj);

    public DtoRespondPaging getLovParent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespond disableState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam004VoAhmjxuamMstmenus> uam004VoAhmjxuamMstmenus, String token, String appId);

    public Uam004VoAhmjxuamMstmenus getMenuById(String vid);
}
