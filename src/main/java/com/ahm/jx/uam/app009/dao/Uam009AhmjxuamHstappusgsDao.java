/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app009.dao;

import com.ahm.jx.app000.model.AhmjxuamHstappusgs;
import com.ahm.jx.uam.app009.vo.Uam009VoAhmjxuamHstappusgs;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ferdy
 */
public interface Uam009AhmjxuamHstappusgsDao {

    public List<Uam009VoAhmjxuamHstappusgs> getActive(Integer diff);
    
//    public int getPagingCount(Map<String, Object> filters);

//    public List<Uam009VoAhmjxuamHstappusgs> getPagingData(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    
}
