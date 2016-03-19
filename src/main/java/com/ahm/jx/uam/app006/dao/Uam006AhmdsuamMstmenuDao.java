/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.dao;

import com.ahm.jx.app000.vo.VoAhmdsuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmdsuamMstusers;
import java.util.List;
import java.util.Map;

/**
 *
 * @author george
 */
public interface Uam006AhmdsuamMstmenuDao {

    public int getPagingCountAhmsuamMstmenus(Map<String, Object> filters);

    public List<VoAhmdsuamMstmenus> getPagingDataAhmdsh1cMstmenus(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public String getParentId(String vidAhmdsuamMstmenus);

    public boolean isParentExist(String parent, String rolesId);
    
}
