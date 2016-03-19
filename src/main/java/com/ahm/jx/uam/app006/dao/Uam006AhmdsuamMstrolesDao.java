/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.dao;

import com.ahm.jx.app000.vo.VoAhmdsuamMstroles;
import java.util.List;
import java.util.Map;

/**
 *
 * @author george
 */
public interface Uam006AhmdsuamMstrolesDao {

    public int getPagingCountAhmdsuamMstroles(Map<String, Object> filters);

    public List<VoAhmdsuamMstroles> getPagingDataAhmdsuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);
    
}
