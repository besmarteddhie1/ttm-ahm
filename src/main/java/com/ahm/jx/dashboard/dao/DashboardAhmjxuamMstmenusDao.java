/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao;

import com.ahm.jx.app000.model.AhmjxuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.common.dao.GenericDao;

/**
 *
 * @author sigit
 */
public interface DashboardAhmjxuamMstmenusDao extends GenericDao<AhmjxuamMstmenus, String> {

    public VoAhmjxuamMstmenus getMenuByMenuIdAndAppId(String menuId, String appId);

    public VoAhmjxuamMstmenus getMenuByAppId(String appId);
}
