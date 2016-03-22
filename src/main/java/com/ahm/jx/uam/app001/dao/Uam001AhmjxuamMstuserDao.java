/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app001.dao;

import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.uam.app001.vo.Uam001VoAhmjxuamMstuser;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lexys.jo
 */
public interface Uam001AhmjxuamMstuserDao extends GenericDao<AhmjxuamMstusers, String> {

    public int getPagingCountAhmjxuamMstuser(Map<String, Object> filters);

    public List<Uam001VoAhmjxuamMstuser> getPagingDataAhmjxuamMstuser(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

}
