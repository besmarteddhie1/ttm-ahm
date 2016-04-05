/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app009.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamHstappusgs;
import com.ahm.jx.app000.model.AhmjxuamMstroles;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import com.ahm.jx.uam.app009.dao.Uam009AhmjxuamHstappusgsDao;
import com.ahm.jx.uam.app009.vo.Uam009VoAhmjxuamHstappusgs;
import java.text.DecimalFormat;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

/**
 *
 * @author ferdy
 */
@Repository("uam009AhmjxuamHstappusgsDao")
public class Uam009AhmjxuamHstappusgsDaoImpl extends GenericHibernateDao<Uam009VoAhmjxuamHstappusgs, String>
        implements Uam009AhmjxuamHstappusgsDao {
    
    public List<Uam009VoAhmjxuamHstappusgs> getActive(Integer diff) {
        List<Uam009VoAhmjxuamHstappusgs> result = new ArrayList<Uam009VoAhmjxuamHstappusgs>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamHstappusgs.class, "AhmjxuamHstappusgs")
                .setProjection(Projections.projectionList());
        if (diff==0)
        {
            criteria.setProjection(Projections.projectionList()
                    .add(Projections.count("vid").as("cVid"))
                    .add(Projections.groupProperty("vusername")));
        }
        else  
        {            
            criteria.setProjection(Projections.projectionList()
                    .add(Projections.count("vid").as("cVid"))
                    .add(Projections.groupProperty("vapp")));
        }
            criteria.setMaxResults(10);
            criteria.addOrder(Order.desc("cVid"));
                    
        List<Object[]> tempResult = criteria.list();
        double sum = 0;
        DecimalFormat df = new DecimalFormat("###.##");
        for(Object[] tr : tempResult)
        {
            sum = sum +Integer.parseInt(String.valueOf(tr[0]));
        }
        for(Object[] tr:tempResult)
        {
                double a = Integer.parseInt(String.valueOf(tr[0]));
                Uam009VoAhmjxuamHstappusgs uam009VoAhmjxuamHstappusgs = new Uam009VoAhmjxuamHstappusgs();
                uam009VoAhmjxuamHstappusgs.setVid(df.format(a/sum*100));
                if (diff==0)
                {uam009VoAhmjxuamHstappusgs.setVusername((String) tr[1]);}
                else{uam009VoAhmjxuamHstappusgs.setVapp((String) tr[1]);}
            result.add(uam009VoAhmjxuamHstappusgs);
        }
        return result;
    }
//
//    public int getPagingCount(Map<String, Object> filters) {
//        int result = 0;
//        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamHstappusgs.class, "AhmjxuamHstappusgs");
//        if (filters != null) {
//            for (Map.Entry<String, Object> filter : filters.entrySet()) {
//                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
//                    String valueStr = filter.getValue().toString();
//                    criteria.add(
//                            buildResctrictionsAndForAllProperty(
//                                    new String[]{"vrolesId", "vrolesName", "vrolesDesc", "vrolesStatus"},
//                                    AhmStringUtil.splitBySpace(valueStr)));
//
//                }
//            }
//        }
//        criteria.setProjection(Projections.rowCount());
//        Number number = (Number) criteria.uniqueResult();
//        result = number.intValue();
//        return result;
//    }
//    
//    public List<Uam009VoAhmjxuamHstappusgs> getPagingData(int first, int pageSize,
//            String sortField, String sortOrder, Map<String, Object> filters) {
//        System.out.println(sortField);
//        System.out.println("filters=>"+filters);
//        List<Uam009VoAhmjxuamHstappusgs> result = new ArrayList<Uam009VoAhmjxuamHstappusgs>();
//        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamHstappusgs.class, "ahmjxuamMstroles");
//
//        if (filters != null) {
//            for (Map.Entry<String, Object> filter : filters.entrySet()) {
//                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
//                    String valueStr = filter.getValue().toString();
//                    criteria.add(
//                            buildResctrictionsAndForAllProperty(
//                                    new String[]{"vrolesId", "vrolesName", "vrolesDesc", "vrolesStatus"},
//                                    AhmStringUtil.splitBySpace(valueStr)));
//
//                }
//            }
//        }
//
//        if (sortField != null) {
//            System.out.println("sortField : " + sortField);
//            if (sortOrder.equals(CommonConstant.ASC)) {
//                if (sortField.equals("vrolesId")) {
//                    criteria.addOrder(Order.asc("vrolesId").ignoreCase());
//                } else if (sortField.equals("vrolesName")) {
//                    criteria.addOrder(Order.asc("vrolesName").ignoreCase());
//                } else if (sortField.equals("vrolesDesc")) {
//                    criteria.addOrder(Order.asc("vrolesDesc").ignoreCase());
//                } else if (sortField.equals("vrolesStatus")) {
//                    criteria.addOrder(Order.asc("vrolesStatus").ignoreCase());
//                }
//            } else if (sortField.equals("vrolesId")) {
//                criteria.addOrder(Order.desc("vrolesId").ignoreCase());
//            } else if (sortField.equals("vrolesName")) {
//                criteria.addOrder(Order.desc("vrolesName").ignoreCase());
//            } else if (sortField.equals("vrolesDesc")) {
//                criteria.addOrder(Order.desc("vrolesDesc").ignoreCase());
//            } else if (sortField.equals("vrolesStatus")) {
//                criteria.addOrder(Order.desc("vrolesStatus").ignoreCase());
//            }
//        }
//
//        System.out.println("first : " + first);
//        System.out.println("pageSize : " + pageSize);
//        criteria.setFirstResult(first);
//        criteria.setMaxResults(pageSize);
//        List<Uam009VoAhmjxuamHstappusgs> tempResult = criteria.list();
//        for (Uam009VoAhmjxuamHstappusgs tr : tempResult) {
//            Uam009VoAhmjxuamHstappusgs uam009VoAhmjxuamHstappusgs = new Uam009VoAhmjxuamHstappusgs();
//            result.add(uam009VoAhmjxuamHstappusgs);
//        }
//        return result;
//    }


}
