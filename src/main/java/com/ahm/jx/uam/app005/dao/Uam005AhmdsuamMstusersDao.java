/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao;

import com.ahm.jx.app000.model.AhmdsuamMstusers;
import com.ahm.jx.app000.vo.VoAhmdsuamMstusers;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fransisca
 */
public interface Uam005AhmdsuamMstusersDao extends GenericDao<AhmdsuamMstusers, String> {

    public int getPagingCountAhmsuamMstusers(Map<String, Object> filters);

    public List<VoAhmdsuamMstusers> getPagingDataAhmdsh1cMstusers(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);
}
