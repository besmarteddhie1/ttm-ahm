/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.dao;

import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import java.util.List;
import java.util.Map;

/**
 *
 * @author george
 */
public interface Uam006AhmjxuamMstrolesDao {

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters);

    public List<VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

}
