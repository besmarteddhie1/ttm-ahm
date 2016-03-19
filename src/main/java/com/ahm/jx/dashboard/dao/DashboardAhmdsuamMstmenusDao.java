/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao;

import com.ahm.jx.app000.model.AhmdsuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmdsuamMstmenus;
import com.ahm.jx.common.dao.GenericDao;

/**
 *
 * @author achmad.ha
 */
public interface DashboardAhmdsuamMstmenusDao extends GenericDao<AhmdsuamMstmenus, String>{
    
    public VoAhmdsuamMstmenus getMenuByMenuIdAndAppId(String menuId,String appId);
    public VoAhmdsuamMstmenus getMenuByAppId(String appId);
    
    
}
