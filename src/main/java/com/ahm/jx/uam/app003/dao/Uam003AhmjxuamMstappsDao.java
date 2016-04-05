package com.ahm.jx.uam.app003.dao;

import java.util.List;
import java.util.Map;

import com.ahm.jx.uam.app003.vo.Uam003VoApp;

public interface Uam003AhmjxuamMstappsDao {
	
	public List<Uam003VoApp> getPagingDataAhmjxuamMstapps(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public int getPagingCountAhmjxuamMstapps(Map<String, Object> filters);

}
