/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app001.dao;

import com.ahm.jx.uam.app001.vo.Uam001Vodlr;
import java.util.List;
import java.util.Map;

/**
 *
 * @author george
 */
public interface Uam001AhmjxuamMstpartnerDao {

    public List<Uam001Vodlr> getPagingDataAhmjxuamMstpartner(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public int getPagingCountAhmjxuamMstpartner(Map<String, Object> filters);

}
