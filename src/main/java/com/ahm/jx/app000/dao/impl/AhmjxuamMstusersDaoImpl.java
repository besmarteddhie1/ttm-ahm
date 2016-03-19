/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstusersDao;
import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.common.dao.GenericHibernateDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("ahmjxuamMstusersDao")
public class AhmjxuamMstusersDaoImpl extends GenericHibernateDao<AhmjxuamMstusers, String>
        implements AhmjxuamMstusersDao {

    @Override
    public List<AhmjxuamMstusers> getAllMstUsers() {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstusers.class);
        return criteria.list();
    }

    @Override
    public AhmjxuamMstusers getMstUserByUserName(String userName) {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstusers.class);
        criteria.add(Restrictions.eq("userName", userName));
        return (AhmjxuamMstusers) criteria.uniqueResult();
    }

}
