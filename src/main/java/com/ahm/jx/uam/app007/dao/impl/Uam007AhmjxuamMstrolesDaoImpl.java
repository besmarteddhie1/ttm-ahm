package com.ahm.jx.uam.app007.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ahm.jx.app000.model.AhmjxuamMstroles;
import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app007.dao.Uam007AhmjxuamMstrolesDao;

@Repository("uam007AhmjxuamMstrolesDao")
public class Uam007AhmjxuamMstrolesDaoImpl extends GenericHibernateDao<AhmjxuamMstroles, String>
implements Uam007AhmjxuamMstrolesDao {

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
                                    new String[]{"vrolesId", "vrolesName"},
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
                                    new String[]{"vrolesId", "vrolesName"},
                                    AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        } else {
            System.out.println("filter null");
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vrolesName")) {
                    criteria.addOrder(Order.asc("vrolesName").ignoreCase());
                } else if (sortField.equals("vrolesId")) {
                    criteria.addOrder(Order.asc("vrolesId").ignoreCase());
                }
            } else if (sortField.equals("vrolesName")) {
                criteria.addOrder(Order.desc("vrolesName").ignoreCase());
            } else if (sortField.equals("vrolesId")) {
                criteria.addOrder(Order.desc("vrolesId").ignoreCase());
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstroles> tempResult = criteria.list();
        for (AhmjxuamMstroles ahmjxuamMstroles : tempResult) {
            VoAhmjxuamMstroles voAhmjxuamMstrole = new VoAhmjxuamMstroles();
            voAhmjxuamMstrole.setVid(ahmjxuamMstroles.getVid());
            voAhmjxuamMstrole.setVrolesName(ahmjxuamMstroles.getVrolesName());
            voAhmjxuamMstrole.setVrolesId(ahmjxuamMstroles.getVrolesId());
            voAhmjxuamMstrole.setVrolesDesc(ahmjxuamMstroles.getVrolesDesc());
            result.add(voAhmjxuamMstrole);
        }
        return result;
    }

}
