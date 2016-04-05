/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.service;

import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmjxuamMstservice;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sigit
 */
public interface Uam003Service {

    public int getPagingCountAhmjxuamMstservice(Map<String, Object> filters);

    public List<Uam003VoAhmjxuamMstservice> getPagingDataAhmjxuamMstservice(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public DtoRespond disableState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam003VoAhmjxuamMstservice> list, String token, String appId);

    public DtoRespondPaging pagingService(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservice, String token, String appId);

    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservice, String token, String appId, Uam003VoAhmjxuamMstservice oldObj);

    public Uam003VoAhmjxuamMstservice getServiceById(String vid);
    
    public DtoRespondPaging getLovApp(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);

}
