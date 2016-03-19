/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app010.dao;

import com.ahm.jx.app000.model.AhmjxuamMstpartner;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.uam.app010.vo.Uam010VoAhmjxuamMstpartner;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hendra.fs
 */
public interface Uam010AhmjxuamMstpartnerDao extends GenericDao<AhmjxuamMstpartner, String> {

    public AhmjxuamMstpartner findByDealerCode(String dealerCode);

    public int getPagingCountAhmjxuamMstpartner(Map<String, Object> filters);

    public List<Uam010VoAhmjxuamMstpartner> getPagingDataAhmjxuamMstpartner(int first, int pageSize,
            String sortField, String sortOrder, Map<String, Object> filters);
}
