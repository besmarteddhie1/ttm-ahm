/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstpartner;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmjxuamMstpartnerDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hendra.fs
 */
@Repository("dashboardAhmjxuamMstpartnerDao")
public class DashboardAhmjxuamMstpartnerDaoImpl extends GenericHibernateDao<AhmjxuamMstpartner, String>
        implements DashboardAhmjxuamMstpartnerDao {

    public AhmjxuamMstpartner findByDealerCode(String dealerCode) {
        Criteria crit = getCurrentSession().createCriteria(AhmjxuamMstpartner.class, "ahmjxuamMstpartner");
        crit.add(Restrictions.eq("vdealercode", dealerCode));

        return (AhmjxuamMstpartner) crit.uniqueResult();
    }
}
