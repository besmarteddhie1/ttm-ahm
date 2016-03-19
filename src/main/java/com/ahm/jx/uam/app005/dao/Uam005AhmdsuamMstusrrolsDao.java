/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao;

import com.ahm.jx.app000.model.AhmdsuamMstusrrols;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.common.model.AbstractBaseEntity;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmdsuamMstusrrols;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fransisca
 */
public interface Uam005AhmdsuamMstusrrolsDao extends GenericDao<AhmdsuamMstusrrols, String> {

    public int getPagingCountAhmdsuamMstusrrols(Map<String, Object> filters);

    public List<Uam005VoAhmdsuamMstusrrols> getPagingDataAhmdsuamMstusrrols(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public Uam005VoAhmdsuamMstusrrols getUserRoleById(String vid);
}
