/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.service;

import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmdsuamMstroles;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author indriHtb
 */
public interface Uam003Service {
    
    public int getPagingCountAhmdsuamMstroles(Map<String, Object> filters);
    public List<Uam003VoAhmdsuamMstroles> getPagingDataAhmdsuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);    
    public DtoRespond disableRoleState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, List<Uam003VoAhmdsuamMstroles> list, String token, String appId);
    
    public DtoRespondPaging pagingRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId);
    
    public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam003VoAhmdsuamMstroles uam003VoAhmdsuamMstroles, String token, String appId);
    
    public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Uam003VoAhmdsuamMstroles uam003VoAhmdsuamMstroles, String token, String appId);

    public Uam003VoAhmdsuamMstroles getRoleById(String vid);
}
