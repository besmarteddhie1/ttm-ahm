/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app008.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstapps;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app008.dao.Uam008AhmjxuamMstappsDao;
import com.ahm.jx.uam.app008.util.Uam008Util;
import com.ahm.jx.uam.app008.vo.Uam008VoAhmjxuamMstapps;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sigit
 */
@Repository("uam008AhmjxuamMstappsDao")
public class Uam008AhmjxuamMstappsDaoImpl extends GenericHibernateDao<AhmjxuamMstapps, String>
        implements Uam008AhmjxuamMstappsDao {

    @Override
    public int getPagingCountAhmjxuamMstapps(Map<String, Object> filters) {
        int result = 0;

        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstapps.class, "uamjxuamMstapps");
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vid", "vname", "vdesc", "vstat"},
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
    public List<Uam008VoAhmjxuamMstapps> getPagingDataAhmjxuamMstapps(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<Uam008VoAhmjxuamMstapps> result = new ArrayList<Uam008VoAhmjxuamMstapps>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstapps.class, "ahmjxuamMstapps");

        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vid", "vname", "vdesc", "vstat"},
                                    AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vid")) {
                    criteria.addOrder(Order.asc("vid").ignoreCase());
                } else if (sortField.equals("vname")) {
                    criteria.addOrder(Order.asc("vname").ignoreCase());
                } else if (sortField.equals("vdesc")) {
                    criteria.addOrder(Order.asc("vdesc").ignoreCase());
                } else if (sortField.equals("vstat")) {
                    criteria.addOrder(Order.asc("vstat").ignoreCase());
                }
            } else if (sortField.equals("vid")) {
                criteria.addOrder(Order.desc("vid").ignoreCase());
            } else if (sortField.equals("vname")) {
                criteria.addOrder(Order.desc("vname").ignoreCase());
            } else if (sortField.equals("vdesc")) {
                criteria.addOrder(Order.desc("vdesc").ignoreCase());
            } else if (sortField.equals("vstat")) {
                criteria.addOrder(Order.desc("vstat").ignoreCase());
            }
        }

        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstapps> tempResult = criteria.list();
        for (AhmjxuamMstapps ahmjxuamMstapps : tempResult) {
            Uam008VoAhmjxuamMstapps uam008VoAhmjxuamMstapps = new Uam008VoAhmjxuamMstapps();
            uam008VoAhmjxuamMstapps.setVid(ahmjxuamMstapps.getVid());
            uam008VoAhmjxuamMstapps.setIver(ahmjxuamMstapps.getIver());
            uam008VoAhmjxuamMstapps.setVcrea(ahmjxuamMstapps.getCreateBy());
            uam008VoAhmjxuamMstapps.setDcrea(ahmjxuamMstapps.getCreateDate());
            uam008VoAhmjxuamMstapps.setVname(ahmjxuamMstapps.getVname());
            uam008VoAhmjxuamMstapps.setVdesc(ahmjxuamMstapps.getVdesc());
            uam008VoAhmjxuamMstapps.setVstat(Uam008Util.convertStatus(ahmjxuamMstapps.getVstat()));
            result.add(uam008VoAhmjxuamMstapps);
        }

        return result;
    }

}
