/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmjxuamMstmenusDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("dashboardAhmjxuamMstmenusDao")
public class DashboardAhmjxuamMstmenusDaoImpl extends GenericHibernateDao<AhmjxuamMstmenus, String>
        implements DashboardAhmjxuamMstmenusDao {

    public VoAhmjxuamMstmenus getMenuByMenuIdAndAppId(String menuId, String appId) {
        VoAhmjxuamMstmenus voAhmjxuamMstmenus = null;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstmenus.class, "ahmjxuamMstmenus");
        criteria.add(Restrictions.eq("vid", menuId));
        criteria.add(Restrictions.eq("vapplicationId", appId));
        Object obj = criteria.uniqueResult();
        AhmjxuamMstmenus ahmjxuamMstmenus;
        if (obj != null) {
            ahmjxuamMstmenus = (AhmjxuamMstmenus) obj;
            voAhmjxuamMstmenus = new VoAhmjxuamMstmenus();
            voAhmjxuamMstmenus.setVid(ahmjxuamMstmenus.getVid());
            voAhmjxuamMstmenus.setVapplicationId(ahmjxuamMstmenus.getVapplicationId());
            voAhmjxuamMstmenus.setVtitle(ahmjxuamMstmenus.getVtitle());
            voAhmjxuamMstmenus.setVurl(ahmjxuamMstmenus.getVurl());
            voAhmjxuamMstmenus.setVparent(ahmjxuamMstmenus.getVparent());
        }
        return voAhmjxuamMstmenus;
    }

    public VoAhmjxuamMstmenus getMenuByAppId(String appId) {
        VoAhmjxuamMstmenus voAhmjxuamMstmenus = null;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstmenus.class, "ahmjxuamMstmenus");
        criteria.add(Restrictions.eq("vapplicationId", appId));
        Object obj = criteria.uniqueResult();
        AhmjxuamMstmenus ahmjxuamMstmenus;
        if (obj != null) {
            ahmjxuamMstmenus = (AhmjxuamMstmenus) obj;
            voAhmjxuamMstmenus = new VoAhmjxuamMstmenus();
            voAhmjxuamMstmenus.setVid(ahmjxuamMstmenus.getVid());
            voAhmjxuamMstmenus.setVapplicationId(ahmjxuamMstmenus.getVapplicationId());
            voAhmjxuamMstmenus.setVtitle(ahmjxuamMstmenus.getVtitle());
            voAhmjxuamMstmenus.setVurl(ahmjxuamMstmenus.getVurl());
            voAhmjxuamMstmenus.setVparent(ahmjxuamMstmenus.getVparent());
        }
        return voAhmjxuamMstmenus;
    }
}
