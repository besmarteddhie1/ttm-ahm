package com.ahm.jx.uam.app007.dao;

import java.util.List;
import java.util.Map;

import com.ahm.jx.app000.vo.VoAhmjxuamMstservices;

/**
*
* @author Ferdy
*/
public interface Uam007AhmjxuamMstsvcsDao {

	public int getPagingCountAhmjxuamMstsvcs(Map<String, Object> filters);

    public List<VoAhmjxuamMstservices> getPagingDataAhmjxuamMstsvcs(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

}

