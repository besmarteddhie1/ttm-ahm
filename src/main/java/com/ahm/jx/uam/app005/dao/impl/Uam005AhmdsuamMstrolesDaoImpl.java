/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao.impl;

import com.ahm.jx.app000.model.AhmdsuamMstroles;
import com.ahm.jx.app000.model.AhmdsuamMstusrrols;
import com.ahm.jx.app000.vo.VoAhmdsuamMstroles;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app005.dao.Uam005AhmdsuamMstrolesDao;
import com.ahm.jx.uam.app005.vo.Uam005VoAhmdsuamMstusrrols;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fransisca
 */
@Repository("uam005AhmdsuamMstrolesDao")
public class Uam005AhmdsuamMstrolesDaoImpl extends GenericHibernateDao<AhmdsuamMstroles, String>
        implements Uam005AhmdsuamMstrolesDao {

    public int getPagingCountAhmdsuamMstroles(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstroles.class, "ahmdsuamMstroles");
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

    public List<VoAhmdsuamMstroles> getPagingDataAhmdsuamMstroles(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<VoAhmdsuamMstroles> result = new ArrayList<VoAhmdsuamMstroles>();
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstroles.class, "ahmdsuamMstroles");
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
            } else {
                if (sortField.equals("vid")) {
                    criteria.addOrder(Order.desc("vid").ignoreCase());
                } else if (sortField.equals("vrolesId")) {
                    criteria.addOrder(Order.desc("vrolesId").ignoreCase());
                }
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmdsuamMstroles> tempResult = criteria.list();
        for (AhmdsuamMstroles ahmdsh1cMstroles : tempResult) {
            VoAhmdsuamMstroles voAhmdsh1cMstrole = new VoAhmdsuamMstroles();
            voAhmdsh1cMstrole.setVid(ahmdsh1cMstroles.getVid());
            voAhmdsh1cMstrole.setVrolesName(ahmdsh1cMstroles.getVrolesName());
            voAhmdsh1cMstrole.setVrolesId(ahmdsh1cMstroles.getVrolesId());
            result.add(voAhmdsh1cMstrole);
        }
        return result;
    }
}
