/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.dao.impl;

import com.ahm.jx.app000.model.AhmdsuamMstroles;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app003.dao.Uam003AhmdsuamMstrolesDao;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmdsuamMstroles;
import com.ahm.jx.uam.app003.util.Uam003Util;
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
 * @author indriHtb
 */
@Repository("uam003AhmdsuamMstrolesDao")
public class Uam003AhmdsuamMstrolesDaoImpl extends GenericHibernateDao<AhmdsuamMstroles, String> implements Uam003AhmdsuamMstrolesDao{
    
    public int getPagingCountAhmdsuamMstroles(Map<String, Object> filters) {        
         int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstroles.class, "ahmdsuamMstroles");
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vrolesId", "vrolesName","vrolesDesc" , "vrolesStatus"},
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
                if (prop.equals("vrolesStatus")) {
                    if (Uam003Util.T.contains(valueLike.trim().toUpperCase())) {
                        valueLikeTemp = "T";
                    } else if (Uam003Util.F.contains(valueLike.trim().toUpperCase())) {
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

    public List<Uam003VoAhmdsuamMstroles> getPagingDataAhmdsuamMstroles(int first, int pageSize, 
            String sortField, String sortOrder, Map<String, Object> filters) {
       System.out.println(sortField);
        List<Uam003VoAhmdsuamMstroles> result = new ArrayList<Uam003VoAhmdsuamMstroles>();
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstroles.class,"ahmdsuamMstroles");
       
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vrolesId", "vrolesName","vrolesDesc" , "vrolesStatus"},
                            AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }
        
        if(sortField!=null){            
            System.out.println("sortField : "+sortField);
            if(sortOrder.equals(CommonConstant.ASC)){
                if(sortField.equals("vrolesId")){
                    criteria.addOrder(Order.asc("vrolesId").ignoreCase());                
                }else if(sortField.equals("vrolesName")){
                    criteria.addOrder(Order.asc("vrolesName").ignoreCase());                
                }else if(sortField.equals("vrolesDesc")){
                    criteria.addOrder(Order.asc("vrolesDesc").ignoreCase());                
                }else if(sortField.equals("vrolesStatus")){
                    criteria.addOrder(Order.asc("vrolesStatus").ignoreCase());
                }
            }else{
                if(sortField.equals("vrolesId")){
                    criteria.addOrder(Order.desc("vrolesId").ignoreCase());                
                }else if(sortField.equals("vrolesName")){
                    criteria.addOrder(Order.desc("vrolesName").ignoreCase());                
                }else if(sortField.equals("vrolesDesc")){
                    criteria.addOrder(Order.desc("vrolesDesc").ignoreCase());                
                }else if(sortField.equals("vrolesStatus")){
                    criteria.addOrder(Order.desc("vrolesStatus").ignoreCase());
                }
            }
        }
        
        System.out.println("first : "+first);
        System.out.println("pageSize : "+pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmdsuamMstroles> tempResult = criteria.list();
        for(AhmdsuamMstroles ahmdsuamMstroles : tempResult){
            Uam003VoAhmdsuamMstroles uam003VoAhmdsuamMstroles = new Uam003VoAhmdsuamMstroles();
            uam003VoAhmdsuamMstroles.setVid(ahmdsuamMstroles.getVid());
            uam003VoAhmdsuamMstroles.setIver(ahmdsuamMstroles.getIver());
            uam003VoAhmdsuamMstroles.setVrolesId(ahmdsuamMstroles.getVrolesId());
            uam003VoAhmdsuamMstroles.setVrolesName(ahmdsuamMstroles.getVrolesName());
            uam003VoAhmdsuamMstroles.setVrolesDesc(ahmdsuamMstroles.getVrolesDesc());
            uam003VoAhmdsuamMstroles.setVrolesStatus(Uam003Util.convertStatus(ahmdsuamMstroles.getVrolesStatus()));
            result.add(uam003VoAhmdsuamMstroles);
        }
        return result;
    }
        
}
