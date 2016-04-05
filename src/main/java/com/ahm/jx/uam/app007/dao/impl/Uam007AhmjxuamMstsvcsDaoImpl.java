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
import com.ahm.jx.app000.model.AhmjxuamMstservices;
import com.ahm.jx.app000.vo.VoAhmjxuamMstroles;
import com.ahm.jx.app000.vo.VoAhmjxuamMstservices;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app006.dao.Uam006AhmjxuamMstrolesDao;
import com.ahm.jx.uam.app007.dao.Uam007AhmjxuamMstsvcsDao;

/**
*
* @author ferdy
*/
@Repository("uam007AhmjxuamMstsvcsDao")
public class Uam007AhmjxuamMstsvcsDaoImpl extends GenericHibernateDao<AhmjxuamMstservices, String>
implements Uam007AhmjxuamMstsvcsDao{

	public int getPagingCountAhmjxuamMstsvcs(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstservices.class, "ahmjxuamMstservices");
        criteria.add(Restrictions.and(Restrictions.eq("vstat", "T")));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vsvcname","vsvcdesc","vurl","vidAhmjxuamMstapps"},
                                    AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }

    public List<VoAhmjxuamMstservices> getPagingDataAhmjxuamMstsvcs(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<VoAhmjxuamMstservices> result = new ArrayList<VoAhmjxuamMstservices>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstservices.class, "ahmjxuamMstservices");
        criteria.add(Restrictions.and(Restrictions.eq("vstat", "T")));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                System.out.println("key " + filter.getKey());
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    System.out.println("valueStr : " + valueStr);
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vsvcname","vsvcdesc","vurl","vidAhmjxuamMstapps"},
                                    AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        } else {
            System.out.println("filter null");
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vsvcname")) {
                    criteria.addOrder(Order.asc("vsvcname").ignoreCase());
                } else if (sortField.equals("vsvcdesc")) {
                    criteria.addOrder(Order.asc("vsvcdesc").ignoreCase());
                } else if (sortField.equals("vurl")) {
                    criteria.addOrder(Order.asc("vurl").ignoreCase());
                } else if (sortField.equals("vidAhmjxuamMstapps")) {
                    criteria.addOrder(Order.asc("vidAhmjxuamMstapps").ignoreCase());
                }
            } else if (sortField.equals("vsvcname")) {
                criteria.addOrder(Order.desc("vsvcname").ignoreCase());
            } else if (sortField.equals("vsvcdesc")) {
                criteria.addOrder(Order.desc("vsvcdesc").ignoreCase());
            } else if (sortField.equals("vurl")) {
                criteria.addOrder(Order.asc("vurl").ignoreCase());
            }else if (sortField.equals("vidAhmjxuamMstapps")) {
                criteria.addOrder(Order.asc("vidAhmjxuamMstapps").ignoreCase());
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstservices> tempResult = criteria.list();
        for (AhmjxuamMstservices ahmjxuamMstservices : tempResult) {
        	VoAhmjxuamMstservices voAhmjxuamMstservices = new VoAhmjxuamMstservices();
        	voAhmjxuamMstservices.setVid(ahmjxuamMstservices.getVid());
        	voAhmjxuamMstservices.setVsvcname(ahmjxuamMstservices.getVsvcName());
        	voAhmjxuamMstservices.setVsvcdesc(ahmjxuamMstservices.getVsvcDesc());
        	voAhmjxuamMstservices.setVurl(ahmjxuamMstservices.getVurl());
        	voAhmjxuamMstservices.setVidAhmjxuamMstapps(ahmjxuamMstservices.getVidAhmjxuamMstapps());
            result.add(voAhmjxuamMstservices);
        }
        return result;
    }

}
