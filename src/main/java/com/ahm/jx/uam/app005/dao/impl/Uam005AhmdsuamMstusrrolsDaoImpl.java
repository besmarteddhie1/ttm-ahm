/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao.impl;

import com.ahm.jx.app000.model.AhmdsuamMstusrrols;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.model.AbstractBaseEntity;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app005.dao.Uam005AhmdsuamMstusrrolsDao;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmdsuamMstusrrols;
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

/**
 *
 * @author Fransisca
 */
@Repository("uam005AhmdsuamMstusrrolsDao")
public class Uam005AhmdsuamMstusrrolsDaoImpl extends GenericHibernateDao<AhmdsuamMstusrrols, String>
        implements Uam005AhmdsuamMstusrrolsDao {

    public int getPagingCountAhmdsuamMstusrrols(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstusrrols.class, "ahmdsuamMstusrrols");
        criteria.createAlias("ahmdsuamMstusrrols.ahmdsuamMstusers", "ahmdsuamMstusers");
        criteria.createAlias("ahmdsuamMstusrrols.ahmdsuamMstroles", "ahmdsuamMstroles");
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vid", "vstatus", "ahmdsuamMstusers.vusername", "vidAhmdsuamMstusers", "vidAhmdsuamMstroles",
                                "ahmdsuamMstroles.vrolesName"},
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

    public List<Uam005VoAhmdsuamMstusrrols> getPagingDataAhmdsuamMstusrrols(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        System.out.println(sortField);
        List<Uam005VoAhmdsuamMstusrrols> result = new ArrayList<Uam005VoAhmdsuamMstusrrols>();
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstusrrols.class, "ahmdsuamMstusrrols");
        criteria.createAlias("ahmdsuamMstusrrols.ahmdsuamMstusers", "ahmdsuamMstusers");
        criteria.createAlias("ahmdsuamMstusrrols.ahmdsuamMstroles", "ahmdsuamMstroles");

        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vid", "vstatus", "ahmdsuamMstusers.vusername", "vidAhmdsuamMstusers", "vidAhmdsuamMstroles",
                                "ahmdsuamMstroles.vrolesName"},
                            AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vdAhmdsuamMstusers")) {
                    criteria.addOrder(Order.asc("ahmdsuamMstusers.vusername").ignoreCase());
                } else if (sortField.equals("vidAhmdsuamMstroles")) {
                    criteria.addOrder(Order.asc("ahmdsuamMstroles.vrolesName").ignoreCase());
                } else if (sortField.equals("vstatus")) {
                    criteria.addOrder(Order.asc("vstatus").ignoreCase());
                }
            } else {
                if (sortField.equals("vdAhmdsuamMstusers")) {
                    criteria.addOrder(Order.desc("ahmdsuamMstusers.vusername").ignoreCase());
                } else if (sortField.equals("vidAhmdsuamMstroles")) {
                    criteria.addOrder(Order.desc("ahmdsuamMstroles.vrolesName").ignoreCase());
                } else if (sortField.equals("vstatus")) {
                    criteria.addOrder(Order.desc("vstatus").ignoreCase());
                }
            }
        }

        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmdsuamMstusrrols> tempResult = criteria.list();
        for (AhmdsuamMstusrrols ahmdsuamMstusrrols : tempResult) {
            Uam005VoAhmdsuamMstusrrols uam005VoAhmdsuamMstusrrols = new Uam005VoAhmdsuamMstusrrols();
            uam005VoAhmdsuamMstusrrols.setVid(ahmdsuamMstusrrols .getVid());
            uam005VoAhmdsuamMstusrrols.setAhmdsuamMstroles(ahmdsuamMstusrrols .getAhmdsuamMstroles().getVid());
            uam005VoAhmdsuamMstusrrols.setAhmdsuamMstusers(ahmdsuamMstusrrols .getAhmdsuamMstusers().getVid());
            uam005VoAhmdsuamMstusrrols.setIver(ahmdsuamMstusrrols .getIver());
            uam005VoAhmdsuamMstusrrols.setVidAhmdsuamMstroles(ahmdsuamMstusrrols .getVidAhmdsuamMstroles());
            uam005VoAhmdsuamMstusrrols.setVidAhmdsuamMstusers(ahmdsuamMstusrrols .getVidAhmdsuamMstusers());
            uam005VoAhmdsuamMstusrrols.setVrolesName(ahmdsuamMstusrrols .getAhmdsuamMstroles().getVrolesName());
            uam005VoAhmdsuamMstusrrols.setVusername(ahmdsuamMstusrrols .getAhmdsuamMstusers().getVusername());
            uam005VoAhmdsuamMstusrrols.setVstatus(Uam005Util.convertStatus(ahmdsuamMstusrrols .getVstatus()));
            result.add(uam005VoAhmdsuamMstusrrols);
        }
        return result;
    }

    public Uam005VoAhmdsuamMstusrrols getUserRoleById(String vid) {
        Uam005VoAhmdsuamMstusrrols uam005VoAhmdsuamMstusrrols = null;
        AhmdsuamMstusrrols ahmdsuamusrrols = get(vid);
        if (ahmdsuamusrrols != null) {
            uam005VoAhmdsuamMstusrrols=new Uam005VoAhmdsuamMstusrrols();
            uam005VoAhmdsuamMstusrrols.setVid(ahmdsuamusrrols.getVid());
            uam005VoAhmdsuamMstusrrols.setCreateBy(ahmdsuamusrrols.getCreateBy());
            uam005VoAhmdsuamMstusrrols.setCreateDate(ahmdsuamusrrols.getCreateDate());
            uam005VoAhmdsuamMstusrrols.setAhmdsuamMstroles(ahmdsuamusrrols.getAhmdsuamMstroles().getVid());
            uam005VoAhmdsuamMstusrrols.setAhmdsuamMstusers(ahmdsuamusrrols.getAhmdsuamMstusers().getVid());
            uam005VoAhmdsuamMstusrrols.setIver(ahmdsuamusrrols.getIver());
            uam005VoAhmdsuamMstusrrols.setVidAhmdsuamMstroles(ahmdsuamusrrols.getVidAhmdsuamMstroles());
            uam005VoAhmdsuamMstusrrols.setAhmdsuamMstusers(ahmdsuamusrrols.getVidAhmdsuamMstusers());
            uam005VoAhmdsuamMstusrrols.setVrolesName(ahmdsuamusrrols.getAhmdsuamMstroles().getVrolesName());
            uam005VoAhmdsuamMstusrrols.setVusername(ahmdsuamusrrols.getAhmdsuamMstusers().getVusername());
            uam005VoAhmdsuamMstusrrols.setVstatus(Uam005Util.convertStatus(ahmdsuamusrrols.getVstatus()));

//            uam005VoAhmdsuamMstusrrols.setVstatus(ahmdsuamusrrols.getVstatus());
        }
        return uam005VoAhmdsuamMstusrrols;
    }
}
