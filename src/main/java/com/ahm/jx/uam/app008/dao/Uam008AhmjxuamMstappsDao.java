/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app008.dao;

import com.ahm.jx.app000.model.AhmjxuamMstapps;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmjxuamMstservice;
import com.ahm.jx.uam.app008.vo.Uam008VoAhmjxuamMstapps;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sigit
 */
public interface Uam008AhmjxuamMstappsDao extends GenericDao<AhmjxuamMstapps, String> {

    public int getPagingCountAhmjxuamMstapps(Map<String, Object> filters);

    public List<Uam008VoAhmjxuamMstapps> getPagingDataAhmjxuamMstapps(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

}
