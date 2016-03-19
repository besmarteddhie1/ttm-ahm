/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmdsuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmdsuamMstmenus;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmdsuamMstmenusDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("dashboardAhmdsuamMstmenusDao")
public class DashboardAhmdsuamMstmenusDaoImpl extends GenericHibernateDao<AhmdsuamMstmenus, String>
    implements DashboardAhmdsuamMstmenusDao{

    public VoAhmdsuamMstmenus getMenuByMenuIdAndAppId(String menuId, String appId) {
        VoAhmdsuamMstmenus voAhmdsuamMstmenus = null;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstmenus.class,"ahmdsuamMstmenus");
        criteria.add(Restrictions.eq("vid", menuId));
        criteria.add(Restrictions.eq("vapplicationId", appId));
        Object obj = criteria.uniqueResult();
        AhmdsuamMstmenus ahmdsuamMstmenus;
        if(obj!=null){
            ahmdsuamMstmenus = (AhmdsuamMstmenus) obj;
            voAhmdsuamMstmenus = new VoAhmdsuamMstmenus();
            voAhmdsuamMstmenus.setVid(ahmdsuamMstmenus.getVid());
            voAhmdsuamMstmenus.setVapplicationId(ahmdsuamMstmenus.getVapplicationId());
            voAhmdsuamMstmenus.setVtitle(ahmdsuamMstmenus.getVtitle());
            voAhmdsuamMstmenus.setVurl(ahmdsuamMstmenus.getVurl());
            voAhmdsuamMstmenus.setVparent(ahmdsuamMstmenus.getVparent());
        }
        return voAhmdsuamMstmenus;
    }
    
    public VoAhmdsuamMstmenus getMenuByAppId(String appId){
        VoAhmdsuamMstmenus voAhmdsuamMstmenus = null;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstmenus.class,"ahmdsuamMstmenus");
        criteria.add(Restrictions.eq("vapplicationId", appId));
        Object obj = criteria.uniqueResult();
        AhmdsuamMstmenus ahmdsuamMstmenus;
        if(obj!=null){
            ahmdsuamMstmenus = (AhmdsuamMstmenus) obj;
            voAhmdsuamMstmenus = new VoAhmdsuamMstmenus();
            voAhmdsuamMstmenus.setVid(ahmdsuamMstmenus.getVid());
            voAhmdsuamMstmenus.setVapplicationId(ahmdsuamMstmenus.getVapplicationId());
            voAhmdsuamMstmenus.setVtitle(ahmdsuamMstmenus.getVtitle());
            voAhmdsuamMstmenus.setVurl(ahmdsuamMstmenus.getVurl());
            voAhmdsuamMstmenus.setVparent(ahmdsuamMstmenus.getVparent());
        }
        return voAhmdsuamMstmenus;
    }
}
