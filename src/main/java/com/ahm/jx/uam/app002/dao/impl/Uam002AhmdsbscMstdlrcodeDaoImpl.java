/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app002.dao.impl;

import com.ahm.jx.app000.model.AhmdsbscMstdlrcode;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app002.dao.Uam002AhmdsbscMstdlrcodeDao;
import com.ahm.jx.uam.app002.vo.Uam002Vodlr;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author george
 */
@Repository("uam002AhmdsbscMstdlrcodeDao")
public class Uam002AhmdsbscMstdlrcodeDaoImpl extends GenericHibernateDao<AhmdsbscMstdlrcode, String>
implements Uam002AhmdsbscMstdlrcodeDao{

    public List<Uam002Vodlr> getPagingDataAhmdsbscMstdealer(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<Uam002Vodlr> result = new ArrayList<Uam002Vodlr>();
        Criteria criteria = getCurrentSession().createCriteria(AhmdsbscMstdlrcode.class, "ahmdsbscMstdlrcode");
        Date curDate=new Date();
        criteria.add(Restrictions.and(Restrictions.lt("dbegineff", curDate),Restrictions.gt("dendeff",curDate)));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vdealercode","vname"},
                            AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vdealercode")) {
                    criteria.addOrder(Order.asc("vdealercode").ignoreCase());
                } else if (sortField.equals("vname")) {
                    criteria.addOrder(Order.asc("vname").ignoreCase());
                }
            } else {
                if (sortField.equals("vdealercode")) {
                    criteria.addOrder(Order.desc("vdealercode").ignoreCase());
                } else if (sortField.equals("vname")) {
                    criteria.addOrder(Order.desc("vname").ignoreCase());
                }
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmdsbscMstdlrcode> tempResult = criteria.list();
        for (AhmdsbscMstdlrcode ahmdsh1cMstmenus : tempResult) {
            Uam002Vodlr vo = new Uam002Vodlr();
            vo.setVid(ahmdsh1cMstmenus.getVid());
            vo.setVdealercode(ahmdsh1cMstmenus.getVdealercode());
            vo.setVname(ahmdsh1cMstmenus.getVname());
            result.add(vo);
        }
        return result;
    }

    public int getPagingCountAhmdsbscMstdlrcode(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsbscMstdlrcode.class, "ahmdsbscMstdlrcode");
        Date curDate=new Date();
        criteria.add(Restrictions.and(Restrictions.lt("dbegineff", curDate),Restrictions.gt("dendeff",curDate)));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vdealercode","vname"},
                            AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }
    
}
