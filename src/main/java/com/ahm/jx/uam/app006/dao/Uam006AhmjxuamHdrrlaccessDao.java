/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.dao;

import com.ahm.jx.app000.model.AhmjxuamHdrrlaccess;
import com.ahm.jx.uam.app006.vo.Uam006VoAhmjxuamHdrrlaccess;
import java.util.List;
import java.util.Map;

/**
 *
 * @author george
 */
public interface Uam006AhmjxuamHdrrlaccessDao {

    public int getPagingCountAhmjxuamHdrrlaccess(Map<String, Object> filters);

    public List<Uam006VoAhmjxuamHdrrlaccess> getPagingDataAhmjxuamHdrrlaccess(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public boolean isHasNeighbour(String vid, String role, String parent);

    public AhmjxuamHdrrlaccess getParentRoleAccess(String role, String parent);

}
