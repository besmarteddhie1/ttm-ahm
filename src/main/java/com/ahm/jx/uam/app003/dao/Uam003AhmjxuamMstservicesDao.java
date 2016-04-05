/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.dao;

import com.ahm.jx.app000.model.AhmjxuamMstservices;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmjxuamMstservice;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sigit
 */
public interface Uam003AhmjxuamMstservicesDao extends GenericDao<AhmjxuamMstservices, String> {

    public int getPagingCountAhmjxuamMstservices(Map<String, Object> filters);

    public List<Uam003VoAhmjxuamMstservice> getPagingDataAhmjxuamMstservices(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public String getStatDesc(String vstat);

}
