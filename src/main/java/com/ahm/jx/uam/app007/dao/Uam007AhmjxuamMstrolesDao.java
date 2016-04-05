package com.ahm.jx.uam.app007.dao;

import java.util.List;
import java.util.Map;

import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;

/**
*
* @author Ferdy
*/
public interface Uam007AhmjxuamMstrolesDao {

	public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters);

    public List<VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

}
