/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app002.dao;

import com.ahm.jx.app000.model.AhmjxuamMstroles;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.uam.app002.vo.Uam002VoAhmjxuamMstroles;
import java.util.List;
import java.util.Map;

/**
 *
 * @author indriHtb
 */
public interface Uam002AhmjxuamMstrolesDao extends GenericDao<AhmjxuamMstroles, String> {

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters);

    public List<Uam002VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

}
