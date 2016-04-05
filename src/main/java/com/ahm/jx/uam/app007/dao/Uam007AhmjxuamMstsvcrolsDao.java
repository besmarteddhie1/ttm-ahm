package com.ahm.jx.uam.app007.dao;

import java.util.List;
import java.util.Map;

import com.ahm.jx.app000.model.AhmjxuamMstsvcrols;
import com.ahm.jx.uam.app007.vo.Uam007VoAhmjxuamMstsvcrols;;

/**
*
* @author Ferdy
*/
public interface Uam007AhmjxuamMstsvcrolsDao {

	public int getPagingCountAhmjxuamMstsvcrols(Map<String, Object> filters);

    public List<Uam007VoAhmjxuamMstsvcrols> getPagingDataAhmjxuamMstsvcrols(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

//    public Uam007VoAhmjxuamMstsvcrols getSvcRoleById(String vid);

}
