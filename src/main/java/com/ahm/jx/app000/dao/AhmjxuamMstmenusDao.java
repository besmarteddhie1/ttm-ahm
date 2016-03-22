/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao;

import com.ahm.jx.app000.model.AhmjxuamMstmenus;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.common.model.AbstractBaseEntity;
import java.util.List;

/**
 *
 * @author achmad
 */
public interface AhmjxuamMstmenusDao extends GenericDao<AhmjxuamMstmenus, String> {

    public List<AhmjxuamMstmenus> getAllMstMenus();

    public AhmjxuamMstmenus getMstMenusByMenuId(String menuId);

}
