/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstpartnerDao;
import com.ahm.jx.app000.model.AhmjxuamMstpartner;
import com.ahm.jx.common.dao.GenericHibernateDao;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("ahmjxuamMstpartnerDao")
public class AhmjxuamMstpartnerDaoImpl extends GenericHibernateDao<AhmjxuamMstpartner, String>
        implements AhmjxuamMstpartnerDao {

    @Override
    public List<AhmjxuamMstpartner> getAllMstpartner() {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstpartner.class);
        return criteria.list();
    }

}
