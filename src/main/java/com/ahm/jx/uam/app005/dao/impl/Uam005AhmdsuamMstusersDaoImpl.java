/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.dao.impl;

import com.ahm.jx.app000.model.AhmdsuamMstusers;
import com.ahm.jx.app000.model.AhmdsuamMstusrrols;
import com.ahm.jx.app000.vo.VoAhmdsuamMstusers;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app005.dao.Uam005AhmdsuamMstusersDao;
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

@Repository("uam005AhmdsuamMstusersDao")
public class Uam005AhmdsuamMstusersDaoImpl extends GenericHibernateDao<AhmdsuamMstusers, String>
        implements Uam005AhmdsuamMstusersDao{

    public int getPagingCountAhmsuamMstusers(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstusers.class,"ahmdsuamMstusers");
        criteria.add(Restrictions.and(Restrictions.eq("vstat", "T")));
        if (filters != null) {            
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vid", "vusername"},
                            AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }

    public List<VoAhmdsuamMstusers> getPagingDataAhmdsh1cMstusers(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<VoAhmdsuamMstusers> result = new ArrayList<VoAhmdsuamMstusers>();
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstusers.class,"ahmdsuamMstusers");
        criteria.add(Restrictions.and(Restrictions.eq("vstat", "T")));
        if(filters!=null){
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                System.out.println("key "+filter.getKey());
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    System.out.println("valueStr : "+valueStr);
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vid", "vusername"},
                            AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }else{
            System.out.println("filter null");
        }
        
        if(sortField!=null){            
            System.out.println("sortField : "+sortField);
            if(sortOrder.equals(CommonConstant.ASC)){
                if(sortField.equals("vid")){
                    criteria.addOrder(Order.asc("vid").ignoreCase());                
                }else if(sortField.equals("vusername")){
                    criteria.addOrder(Order.asc("vusername").ignoreCase());                
                } 
            }else{
                if(sortField.equals("vid")){
                    criteria.addOrder(Order.desc("vid").ignoreCase());                
                }else if(sortField.equals("vusername")){
                    criteria.addOrder(Order.desc("vusername").ignoreCase());                
                }
            }
        }
        System.out.println("first : "+first);
        System.out.println("pageSize : "+pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmdsuamMstusers> tempResult = criteria.list();
        for(AhmdsuamMstusers ahmdsh1cMstusers : tempResult){
            VoAhmdsuamMstusers voAhmdsh1cMstuser = new VoAhmdsuamMstusers();
            voAhmdsh1cMstuser.setVid(ahmdsh1cMstusers.getVid());
            voAhmdsh1cMstuser.setVusername(ahmdsh1cMstusers.getVusername());     
            result.add(voAhmdsh1cMstuser);
        }
        return result;
    }
    
}
