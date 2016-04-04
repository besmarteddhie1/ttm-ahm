/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmdsbscTxnrunnumDao;
import com.ahm.jx.app000.model.AhmdsbscTxnrunnum;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("ahmdsbscTxnrunnumDao")
public class AhmdsbscTxnrunnumDaoImpl extends GenericHibernateDao<AhmdsbscTxnrunnum, String>
        implements AhmdsbscTxnrunnumDao{

    public Integer getValue(String idrunnum, String reset, String kodeDealer,String userId) {
        Integer result = 1;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsbscTxnrunnum.class, "ahmdsbscTxnrunnum");
        criteria.add(Restrictions.eq("vidrunnum", idrunnum));        
        criteria.add(Restrictions.eq("vreset", kodeDealer+reset));
        AhmdsbscTxnrunnum ahmdsbscTxnrunnum = (AhmdsbscTxnrunnum)criteria.uniqueResult();
        if(ahmdsbscTxnrunnum!=null){
            result = ahmdsbscTxnrunnum.getIvalue();
            ahmdsbscTxnrunnum.setIvalue(result+1);
            update(ahmdsbscTxnrunnum, userId);
        }else{
            ahmdsbscTxnrunnum = new AhmdsbscTxnrunnum();
            ahmdsbscTxnrunnum.setVidrunnum(idrunnum);
            ahmdsbscTxnrunnum.setVreset(kodeDealer+reset);
            ahmdsbscTxnrunnum.setIvalue(2);
            save(ahmdsbscTxnrunnum,userId);            
        }
        return result;
    }
    
}
