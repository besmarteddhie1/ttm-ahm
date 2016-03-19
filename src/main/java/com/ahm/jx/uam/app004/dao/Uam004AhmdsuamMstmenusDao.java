package com.ahm.jx.uam.app004.dao;

import com.ahm.jx.app000.model.AhmdsuamMstmenus;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.uam.app004.vo.Uam004VoAhmdsuamMstmenus;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Elisa
 */
public interface Uam004AhmdsuamMstmenusDao extends GenericDao<AhmdsuamMstmenus, String>{
    public int getPagingCountAhmdsuamMstmenus(Map<String, Object> filters, boolean isLov);
    public List<Uam004VoAhmdsuamMstmenus> getPagingDataAhmdsuamMstmenus(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters, boolean isLov);  
    public String getStatDesc(String vstat);
    public List<AhmdsuamMstmenus> getChildrenMenu(String id);
}
