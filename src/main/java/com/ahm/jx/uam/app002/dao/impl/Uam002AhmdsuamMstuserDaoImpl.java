/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app002.dao.impl;

import com.ahm.jx.app000.model.Ahmdsh1cMstemployee;
import com.ahm.jx.app000.model.AhmdsuamMstusers;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app002.dao.Uam002AhmdsuamMstuserDao;
import com.ahm.jx.uam.app002.util.Uam002Util;
import com.ahm.jx.uam.app002.vo.Uam002VoAhmdsuamMstuser;
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
 * @author lexys.jo
 */
@Repository("uam002AhmdsuamMstuserDao")
public class Uam002AhmdsuamMstuserDaoImpl extends GenericHibernateDao<AhmdsuamMstusers, String>
        implements Uam002AhmdsuamMstuserDao {

    public int getPagingCountAhmdsuamMstuser(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstusers.class, "uamdsuamMstuser");
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vid", "vusername","vpassword", "vstat"},
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

    public List<Uam002VoAhmdsuamMstuser> getPagingDataAhmdsuamMstuser(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println(sortField);
        List<Uam002VoAhmdsuamMstuser> result = new ArrayList<Uam002VoAhmdsuamMstuser>();
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstusers.class, "ahmdsuamMstusers");
       
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vid", "vusername","vpassword", "vstat"},
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
            } else {
                if (sortField.equals("vid")) {
                    criteria.addOrder(Order.desc("vid").ignoreCase());
                } else if (sortField.equals("vusername")) {
                    criteria.addOrder(Order.desc("vusername").ignoreCase());
                } else if (sortField.equals("vstat")) {
                    criteria.addOrder(Order.desc("vstat").ignoreCase());
                }
            }
        }

        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmdsuamMstusers> tempResult = criteria.list();
        for (AhmdsuamMstusers AhmdsuamMstusers : tempResult) {
            Uam002VoAhmdsuamMstuser uam002VoAhmdsuamMstuser = new Uam002VoAhmdsuamMstuser();
            uam002VoAhmdsuamMstuser.setVid(AhmdsuamMstusers.getVid());
            uam002VoAhmdsuamMstuser.setIver(AhmdsuamMstusers.getIver());
            uam002VoAhmdsuamMstuser.setVusername(AhmdsuamMstusers.getVusername());
            uam002VoAhmdsuamMstuser.setVstat(Uam002Util.convertStatus(AhmdsuamMstusers.getVstat()));
            uam002VoAhmdsuamMstuser.setVpassword(AhmdsuamMstusers.getVpassword());
            result.add(uam002VoAhmdsuamMstuser);
        }
        return result;
    }
}
