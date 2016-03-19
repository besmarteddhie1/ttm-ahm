/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app002.dao;

import com.ahm.jx.uam.app002.vo.Uam002Vodlr;
import java.util.List;
import java.util.Map;

/**
 *
 * @author george
 */
public interface Uam002AhmdsbscMstdlrcodeDao {

    public List<Uam002Vodlr> getPagingDataAhmdsbscMstdealer(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public int getPagingCountAhmdsbscMstdlrcode(Map<String, Object> filters);
    
}
