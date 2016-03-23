/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstservicesDao;
import com.ahm.jx.app000.model.AhmjxuamMstservices;
import com.ahm.jx.common.dao.GenericHibernateDao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("ahmjxuamMstservicesDao")
public class AhmjxuamMstservicesDaoImpl extends GenericHibernateDao<AhmjxuamMstservices, String> implements AhmjxuamMstservicesDao {

    @Override
    public List<AhmjxuamMstservices> getAllMstservices() {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstservices.class);
        return criteria.list();
    }

}
