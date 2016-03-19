/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao;

import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmjxuamMstpartner;
import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;

/**
 *
 * @author sigit
 */
public interface DashboardAhmjxuamMstusersDao extends GenericDao<AhmjxuamMstusers, String> {

    public List<VoAhmjxuamMstmenus> getMenuByUser(String userName);

    public AhmjxuamMstusers getAhmjxuamMstuserByUsername(String userName);

    public VoAhmjxuamMstpartner getDealerInfoByUsername(String userName);

    public VoAhmjxuamMstmenus getMenuByUserByAppid(String userName, String appId);

    public List<VoAhmjxuamMstroles> getRoleByAppAndUser(String username, String vid);
}
