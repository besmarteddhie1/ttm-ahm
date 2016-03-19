/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao;

import com.ahm.jx.app000.model.AhmdsuamTxnbookmark;
import com.ahm.jx.app000.vo.VoAhmdsuamMstmenus;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;

/**
 *
 * @author achmad.ha
 */
public interface DashboardAhmdsuamTxnbookmarkDao extends GenericDao<AhmdsuamTxnbookmark, String>{
    
    public List<VoAhmdsuamMstmenus> getMenusBookmark(String username);
    public List<VoAhmdsuamMstmenus> getMenusBookmarkDefault(String username);
    public String getBookMarkVid(String username,String applicationId);
    
}
