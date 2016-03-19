/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.rest;

import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app003.service.Uam003Service;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmdsuamMstroles;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author indriHtb
 */

@Controller
@RequestMapping("/uam003")
public class Uam003Rest {
    
    private final String appId = "AHMDSUAM003";
    
    @Autowired
    @Qualifier("uam003Service")
    private Uam003Service uam003Service;
    
    @Autowired
    @Qualifier("dashboardService")
    private DashboardService dashboardService;

    public Uam003Service getUam003Service() {
        return uam003Service;
    }

    public void setUam003Service(Uam003Service uam003Service) {
        this.uam003Service = uam003Service;
    }

    public DashboardService getDashboardService() {
        return dashboardService;
    }

    public void setDashboardService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }
    
    @RequestMapping(value = "paging", method = RequestMethod.POST,
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespondPaging pagingRole(HttpServletRequest httpServletRequest,
    HttpServletResponse httpServletResponse,
    @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims,
    @RequestBody DtoParamPaging dtoParamPaging) {
        
        DtoRespondPaging respondPaging = uam003Service.pagingRole(httpServletRequest, 
                httpServletResponse, dtoParamPaging, cookieDims, appId);      
        return respondPaging;
    }
    
    @RequestMapping(value = "insert", method = RequestMethod.POST,
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond insertRole(HttpServletRequest httpServletRequest,
    @RequestBody Uam003VoAhmdsuamMstroles uam003VoAhmdsuamMstroles,
    HttpServletResponse httpServletResponse,
    @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try{
            dtoRespond = uam003Service.insert(httpServletRequest, httpServletResponse, 
                uam003VoAhmdsuamMstroles, cookieDims, appId);
        }catch(ConstraintViolationException dive){ 
            dive.printStackTrace();                    
            dtoRespond.setDetailMsg("Gagal Insert Integrity Constraint");
            dtoRespond.setStat(CommonConstant._500);            
            dtoRespond.setMsg(CommonConstant._500Msg);
            return dtoRespond;
        }catch(Exception e){
            e.printStackTrace();
            dtoRespond.setStat(CommonConstant._500);            
            dtoRespond.setMsg(CommonConstant._500Msg);
            dtoRespond.setDetailMsg(e.getMessage());        
            return dtoRespond;            
        }
        return dtoRespond;
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST,
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoRespond updateRole(HttpServletRequest httpServletRequest,
    @RequestBody Uam003VoAhmdsuamMstroles uam003VoAhmdsuamMstroles,
    HttpServletResponse httpServletResponse,
    @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims) {
        DtoRespond dtoRespond = new DtoRespond();
        try{
            Uam003VoAhmdsuamMstroles oldObj=uam003Service.getRoleById(uam003VoAhmdsuamMstroles.getVid());
            if(oldObj!=null){
                uam003VoAhmdsuamMstroles.setVcrea(oldObj.getVcrea());
                uam003VoAhmdsuamMstroles.setDcrea(oldObj.getDcrea());
             dtoRespond = uam003Service.update(httpServletRequest, httpServletResponse, 
                    uam003VoAhmdsuamMstroles, cookieDims, appId);            
            } else{
                dtoRespond.setStat(CommonConstant._404);
                dtoRespond.setMsg(CommonConstant._404Msg);
                dtoRespond.setDetailMsg("Data tidak ditemukan");
            }
            return dtoRespond;
        }catch(HibernateOptimisticLockingFailureException holfe){
            holfe.printStackTrace();
            Uam003VoAhmdsuamMstroles temp = uam003Service.getRoleById(uam003VoAhmdsuamMstroles.getVid());
            if(temp!=null){
                List<Uam003VoAhmdsuamMstroles> list = new ArrayList<Uam003VoAhmdsuamMstroles>();
                list.add(temp);
                dtoRespond.setRows(list);
            }
            dtoRespond.setStat("409");            
            dtoRespond.setMsg("Conflict");
            dtoRespond.setDetailMsg("Update failed data was updated or deleted by another user");                        
            return dtoRespond;
        }catch(Exception e){
            e.printStackTrace();
            dtoRespond.setMsg(e.getMessage());
            dtoRespond.setStat(CommonConstant._0);
            return dtoRespond;
        }
    }
    
    @RequestMapping(value = "disable", method = RequestMethod.POST,
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody DtoRespond disableRole(HttpServletRequest httpServletRequest,
    @RequestBody List<Uam003VoAhmdsuamMstroles> uam003VoAhmdsuamMstroles,
    HttpServletResponse httpServletResponse,
    @CookieValue(value = CommonConstant.cookieDims, defaultValue = "") String cookieDims){
        DtoRespond dtoRespond = new DtoRespond();
        try{
             dtoRespond = uam003Service.disableRoleState(httpServletRequest, httpServletResponse, 
                    uam003VoAhmdsuamMstroles, cookieDims, appId);   
            return dtoRespond;
        }catch(HibernateOptimisticLockingFailureException holfe){
            holfe.printStackTrace();
            dtoRespond.setStat("409");            
            dtoRespond.setMsg("Conflict");
            dtoRespond.setDetailMsg("Disable State failed data was updated or deleted by another user");                        
            return dtoRespond;
        }catch(Exception e){
            e.printStackTrace();
            dtoRespond.setMsg(e.getMessage());
            dtoRespond.setStat(CommonConstant._0);
            return dtoRespond;
        }
    }       
}
