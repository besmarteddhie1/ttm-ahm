/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.dao;

import com.ahm.jx.app000.model.AhmdsuamHdrrlaccess;
import com.ahm.jx.uam.app006.vo.Uam006VoAhmdsuamHdrrlaccess;
import java.util.List;
import java.util.Map;

/**
 *
 * @author george
 */
public interface Uam006AhmdsuamHdrrlaccessDao {

    public int getPagingCountAhmdsuamHdrrlaccess(Map<String, Object> filters);

    public List<Uam006VoAhmdsuamHdrrlaccess> getPagingDataAhmdsuamHdrrlaccess(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public boolean isHasNeighbour(String vid, String role, String parent);

    public AhmdsuamHdrrlaccess getParentRoleAccess(String role, String parent);

}
