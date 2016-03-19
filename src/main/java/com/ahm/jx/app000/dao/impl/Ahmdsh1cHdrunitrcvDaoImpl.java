/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.Ahmdsh1cHdrunitrcvDao;
import com.ahm.jx.app000.model.Ahmdsh1cHdrunitrcv;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laurentinus
 */
@Repository("ahmdsh1cHdrunitrcvDao")
public class Ahmdsh1cHdrunitrcvDaoImpl extends GenericHibernateDao<Ahmdsh1cHdrunitrcv, String> 
    implements Ahmdsh1cHdrunitrcvDao{

    public Ahmdsh1cHdrunitrcv getHdrunitrcv(String vidshiplist, String vidAhmdsbscMstdlrcode) {
        Criteria criteria = getCurrentSession().createCriteria(Ahmdsh1cHdrunitrcv.class, "ahmdsh1cHdrunitrcv");
        criteria.add(Restrictions.eq("vidshiplist", vidshiplist));
        criteria.add(Restrictions.eq("vidAhmdsbscMstdlrcode", vidAhmdsbscMstdlrcode));
        
        return (Ahmdsh1cHdrunitrcv)criteria.uniqueResult();
    }
    
}
