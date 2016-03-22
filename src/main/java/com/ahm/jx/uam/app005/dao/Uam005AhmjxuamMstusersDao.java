/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao;

import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.app000.vo.VoAhmjxuamMstusers;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fransisca
 */
public interface Uam005AhmjxuamMstusersDao extends GenericDao<AhmjxuamMstusers, String> {

    public int getPagingCountAhmsuamMstusers(Map<String, Object> filters);

    public List<VoAhmjxuamMstusers> getPagingDataAhmjxh1cMstusers(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);
}
