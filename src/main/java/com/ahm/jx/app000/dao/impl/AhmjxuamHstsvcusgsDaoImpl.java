/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmjxuamHstsvcusgsDao;
import com.ahm.jx.app000.model.AhmjxuamHstsvcusgs;
import com.ahm.jx.common.dao.GenericHibernateDao;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("ahmjxuamHstsvcusgsDao")
public class AhmjxuamHstsvcusgsDaoImpl extends GenericHibernateDao<AhmjxuamHstsvcusgs, String>
        implements AhmjxuamHstsvcusgsDao {

    @Override
    public List<AhmjxuamHstsvcusgs> getAllHstsvcusgs() {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamHstsvcusgs.class);
        return criteria.list();
    }

}
