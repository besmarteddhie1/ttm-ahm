/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmdsuamMstmenusDao;
import com.ahm.jx.app000.model.AhmdsuamMstmenus;
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
@Repository("ahmdsuamMstmenusDao")
public class AhmdsuamMstmenusDaoImpl extends GenericHibernateDao<AhmdsuamMstmenus, String> 
    implements AhmdsuamMstmenusDao{

    @Override
    public List<AhmdsuamMstmenus> getAllMstMenus() {
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstmenus.class);
        return criteria.list();
    }

    @Override
    public AhmdsuamMstmenus getMstMenusByMenuId(String menuId) {
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstmenus.class);
        criteria.add(Restrictions.eq("menuId", menuId));
        return (AhmdsuamMstmenus) criteria.uniqueResult();
    }
    
    
}
