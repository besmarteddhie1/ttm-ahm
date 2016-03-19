/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao;

import com.ahm.jx.app000.model.AhmdsuamHdrrlaccess;
import com.ahm.jx.app000.vo.VoAhmdsuamDtlrlaccess;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;

/**
 *
 * @author achmad.ha
 */
public interface DashboardAhmdsuamHdrrlaccessDao extends GenericDao<AhmdsuamHdrrlaccess, String>{
    
    public String[] getDetailRoleAccess(String[] vidRoles);
    
}
