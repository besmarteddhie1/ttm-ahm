/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmjxuamHstappusgsDao;
import com.ahm.jx.app000.model.AhmjxuamHstappusgs;
import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.common.dao.GenericHibernateDao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("ahmjxuamHstappusgsDao")
public class AhmjxuamHstappusgsDaoImpl extends GenericHibernateDao<AhmjxuamHstappusgs, String>
        implements AhmjxuamHstappusgsDao {

    @Override
    public List<AhmjxuamHstappusgs> getAllHstappusgs() {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamHstappusgs.class);
        return criteria.list();
    }

}
