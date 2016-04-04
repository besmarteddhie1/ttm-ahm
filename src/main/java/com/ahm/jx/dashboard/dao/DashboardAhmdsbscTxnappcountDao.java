/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao;

import com.ahm.jx.app000.model.AhmdsbscTxnappcount;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.dashboard.vo.VoCounterApp;

/**
 *
 * @author achmad.ha
 */
public interface DashboardAhmdsbscTxnappcountDao extends GenericDao<AhmdsbscTxnappcount, String>{
    
    public void addCounter(VoCounterApp voCounterApp,String username);
    public AhmdsbscTxnappcount getCounter(VoCounterApp voCounterApp);
}
