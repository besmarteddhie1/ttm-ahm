/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstusers;
import com.ahm.jx.app000.model.AhmjxuamMstusrrols;
import com.ahm.jx.app000.vo.VoAhmjxuamMstusers;
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
import com.ahm.jx.uam.app005.dao.Uam005AhmjxuamMstusersDao;

/**
 *
 * @author Fransisca
 */
@Repository("uam005AhmjxuamMstusersDao")
public class Uam005AhmjxuamMstusersDaoImpl extends GenericHibernateDao<AhmjxuamMstusers, String>
        implements Uam005AhmjxuamMstusersDao {

    public int getPagingCountAhmsuamMstusers(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstusers.class, "ahmjxuamMstusers");
        criteria.add(Restrictions.and(Restrictions.eq("vstat", "T")));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vid", "vusername"},
                                    AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }

    public List<VoAhmjxuamMstusers> getPagingDataAhmjxh1cMstusers(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<VoAhmjxuamMstusers> result = new ArrayList<VoAhmjxuamMstusers>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstusers.class, "ahmjxuamMstusers");
        criteria.add(Restrictions.and(Restrictions.eq("vstat", "T")));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                System.out.println("key " + filter.getKey());
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    System.out.println("valueStr : " + valueStr);
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vid", "vusername"},
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
                } else if (sortField.equals("vusername")) {
                    criteria.addOrder(Order.asc("vusername").ignoreCase());
                }
            } else if (sortField.equals("vid")) {
                criteria.addOrder(Order.desc("vid").ignoreCase());
            } else if (sortField.equals("vusername")) {
                criteria.addOrder(Order.desc("vusername").ignoreCase());
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstusers> tempResult = criteria.list();
        for (AhmjxuamMstusers ahmjxh1cMstusers : tempResult) {
            VoAhmjxuamMstusers voAhmjxh1cMstuser = new VoAhmjxuamMstusers();
            voAhmjxh1cMstuser.setVid(ahmjxh1cMstusers.getVid());
            voAhmjxh1cMstuser.setVusername(ahmjxh1cMstusers.getVusername());
            result.add(voAhmjxh1cMstuser);
        }
        return result;
    }

}
