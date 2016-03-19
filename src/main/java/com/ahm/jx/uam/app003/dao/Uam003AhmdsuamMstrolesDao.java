/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.dao;

import com.ahm.jx.app000.model.AhmdsuamMstroles;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmdsuamMstroles;
import java.util.List;
import java.util.Map;
/**
 *
 * @author indriHtb
 */
public interface Uam003AhmdsuamMstrolesDao extends GenericDao<AhmdsuamMstroles, String> {
    
    public int getPagingCountAhmdsuamMstroles(Map<String, Object> filters);
    public List<Uam003VoAhmdsuamMstroles> getPagingDataAhmdsuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);
    
    
}
