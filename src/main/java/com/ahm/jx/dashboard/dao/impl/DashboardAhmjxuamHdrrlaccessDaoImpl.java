/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamHdrrlaccess;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmjxuamHdrrlaccessDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("dashboardAhmjxuamHdrrlaccessDao")
public class DashboardAhmjxuamHdrrlaccessDaoImpl extends GenericHibernateDao<AhmjxuamHdrrlaccess, String>
        implements DashboardAhmjxuamHdrrlaccessDao {

    public String[] getDetailRoleAccess(String[] vidRoles) {
        String[] result = null;

        String hql = "SELECT dtl.vactallowed "
                + "FROM AhmjxuamHdrrlaccess hdr , AhmjxuamDtlrlaccess dtl "
                + "WHERE hdr.vidAhmjxuamMstroles IN (:rolesId) "
                + "AND hdr.vid = dtl.vidAhmjxuamHdrrlaccess ";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameterList("rolesId", vidRoles);
        List<Object> temp = query.list();
        if (temp != null) {
            result = new String[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                result[i] = temp.get(i) + "";
            }
        }
        return result;
    }

}
