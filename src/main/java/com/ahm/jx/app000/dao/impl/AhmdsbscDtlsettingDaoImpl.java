/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmdsbscDtlsettingDao;
import com.ahm.jx.app000.model.AhmdsbscDtlsetting;
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
@Repository("ahmdsbscDtlsettingDao")
public class AhmdsbscDtlsettingDaoImpl extends GenericHibernateDao<AhmdsbscDtlsetting, String>
        implements AhmdsbscDtlsettingDao {

    public List<VoAhmdsbscDtlsetting> getAhmdsbscDtlsettingByVidSettingVitemcodeVitemameVdlrcode(String vidsetting, String vitemcode, String vitemname, String vdlrcode) {
        List<VoAhmdsbscDtlsetting> list = new ArrayList<VoAhmdsbscDtlsetting>();
        Criteria criteriaHeader = getCurrentSession().createCriteria(AhmdsbscHdrsetting.class, "ahmdsbscHdrsetting");
        criteriaHeader.add(Restrictions.eq("vidsetting", vidsetting));
        AhmdsbscHdrsetting ahmdsbscHdrsetting = (AhmdsbscHdrsetting) criteriaHeader.uniqueResult();
        if (ahmdsbscHdrsetting != null) {
            Criteria criteria = getCurrentSession().createCriteria(AhmdsbscDtlsetting.class, "ahmdsbscDtlsetting");
            criteria.add(Restrictions.eq("vidAhmdsbscHdrsetting", ahmdsbscHdrsetting.getVid()));
            criteria.add(Restrictions.eq("vstatus", "T"));

            if (vitemcode != null) {
                criteria.add(Restrictions.eq("vitemcode", vitemcode));
            }
            if (vitemname != null) {
                criteria.add(Restrictions.eq("vitemname", vitemname));
            }
            if (vdlrcode != null) {
                criteria.add(Restrictions.eq("vdlrcode", vdlrcode));
            }
            List<AhmdsbscDtlsetting> temp = criteria.list();
            for (AhmdsbscDtlsetting ahmdsbscDtlsetting : temp) {
                VoAhmdsbscDtlsetting voAhmdsbscDtlsetting = new VoAhmdsbscDtlsetting();
                voAhmdsbscDtlsetting.setVidAhmdsbscHdrsetting(ahmdsbscHdrsetting.getVid());
                voAhmdsbscDtlsetting.setVid(ahmdsbscDtlsetting.getVid());
                voAhmdsbscDtlsetting.setVitemcode(ahmdsbscDtlsetting.getVitemcode());
                voAhmdsbscDtlsetting.setVitemname(ahmdsbscDtlsetting.getVitemname());
                voAhmdsbscDtlsetting.setVitemdesc(ahmdsbscDtlsetting.getVitemdesc());
                voAhmdsbscDtlsetting.setVdlrcode(ahmdsbscDtlsetting.getVdlrcode());
                voAhmdsbscDtlsetting.setVstatus(ahmdsbscDtlsetting.getVstatus());
                voAhmdsbscDtlsetting.setIver(ahmdsbscDtlsetting.getIver());
                list.add(voAhmdsbscDtlsetting);
            }
        }
        return list;
    }
}
