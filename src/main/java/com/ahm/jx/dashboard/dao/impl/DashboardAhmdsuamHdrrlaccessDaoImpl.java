/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmdsuamHdrrlaccess;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmdsuamHdrrlaccessDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("dashboardAhmdsuamHdrrlaccessDao")
public class DashboardAhmdsuamHdrrlaccessDaoImpl extends GenericHibernateDao<AhmdsuamHdrrlaccess, String>
        implements DashboardAhmdsuamHdrrlaccessDao {

    public String[] getDetailRoleAccess(String[] vidRoles) {
        String[] result = null;

        String hql = "SELECT dtl.vactallowed "
                + "FROM AhmdsuamHdrrlaccess hdr , AhmdsuamDtlrlaccess dtl "
                + "WHERE hdr.vidAhmdsuamMstroles IN (:rolesId) "
                + "AND hdr.vid = dtl.vidAhmdsuamHdrrlaccess ";
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
