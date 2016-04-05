package com.ahm.jx.uam.app007.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.app000.vo.VoAhmjxuamMstservices;
import com.ahm.jx.app000.vo.VoAhmjxuamMstusers;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmjxuamMstusrrols;
import com.ahm.jx.uam.app007.vo.Uam007VoAhmjxuamMstsvcrols;

/**
*
* @author Ferdy
*/

public interface Uam007Service {
	
	 	public int getPagingCountAhmjxuamMstsvcRols(Map<String, Object> filters);

	    public List<Uam007VoAhmjxuamMstsvcrols> getPagingDataAhmjxuamMstsvcrols(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

//	    public Uam007VoAhmjxuamMstsvcrols getSvcrolesById(String vid);

	    public int getPagingCountAhmjxuamMstsvcs(Map<String, Object> filters);

	    public List<VoAhmjxuamMstservices> getPagingDataAhmjxuamMstsvcs(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

	    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters);

	    public List<VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

	    public DtoRespondPaging pagingSvcRoles(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

	    public DtoRespondPaging getLovSvc(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

	    public DtoRespondPaging getLovRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

	    public DtoRespond insertSvcRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam007VoAhmjxuamMstsvcrols uam007VoAhmjxuamMstsvcrols, String token, String appId);

	    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam007VoAhmjxuamMstsvcrols uam007VoAhmjxuamMstsvcrols, String token, String appId);

	    public DtoRespond delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam007VoAhmjxuamMstsvcrols> uam007VoAhmjxuamMstsvcrols, String token, String appId);
}
