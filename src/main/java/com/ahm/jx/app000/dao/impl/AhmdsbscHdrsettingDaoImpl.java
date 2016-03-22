/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmdsbscHdrsettingDao;
import com.ahm.jx.app000.model.AhmdsbscHdrsetting;
import com.ahm.jx.app000.vo.VoAhmdsbscDtlsetting;
import com.ahm.jx.common.dao.GenericHibernateDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("ahmdsbscHdrsettingDao")
public class AhmdsbscHdrsettingDaoImpl extends GenericHibernateDao<AhmdsbscHdrsetting, String>
        implements AhmdsbscHdrsettingDao {

    public List<VoAhmdsbscDtlsetting> getAhmdsbscDtlsettingByVidsettingVitemcodeVdlrcode(String vidsetting, String vitemcode, String vdlrcode) {
        List<VoAhmdsbscDtlsetting> list = new ArrayList<VoAhmdsbscDtlsetting>();
        Criteria criteria = getCurrentSession().createCriteria(AhmdsbscHdrsetting.class, "ahmdsbscHdrsetting");
        criteria.add(Restrictions.eq("vidsetting", vidsetting));
        AhmdsbscHdrsetting ahmdsbscHdrsetting = (AhmdsbscHdrsetting) criteria.uniqueResult();

        return list;
    }

}
