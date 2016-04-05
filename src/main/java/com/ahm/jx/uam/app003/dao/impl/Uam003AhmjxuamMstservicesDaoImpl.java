/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstapps;
import com.ahm.jx.app000.model.AhmjxuamMstservices;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app003.dao.Uam003AhmjxuamMstservicesDao;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmjxuamMstservice;
import com.ahm.jx.uam.app004.vo.Uam004VoAhmjxuamMstmenus;
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
 * @author sigit
 */
@Repository("uam003AhmjxuamMstservicesDao")
public class Uam003AhmjxuamMstservicesDaoImpl extends GenericHibernateDao<AhmjxuamMstservices, String>
        implements Uam003AhmjxuamMstservicesDao {

    @Override
    public int getPagingCountAhmjxuamMstservices(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstservices.class, "ahmjxuamMstservices");
        criteria.createAlias("ahmjxuamMstservices.ahmjxuamMstapps", "ahmjxuamMstapps");

        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vsvcName", "vsvcDesc", "vurl"},
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
    public List<Uam003VoAhmjxuamMstservice> getPagingDataAhmjxuamMstservices(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<Uam003VoAhmjxuamMstservice> result = new ArrayList<Uam003VoAhmjxuamMstservice>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstservices.class, "ahmjxuamMstservices");
        criteria.createAlias("ahmjxuamMstservices.ahmjxuamMstapps", "ahmjxuamMstapps");
        
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vsvcName", "vsvcDesc", "vurl"},
                                    AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vsvcName")) {
                    criteria.addOrder(Order.asc("vsvcName").ignoreCase());
                } else if (sortField.equals("vsvcDesc")) {
                    criteria.addOrder(Order.asc("vsvcDesc").ignoreCase());
                } else if (sortField.equals("vurl")) {
                    criteria.addOrder(Order.asc("vurl").ignoreCase());
                }
            } else if (sortField.equals("vsvcName")) {
                criteria.addOrder(Order.desc("vsvcName").ignoreCase());
            } else if (sortField.equals("vsvcDesc")) {
                criteria.addOrder(Order.desc("vsvcDesc").ignoreCase());
            } else if (sortField.equals("vurl")) {
                criteria.addOrder(Order.desc("vurl").ignoreCase());
            }
        }

        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);

        List<AhmjxuamMstservices> tempResult = criteria.list();
        for (AhmjxuamMstservices ahmjxuamMstservices : tempResult) {
            Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservice = new Uam003VoAhmjxuamMstservice();
            uam003VoAhmjxuamMstservice.setVid(ahmjxuamMstservices.getVid());
            uam003VoAhmjxuamMstservice.setIver(ahmjxuamMstservices.getIver());
            uam003VoAhmjxuamMstservice.setVsvcName(ahmjxuamMstservices.getVsvcName());
            uam003VoAhmjxuamMstservice.setVsvcDesc(ahmjxuamMstservices.getVsvcDesc());
            uam003VoAhmjxuamMstservice.setVurl(ahmjxuamMstservices.getVurl());
            uam003VoAhmjxuamMstservice.setVstat(getStatDesc(ahmjxuamMstservices.getVstat()));
            uam003VoAhmjxuamMstservice.setVidAhmjxuamMstapps(ahmjxuamMstservices.getVidAhmjxuamMstapps());
            uam003VoAhmjxuamMstservice.setVname(ahmjxuamMstservices.getAhmjxuamMstapps().getVname());

            result.add(uam003VoAhmjxuamMstservice);
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

}
