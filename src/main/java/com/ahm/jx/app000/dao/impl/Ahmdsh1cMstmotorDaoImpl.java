/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.Ahmdsh1cMstmotorDao;
import com.ahm.jx.app000.model.Ahmdsh1cMstmotor;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laurentinus
 */
@Repository("ahmdsh1cMstmotorDao")
public class Ahmdsh1cMstmotorDaoImpl extends GenericHibernateDao<Ahmdsh1cMstmotor, String> 
    implements Ahmdsh1cMstmotorDao{

    public Ahmdsh1cMstmotor getMstmotor(String vframenum, String venginenum, String vidAhmdsbscMstdlrcode) {
        Criteria criteria = getCurrentSession().createCriteria(Ahmdsh1cMstmotor.class, "ahmdsh1cMstmotor");
        criteria.add(Restrictions.eq("vframenum", vframenum));
        criteria.add(Restrictions.eq("venginenum", venginenum));
        criteria.add(Restrictions.eq("vidAhmdsbscMstdlrcode", vidAhmdsbscMstdlrcode));
        
        return (Ahmdsh1cMstmotor)criteria.uniqueResult();
    }
    
    public Ahmdsh1cMstmotor getMstmotor(String vid, int iver) {
        Criteria criteria = getCurrentSession().createCriteria(Ahmdsh1cMstmotor.class, "ahmdsh1cMstmotor");
        criteria.add(Restrictions.eq("vid", vid));
        criteria.add(Restrictions.eq("iver", iver));
        
        return (Ahmdsh1cMstmotor)criteria.uniqueResult();
    }
    
}
