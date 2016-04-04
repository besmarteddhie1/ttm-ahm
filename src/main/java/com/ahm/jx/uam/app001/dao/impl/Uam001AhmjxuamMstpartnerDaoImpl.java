/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app001.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstpartner;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app001.vo.Uam001Vodlr;
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
import com.ahm.jx.uam.app001.dao.Uam001AhmjxuamMstpartnerDao;

/**
 *
 * @author george
 */
@Repository("uam001AhmjxuamMstpartnerDao")
public class Uam001AhmjxuamMstpartnerDaoImpl extends GenericHibernateDao<AhmjxuamMstpartner, String>
        implements Uam001AhmjxuamMstpartnerDao {

    public List<Uam001Vodlr> getPagingDataAhmjxuamMstpartner(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<Uam001Vodlr> result = new ArrayList<Uam001Vodlr>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstpartner.class, "ahmjxuamMstpartner");
        Date curDate = new Date();
        criteria.add(Restrictions.and(Restrictions.lt("dbegineff", curDate), Restrictions.gt("dendeff", curDate)));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vdealercode", "vname"},
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
            } else if (sortField.equals("vdealercode")) {
                criteria.addOrder(Order.desc("vdealercode").ignoreCase());
            } else if (sortField.equals("vname")) {
                criteria.addOrder(Order.desc("vname").ignoreCase());
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstpartner> tempResult = criteria.list();
        for (AhmjxuamMstpartner ahmdsh1cMstmenus : tempResult) {
            Uam001Vodlr vo = new Uam001Vodlr();
            vo.setVid(ahmdsh1cMstmenus.getVid());
            vo.setVdealercode(ahmdsh1cMstmenus.getVdealercode());
            vo.setVname(ahmdsh1cMstmenus.getVname());
            result.add(vo);
        }
        return result;
    }

    public int getPagingCountAhmjxuamMstpartner(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstpartner.class, "ahmjxuamMstpartner");
        Date curDate = new Date();
        criteria.add(Restrictions.and(Restrictions.lt("dbegineff", curDate), Restrictions.gt("dendeff", curDate)));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vdealercode", "vname"},
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
