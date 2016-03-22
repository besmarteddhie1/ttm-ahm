/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app004.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstmenus;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app004.vo.Uam004VoAhmjxuamMstmenus;
import java.util.ArrayList;
import java.util.List;
import com.ahm.jx.common.util.AhmStringUtil;
import java.util.Iterator;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;
import com.ahm.jx.uam.app004.dao.Uam004AhmjxuamMstmenusDao;

/**
 *
 * @author Elisa
 */
@Repository("uam004AhmjxuamMstmenusDao")
public class Uam004AhmjxuamMstmenusDaoImpl extends GenericHibernateDao<AhmjxuamMstmenus, String> implements Uam004AhmjxuamMstmenusDao {

    public int getPagingCountAhmjxuamMstmenus(Map<String, Object> filters, boolean isLov) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstmenus.class, "ahmjxuamMstmenus");

        if (isLov) {
            criteria.add(Restrictions.isNull("vurl"));
//            criteria.add(Restrictions.and(Restrictions.eq("vurl", null)));
//            criteria.add(Restrictions.or(Restrictions.eq("vurl", "")));
        } else {
            criteria.createAlias("ahmjxuamMstmenus.ahmjxuamMstmenus", "parentMenu");
        }
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vapplicationId", "vmenuId", "vtitle", "vurl", "vparent"},
                                    AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }

    public List<Uam004VoAhmjxuamMstmenus> getPagingDataAhmjxuamMstmenus(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters, boolean isLov) {

        List<Uam004VoAhmjxuamMstmenus> result = new ArrayList<Uam004VoAhmjxuamMstmenus>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstmenus.class, "ahmjxuamMstmenus");
        if (isLov) {
            criteria.add(Restrictions.isNull("vurl"));
//            criteria.add(Restrictions.and(Restrictions.eq("vurl", null)));
//            criteria.add(Restrictions.or(Restrictions.eq("vurl", "")));
        } else {
            criteria.createAlias("ahmjxuamMstmenus.ahmjxuamMstmenus", "parentMenu");
        }
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vapplicationId", "vmenuId", "vtitle", "vurl", "vparent"},
                                    AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vapplicationId")) {
                    criteria.addOrder(Order.asc("vapplicationId").ignoreCase());
                } else if (sortField.equals("vmenuId")) {
                    criteria.addOrder(Order.asc("vmenuId").ignoreCase());
                } else if (sortField.equals("vtitle")) {
                    criteria.addOrder(Order.asc("vtitle").ignoreCase());
                } else if (sortField.equals("vurl")) {
                    criteria.addOrder(Order.asc("vurl").ignoreCase());
                } else if (sortField.equals("vparent")) {
                    criteria.addOrder(Order.asc("vparent").ignoreCase());
                }
            } else if (sortField.equals("vapplicationId")) {
                criteria.addOrder(Order.desc("vapplicationId").ignoreCase());
            } else if (sortField.equals("vmenuId")) {
                criteria.addOrder(Order.desc("vmenuId").ignoreCase());
            } else if (sortField.equals("vtitle")) {
                criteria.addOrder(Order.desc("vtitle").ignoreCase());
            } else if (sortField.equals("vurl")) {
                criteria.addOrder(Order.desc("vurl").ignoreCase());
            } else if (sortField.equals("vparent")) {
                criteria.addOrder(Order.desc("vparent").ignoreCase());
            }
        }

        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);

        List<AhmjxuamMstmenus> tempResult = criteria.list();
        for (AhmjxuamMstmenus ahmjxuamMstmenus : tempResult) {
            Uam004VoAhmjxuamMstmenus uam004VoAhmjxuamMstmenus = new Uam004VoAhmjxuamMstmenus();
            uam004VoAhmjxuamMstmenus.setVid(ahmjxuamMstmenus.getVid());
            uam004VoAhmjxuamMstmenus.setIver(ahmjxuamMstmenus.getIver());
            uam004VoAhmjxuamMstmenus.setVapplicationId(ahmjxuamMstmenus.getVapplicationId());
            uam004VoAhmjxuamMstmenus.setVmenuId(ahmjxuamMstmenus.getVmenuId());
            uam004VoAhmjxuamMstmenus.setVtitle(ahmjxuamMstmenus.getVtitle());
            uam004VoAhmjxuamMstmenus.setVurl(ahmjxuamMstmenus.getVurl());
            uam004VoAhmjxuamMstmenus.setVidparent(ahmjxuamMstmenus.getVparent());
            uam004VoAhmjxuamMstmenus.setVstat(getStatDesc(ahmjxuamMstmenus.getVstat()));
            uam004VoAhmjxuamMstmenus.setVicon(ahmjxuamMstmenus.getVicon());
            if (!isLov) {
                uam004VoAhmjxuamMstmenus.setVparent(ahmjxuamMstmenus.getAhmjxuamMstmenus().getVtitle());
            }
            result.add(uam004VoAhmjxuamMstmenus);
        }
        return result;
    }

    public String getStatDesc(String vstat) {
        if (vstat.equals("T")) {
            return "AKTIF";
        } else {
            return "TIDAK AKTIF";
        }
    }

    public List<AhmjxuamMstmenus> getChildrenMenu(String id) {

        List<AhmjxuamMstmenus> result;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstmenus.class, "ahmjxuamMstmenus");
        criteria.add(Restrictions.eq("vparent", id));

        List<AhmjxuamMstmenus> tempResult = criteria.list();
        result = new ArrayList<AhmjxuamMstmenus>(tempResult);
        for (AhmjxuamMstmenus menu : tempResult) {
            if (!menu.getChild().isEmpty()) {
                result.addAll(getChildrenMenu(menu.getVid()));
            }
        }
        return result;
    }
}
