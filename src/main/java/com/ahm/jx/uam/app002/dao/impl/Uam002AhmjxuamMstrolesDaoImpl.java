/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app002.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstroles;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app002.vo.Uam002VoAhmjxuamMstroles;
import com.ahm.jx.uam.app002.util.Uam002Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.ahm.jx.uam.app002.dao.Uam002AhmjxuamMstrolesDao;

/**
 *
 * @author indriHtb
 */
@Repository("uam002AhmjxuamMstrolesDao")
public class Uam002AhmjxuamMstrolesDaoImpl extends GenericHibernateDao<AhmjxuamMstroles, String> implements Uam002AhmjxuamMstrolesDao {

    public int getPagingCountAhmjxuamMstroles(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstroles.class, "ahmjxuamMstroles");
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vrolesId", "vrolesName", "vrolesDesc", "vrolesStatus"},
                                    AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }

    @Override
    public Criterion buildResctrictionsAndForAllProperty(String[] listProp, String[] listValueLike) {
        Criterion criterion = null;

        for (String valueLike : listValueLike) {
            if (criterion == null) {
                criterion = buildResctrictionsOrForAllProperty(listProp, valueLike);
            } else {
                criterion = Restrictions.and(criterion, buildResctrictionsOrForAllProperty(listProp, valueLike));
            }
        }

        return criterion;
    }

    @Override
    public Criterion buildResctrictionsOrForAllProperty(String[] listProp, String valueLike) {
        Criterion criterion = null;

        for (String prop : listProp) {
            if (criterion == null) {
                criterion = Restrictions.ilike(prop, valueLike, MatchMode.ANYWHERE);
            } else {
                String valueLikeTemp = null;
                if (prop.equals("vrolesStatus")) {
                    if (Uam002Util.T.contains(valueLike.trim().toUpperCase())) {
                        valueLikeTemp = "T";
                    } else if (Uam002Util.F.contains(valueLike.trim().toUpperCase())) {
                        valueLikeTemp = "F";
                    }
                } else {
                    valueLikeTemp = valueLike;
                }
                criterion = Restrictions.or(criterion, Restrictions.ilike(prop, valueLikeTemp, MatchMode.ANYWHERE));
            }
        }
        return criterion;
    }

    public List<Uam002VoAhmjxuamMstroles> getPagingDataAhmjxuamMstroles(int first, int pageSize,
            String sortField, String sortOrder, Map<String, Object> filters) {
        System.out.println(sortField);
        List<Uam002VoAhmjxuamMstroles> result = new ArrayList<Uam002VoAhmjxuamMstroles>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstroles.class, "ahmjxuamMstroles");

        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vrolesId", "vrolesName", "vrolesDesc", "vrolesStatus"},
                                    AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vrolesId")) {
                    criteria.addOrder(Order.asc("vrolesId").ignoreCase());
                } else if (sortField.equals("vrolesName")) {
                    criteria.addOrder(Order.asc("vrolesName").ignoreCase());
                } else if (sortField.equals("vrolesDesc")) {
                    criteria.addOrder(Order.asc("vrolesDesc").ignoreCase());
                } else if (sortField.equals("vrolesStatus")) {
                    criteria.addOrder(Order.asc("vrolesStatus").ignoreCase());
                }
            } else if (sortField.equals("vrolesId")) {
                criteria.addOrder(Order.desc("vrolesId").ignoreCase());
            } else if (sortField.equals("vrolesName")) {
                criteria.addOrder(Order.desc("vrolesName").ignoreCase());
            } else if (sortField.equals("vrolesDesc")) {
                criteria.addOrder(Order.desc("vrolesDesc").ignoreCase());
            } else if (sortField.equals("vrolesStatus")) {
                criteria.addOrder(Order.desc("vrolesStatus").ignoreCase());
            }
        }

        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstroles> tempResult = criteria.list();
        for (AhmjxuamMstroles ahmjxuamMstroles : tempResult) {
            Uam002VoAhmjxuamMstroles uam002VoAhmjxuamMstroles = new Uam002VoAhmjxuamMstroles();
            uam002VoAhmjxuamMstroles.setVid(ahmjxuamMstroles.getVid());
            uam002VoAhmjxuamMstroles.setIver(ahmjxuamMstroles.getIver());
            uam002VoAhmjxuamMstroles.setVrolesId(ahmjxuamMstroles.getVrolesId());
            uam002VoAhmjxuamMstroles.setVrolesName(ahmjxuamMstroles.getVrolesName());
            uam002VoAhmjxuamMstroles.setVrolesDesc(ahmjxuamMstroles.getVrolesDesc());
            uam002VoAhmjxuamMstroles.setVrolesStatus(Uam002Util.convertStatus(ahmjxuamMstroles.getVrolesStatus()));
            result.add(uam002VoAhmjxuamMstroles);
        }
        return result;
    }

}
