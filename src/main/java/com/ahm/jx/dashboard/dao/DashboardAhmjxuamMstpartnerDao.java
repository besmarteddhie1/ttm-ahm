/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao;

import com.ahm.jx.app000.model.AhmjxuamMstpartner;
import com.ahm.jx.common.dao.GenericDao;

/**
 *
 * @author hendra.fs
 */
public interface DashboardAhmjxuamMstpartnerDao extends GenericDao<AhmjxuamMstpartner, String> {

    public AhmjxuamMstpartner findByDealerCode(String dealerCode);
}
