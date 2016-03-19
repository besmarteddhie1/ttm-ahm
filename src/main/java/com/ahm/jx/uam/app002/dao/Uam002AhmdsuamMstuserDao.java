/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app002.dao;

import com.ahm.jx.app000.model.AhmdsuamMstusers;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.uam.app002.vo.Uam002VoAhmdsuamMstuser;
import java.util.List;
import java.util.Map;
/**
 *
 * @author lexys.jo
 */
public interface Uam002AhmdsuamMstuserDao extends GenericDao<AhmdsuamMstusers, String>{
    
    public int getPagingCountAhmdsuamMstuser (Map<String, Object> filters);
    public List <Uam002VoAhmdsuamMstuser> getPagingDataAhmdsuamMstuser(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);
    
}