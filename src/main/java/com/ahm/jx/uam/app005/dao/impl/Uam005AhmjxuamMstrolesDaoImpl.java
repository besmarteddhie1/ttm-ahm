/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstroles;
import com.ahm.jx.app000.model.AhmjxuamMstusrrols;
import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmjxuamMstusrrols;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.ahm.jx.uam.app005.dao.Uam005AhmjxuamMstrolesDao;

/**
 *
 * @author Fransisca
 */
@Repository("uam005AhmjxuamMstrolesDao")
public class Uam005AhmjxuamMstrolesDaoImpl extends GenericHibernateDao<AhmjxuamMstroles, String>
        implements Uam005AhmjxuamMstrolesDao {

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstroles.class, "ahmjxuamMstroles");
        criteria.add(Restrictions.and(Restrictions.eq("vrolesStatus", "T")));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vid", "vrolesId"},
                                    AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }

    public List<VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<VoAhmjxuamMstroles> result = new ArrayList<VoAhmjxuamMstroles>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstroles.class, "ahmjxuamMstroles");
        criteria.add(Restrictions.and(Restrictions.eq("vrolesStatus", "T")));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                System.out.println("key " + filter.getKey());
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    System.out.println("valueStr : " + valueStr);
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vid", "vrolesId"},
                                    AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        } else {
            System.out.println("filter null");
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vid")) {
                    criteria.addOrder(Order.asc("vid").ignoreCase());
                } else if (sortField.equals("vrolesId")) {
                    criteria.addOrder(Order.asc("vrolesId").ignoreCase());
                }
            } else if (sortField.equals("vid")) {
                criteria.addOrder(Order.desc("vid").ignoreCase());
            } else if (sortField.equals("vrolesId")) {
                criteria.addOrder(Order.desc("vrolesId").ignoreCase());
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstroles> tempResult = criteria.list();
        for (AhmjxuamMstroles ahmdjx1cMstroles : tempResult) {
            VoAhmjxuamMstroles voAhmjxh1cMstrole = new VoAhmjxuamMstroles();
            voAhmjxh1cMstrole.setVid(ahmdjx1cMstroles.getVid());
            voAhmjxh1cMstrole.setVrolesName(ahmdjx1cMstroles.getVrolesName());
            voAhmjxh1cMstrole.setVrolesId(ahmdjx1cMstroles.getVrolesId());
            result.add(voAhmjxh1cMstrole);
        }
        return result;
    }
}
