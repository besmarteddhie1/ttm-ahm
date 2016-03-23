/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstappsDao;
import com.ahm.jx.app000.model.AhmjxuamMstapps;
import com.ahm.jx.common.dao.GenericHibernateDao;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("ahmjxuamMstappsDao")
public class AhmjxuamMstappsDaoImpl extends GenericHibernateDao<AhmjxuamMstapps, String>
        implements AhmjxuamMstappsDao {

    @Override
    public List<AhmjxuamMstapps> getAllMstapps() {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstapps.class);
        return criteria.list();
    }

}
