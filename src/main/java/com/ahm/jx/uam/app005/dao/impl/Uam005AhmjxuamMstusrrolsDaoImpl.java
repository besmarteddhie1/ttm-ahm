/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstusrrols;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.model.AbstractBaseEntity;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmjxuamMstusrrols;
import com.ahm.jx.uam.app005.util.Uam005Util;
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
import com.ahm.jx.uam.app005.dao.Uam005AhmjxuamMstusrrolsDao;

/**
 *
 * @author Fransisca
 */
@Repository("uam005AhmjxuamMstusrrolsDao")
public class Uam005AhmjxuamMstusrrolsDaoImpl extends GenericHibernateDao<AhmjxuamMstusrrols, String>
        implements Uam005AhmjxuamMstusrrolsDao {

    public int getPagingCountAhmjxuamMstusrrols(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstusrrols.class, "ahmjxuamMstusrrols");
        criteria.createAlias("ahmjxuamMstusrrols.ahmjxuamMstusers", "ahmjxuamMstusers");
        criteria.createAlias("ahmjxuamMstusrrols.ahmjxuamMstroles", "ahmjxuamMstroles");
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vid", "vstatus", "ahmjxuamMstusers.vusername", "vidAhmjxuamMstusers", "vidAhmjxuamMstroles",
                                        "ahmjxuamMstroles.vrolesName"},
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
//                criterion = buildResctrictionsOrForAllProperty(listProp, valueLike);
                criterion = Restrictions.ilike(prop, valueLike, MatchMode.ANYWHERE);
            } else {
                String valueLikeTemp = null;
                if (prop.equals("vstatus")) {
                    if (Uam005Util.T.contains(valueLike.trim().toUpperCase())) {
                        valueLikeTemp = "T";
                    } else if (Uam005Util.F.contains(valueLike.trim().toUpperCase())) {
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

    public List<Uam005VoAhmjxuamMstusrrols> getPagingDataAhmjxuamMstusrrols(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        System.out.println(sortField);
        List<Uam005VoAhmjxuamMstusrrols> result = new ArrayList<Uam005VoAhmjxuamMstusrrols>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstusrrols.class, "ahmjxuamMstusrrols");
        criteria.createAlias("ahmjxuamMstusrrols.ahmjxuamMstusers", "ahmjxuamMstusers");
        criteria.createAlias("ahmjxuamMstusrrols.ahmjxuamMstroles", "ahmjxuamMstroles");

        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vid", "vstatus", "ahmjxuamMstusers.vusername", "vidAhmjxuamMstusers", "vidAhmjxuamMstroles",
                                        "ahmjxuamMstroles.vrolesName"},
                                    AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vdAhmjxuamMstusers")) {
                    criteria.addOrder(Order.asc("ahmjxuamMstusers.vusername").ignoreCase());
                } else if (sortField.equals("vidAhmjxuamMstroles")) {
                    criteria.addOrder(Order.asc("ahmjxuamMstroles.vrolesName").ignoreCase());
                } else if (sortField.equals("vstatus")) {
                    criteria.addOrder(Order.asc("vstatus").ignoreCase());
                }
            } else if (sortField.equals("vdAhmjxuamMstusers")) {
                criteria.addOrder(Order.desc("ahmjxuamMstusers.vusername").ignoreCase());
            } else if (sortField.equals("vidAhmjxuamMstroles")) {
                criteria.addOrder(Order.desc("ahmjxuamMstroles.vrolesName").ignoreCase());
            } else if (sortField.equals("vstatus")) {
                criteria.addOrder(Order.desc("vstatus").ignoreCase());
            }
        }

        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstusrrols> tempResult = criteria.list();
        for (AhmjxuamMstusrrols ahmjxuamMstusrrols : tempResult) {
            Uam005VoAhmjxuamMstusrrols uam005VoAhmjxuamMstusrrols = new Uam005VoAhmjxuamMstusrrols();
            uam005VoAhmjxuamMstusrrols.setVid(ahmjxuamMstusrrols.getVid());
            uam005VoAhmjxuamMstusrrols.setAhmjxuamMstroles(ahmjxuamMstusrrols.getAhmjxuamMstroles().getVid());
            uam005VoAhmjxuamMstusrrols.setAhmjxuamMstusers(ahmjxuamMstusrrols.getAhmjxuamMstusers().getVid());
            uam005VoAhmjxuamMstusrrols.setIver(ahmjxuamMstusrrols.getIver());
            uam005VoAhmjxuamMstusrrols.setVidAhmjxuamMstroles(ahmjxuamMstusrrols.getVidAhmjxuamMstroles());
            uam005VoAhmjxuamMstusrrols.setVidAhmjxuamMstusers(ahmjxuamMstusrrols.getVidAhmjxuamMstusers());
            uam005VoAhmjxuamMstusrrols.setVrolesName(ahmjxuamMstusrrols.getAhmjxuamMstroles().getVrolesName());
            uam005VoAhmjxuamMstusrrols.setVusername(ahmjxuamMstusrrols.getAhmjxuamMstusers().getVusername());
            uam005VoAhmjxuamMstusrrols.setVstatus(Uam005Util.convertStatus(ahmjxuamMstusrrols.getVstatus()));
            result.add(uam005VoAhmjxuamMstusrrols);
        }
        return result;
    }

    public Uam005VoAhmjxuamMstusrrols getUserRoleById(String vid) {
        Uam005VoAhmjxuamMstusrrols uam005VoAhmjxuamMstusrrols = null;
        AhmjxuamMstusrrols ahmjxuamusrrols = get(vid);
        if (ahmjxuamusrrols != null) {
            uam005VoAhmjxuamMstusrrols = new Uam005VoAhmjxuamMstusrrols();
            uam005VoAhmjxuamMstusrrols.setVid(ahmjxuamusrrols.getVid());
            uam005VoAhmjxuamMstusrrols.setCreateBy(ahmjxuamusrrols.getCreateBy());
            uam005VoAhmjxuamMstusrrols.setCreateDate(ahmjxuamusrrols.getCreateDate());
            uam005VoAhmjxuamMstusrrols.setAhmjxuamMstroles(ahmjxuamusrrols.getAhmjxuamMstroles().getVid());
            uam005VoAhmjxuamMstusrrols.setAhmjxuamMstusers(ahmjxuamusrrols.getAhmjxuamMstusers().getVid());
            uam005VoAhmjxuamMstusrrols.setIver(ahmjxuamusrrols.getIver());
            uam005VoAhmjxuamMstusrrols.setVidAhmjxuamMstroles(ahmjxuamusrrols.getVidAhmjxuamMstroles());
            uam005VoAhmjxuamMstusrrols.setAhmjxuamMstusers(ahmjxuamusrrols.getVidAhmjxuamMstusers());
            uam005VoAhmjxuamMstusrrols.setVrolesName(ahmjxuamusrrols.getAhmjxuamMstroles().getVrolesName());
            uam005VoAhmjxuamMstusrrols.setVusername(ahmjxuamusrrols.getAhmjxuamMstusers().getVusername());
            uam005VoAhmjxuamMstusrrols.setVstatus(Uam005Util.convertStatus(ahmjxuamusrrols.getVstatus()));

//            uam005VoAhmdsuamMstusrrols.setVstatus(ahmdsuamusrrols.getVstatus());
        }
        return uam005VoAhmjxuamMstusrrols;
    }
}
