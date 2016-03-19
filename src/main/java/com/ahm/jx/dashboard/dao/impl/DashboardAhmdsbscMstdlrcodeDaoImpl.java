/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmdsbscMstdlrcode;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmdsbscMstdlrcodeDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hendra.fs
 */
@Repository("dashboardAhmdsbscMstdlrcodeDao")
public class DashboardAhmdsbscMstdlrcodeDaoImpl extends GenericHibernateDao<AhmdsbscMstdlrcode, String>
        implements DashboardAhmdsbscMstdlrcodeDao {

    public AhmdsbscMstdlrcode findByDealerCode(String dealerCode) {
        Criteria crit = getCurrentSession().createCriteria(AhmdsbscMstdlrcode.class, "ahmdsbscMstdlrcode");
        crit.add(Restrictions.eq("vdealercode", dealerCode));

        return (AhmdsbscMstdlrcode) crit.uniqueResult();
    }
}
