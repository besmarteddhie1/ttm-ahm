/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstmenusDao;
import com.ahm.jx.app000.model.AhmjxuamMstmenus;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.model.AbstractBaseEntity;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad
 */
@Repository("ahmjxuamMstmenusDao")
public class AhmjxuamMstmenusDaoImpl extends GenericHibernateDao<AhmjxuamMstmenus, String>
        implements AhmjxuamMstmenusDao {

    @Override
    public List<AhmjxuamMstmenus> getAllMstMenus() {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstmenus.class);
        return criteria.list();
    }

    @Override
    public AhmjxuamMstmenus getMstMenusByMenuId(String menuId) {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstmenus.class);
        criteria.add(Restrictions.eq("menuId", menuId));
        return (AhmjxuamMstmenus) criteria.uniqueResult();
    }

}
