/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao;

import com.ahm.jx.app000.model.AhmjxuamHdrrlaccess;
import com.ahm.jx.common.dao.GenericDao;

/**
 *
 * @author sigit
 */
public interface DashboardAhmjxuamHdrrlaccessDao extends GenericDao<AhmjxuamHdrrlaccess, String> {

    public String[] getDetailRoleAccess(String[] vidRoles);
}
