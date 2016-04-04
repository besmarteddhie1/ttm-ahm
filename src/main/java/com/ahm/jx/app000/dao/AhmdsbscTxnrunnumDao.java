/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao;

import com.ahm.jx.app000.model.AhmdsbscTxnrunnum;
import com.ahm.jx.common.dao.GenericDao;

/**
 *
 * @author achmad.ha
 */
public interface AhmdsbscTxnrunnumDao extends GenericDao<AhmdsbscTxnrunnum,String>{
    
    public Integer getValue(String idrunnum,String reset,String kodeDealer,String userId);
    
}
