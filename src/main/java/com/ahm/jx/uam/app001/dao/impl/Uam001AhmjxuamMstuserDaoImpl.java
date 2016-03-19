/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app001.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app001.util.Uam001Util;
import com.ahm.jx.uam.app001.vo.Uam001VoAhmjxuamMstuser;
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
import com.ahm.jx.uam.app001.dao.Uam001AhmjxuamMstuserDao;

/**
 *
 * @author lexys.jo
 */
@Repository("uam001AhmjxuamMstuserDao")
public class Uam001AhmjxuamMstuserDaoImpl extends GenericHibernateDao<AhmjxuamMstusers, String>
        implements Uam001AhmjxuamMstuserDao {

    public int getPagingCountAhmjxuamMstuser(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstusers.class, "uamjxuamMstuser");
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vid", "vusername", "vpassword", "vstat"},
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
                if (prop.equals("vstat")) {
                    if (Uam001Util.T.contains(valueLike.trim().toUpperCase())) {
                        valueLikeTemp = "T";
                    } else if (Uam001Util.F.contains(valueLike.trim().toUpperCase())) {
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

    public List<Uam001VoAhmjxuamMstuser> getPagingDataAhmjxuamMstuser(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println(sortField);
        List<Uam001VoAhmjxuamMstuser> result = new ArrayList<Uam001VoAhmjxuamMstuser>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstusers.class, "ahmjxuamMstusers");

        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vid", "vusername", "vpassword", "vstat"},
                                    AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }
        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vid")) {
                    criteria.addOrder(Order.asc("vid").ignoreCase());
                } else if (sortField.equals("vusername")) {
                    criteria.addOrder(Order.asc("vusername").ignoreCase());
                } else if (sortField.equals("vstat")) {
                    criteria.addOrder(Order.asc("vstat").ignoreCase());
                }
            } else if (sortField.equals("vid")) {
                criteria.addOrder(Order.desc("vid").ignoreCase());
            } else if (sortField.equals("vusername")) {
                criteria.addOrder(Order.desc("vusername").ignoreCase());
            } else if (sortField.equals("vstat")) {
                criteria.addOrder(Order.desc("vstat").ignoreCase());
            }
        }

        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstusers> tempResult = criteria.list();
        for (AhmjxuamMstusers AhmjxuamMstusers : tempResult) {
            Uam001VoAhmjxuamMstuser uam001VoAhmjxuamMstuser = new Uam001VoAhmjxuamMstuser();
            uam001VoAhmjxuamMstuser.setVid(AhmjxuamMstusers.getVid());
            uam001VoAhmjxuamMstuser.setIver(AhmjxuamMstusers.getIver());
            uam001VoAhmjxuamMstuser.setVusername(AhmjxuamMstusers.getVusername());
            uam001VoAhmjxuamMstuser.setVstat(Uam001Util.convertStatus(AhmjxuamMstusers.getVstat()));
            uam001VoAhmjxuamMstuser.setVpassword(AhmjxuamMstusers.getVpassword());
            result.add(uam001VoAhmjxuamMstuser);
        }
        return result;
    }
}
