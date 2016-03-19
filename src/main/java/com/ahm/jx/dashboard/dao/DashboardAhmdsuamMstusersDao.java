/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao;

import com.ahm.jx.app000.model.AhmdsuamMstusers;
import com.ahm.jx.app000.vo.VoAhmdsbscMstdlrcode;
import com.ahm.jx.app000.vo.VoAhmdsuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmdsuamMstroles;
import com.ahm.jx.app000.vo.VoAhmdsuamMstusers;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.dashboard.vo.VoChangePassword;
import java.util.List;

/**
 *
 * @author achmad.ha
 */
public interface DashboardAhmdsuamMstusersDao extends GenericDao<AhmdsuamMstusers, String> {
    
    public List<VoAhmdsuamMstmenus> getMenuByUser(String userName);
    public AhmdsuamMstusers getAhmdsuamMstuserByUsername(String userName);
    public VoAhmdsbscMstdlrcode getDealerInfoByUsername(String userName);
    public VoAhmdsuamMstmenus getMenuByUserByAppid(String userName,String appId);
    public List<VoAhmdsuamMstroles> getRoleByAppAndUser(String username,String vid); 
    
}
