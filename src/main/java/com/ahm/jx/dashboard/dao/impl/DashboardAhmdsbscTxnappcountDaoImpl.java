/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao.impl;

import com.ahm.jx.app000.model.AhmdsbscTxnappcount;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.dashboard.dao.DashboardAhmdsbscTxnappcountDao;
import com.ahm.jx.dashboard.vo.VoCounterApp;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("dashboardAhmdsbscTxnappcountDao")
public class DashboardAhmdsbscTxnappcountDaoImpl extends GenericHibernateDao<AhmdsbscTxnappcount, String>
        implements DashboardAhmdsbscTxnappcountDao {

    public void addCounter(VoCounterApp voCounterApp, String username) {

        SimpleDateFormat sdfBulan = new SimpleDateFormat("MM");
        SimpleDateFormat sdfTahun = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int bulan = Integer.parseInt(sdfBulan.format(date));
        int tahun = Integer.parseInt(sdfTahun.format(date));
        voCounterApp.setBulan(bulan);
        voCounterApp.setTahun(tahun);
        AhmdsbscTxnappcount temp = getCounter(voCounterApp);
        if (temp == null) {
            AhmdsbscTxnappcount ahmdsbscTxnappcount = new AhmdsbscTxnappcount();
            ahmdsbscTxnappcount.setVidAhmjxuamMstmenus(voCounterApp.getMenuId());
            ahmdsbscTxnappcount.setIbulan(bulan);
            ahmdsbscTxnappcount.setItahun(tahun);
            ahmdsbscTxnappcount.setIcounter(BigInteger.ONE);
            save(ahmdsbscTxnappcount, username);
        } else {
            temp.setIcounter(temp.getIcounter().add(BigInteger.ONE));
            update(temp, username);
        }
    }

    public AhmdsbscTxnappcount getCounter(VoCounterApp voCounterApp) {
        Criteria criteria = getCurrentSession().createCriteria(AhmdsbscTxnappcount.class, "ahmdsbscTxnappcount");
        criteria.add(Restrictions.eq("vidAhmjxuamMstmenus", voCounterApp.getMenuId()));
        criteria.add(Restrictions.eq("ibulan", voCounterApp.getBulan()));
        criteria.add(Restrictions.eq("itahun", voCounterApp.getTahun()));
        Object obj = criteria.uniqueResult();
        AhmdsbscTxnappcount ahmdsbscTxnappcount;
        if (obj != null) {
            ahmdsbscTxnappcount = (AhmdsbscTxnappcount) obj;
            return ahmdsbscTxnappcount;
        }
        return null;
    }

}
