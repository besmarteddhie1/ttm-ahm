/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao;

import com.ahm.jx.app000.model.AhmjxuamMstroles;
import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fransisca
 */
public interface Uam005AhmjxuamMstrolesDao extends GenericDao<AhmjxuamMstroles, String> {

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters);

    public List<VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);
}
