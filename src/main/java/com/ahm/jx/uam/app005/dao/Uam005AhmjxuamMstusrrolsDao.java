/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao;

import com.ahm.jx.app000.model.AhmjxuamMstusrrols;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.common.model.AbstractBaseEntity;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmjxuamMstusrrols;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fransisca
 */
public interface Uam005AhmjxuamMstusrrolsDao extends GenericDao<AhmjxuamMstusrrols, String> {

    public int getPagingCountAhmjxuamMstusrrols(Map<String, Object> filters);

    public List<Uam005VoAhmjxuamMstusrrols> getPagingDataAhmjxuamMstusrrols(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public Uam005VoAhmjxuamMstusrrols getUserRoleById(String vid);
}
