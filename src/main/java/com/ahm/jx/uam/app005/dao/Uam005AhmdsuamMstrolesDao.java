/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao;

import com.ahm.jx.app000.model.AhmdsuamMstroles;
import com.ahm.jx.app000.vo.VoAhmdsuamMstroles;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fransisca
 */
public interface Uam005AhmdsuamMstrolesDao extends GenericDao<AhmdsuamMstroles, String> {

    public int getPagingCountAhmdsuamMstroles(Map<String, Object> filters);

    public List<VoAhmdsuamMstroles> getPagingDataAhmdsuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);
}
