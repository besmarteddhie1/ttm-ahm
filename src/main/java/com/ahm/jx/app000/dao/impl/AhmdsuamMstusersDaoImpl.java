/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmdsuamMstusersDao;
import com.ahm.jx.app000.model.AhmdsuamMstusers;
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
@Repository("ahmdsuamMstusersDao")
public class AhmdsuamMstusersDaoImpl extends GenericHibernateDao<AhmdsuamMstusers, String>
    implements AhmdsuamMstusersDao{

    @Override
    public List<AhmdsuamMstusers> getAllMstUsers() {
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstusers.class);
        return criteria.list();
    }

    @Override
    public AhmdsuamMstusers getMstUserByUserName(String userName) {
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstusers.class);
        criteria.add(Restrictions.eq("userName", userName));
        return (AhmdsuamMstusers) criteria.uniqueResult();
    }
    
    
    
}
