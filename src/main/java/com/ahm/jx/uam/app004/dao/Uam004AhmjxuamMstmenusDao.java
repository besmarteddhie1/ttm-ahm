package com.ahm.jx.uam.app004.dao;

import com.ahm.jx.app000.model.AhmjxuamMstmenus;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.uam.app004.vo.Uam004VoAhmjxuamMstmenus;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Elisa
 */
public interface Uam004AhmjxuamMstmenusDao extends GenericDao<AhmjxuamMstmenus, String> {

    public int getPagingCountAhmjxuamMstmenus(Map<String, Object> filters, boolean isLov);

    public List<Uam004VoAhmjxuamMstmenus> getPagingDataAhmjxuamMstmenus(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters, boolean isLov);

    public String getStatDesc(String vstat);

    public List<AhmjxuamMstmenus> getChildrenMenu(String id);
}
