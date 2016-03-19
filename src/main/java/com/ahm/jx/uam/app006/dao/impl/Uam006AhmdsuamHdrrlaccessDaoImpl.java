/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.dao.impl;

import com.ahm.jx.app000.model.AhmdsuamHdrrlaccess;
import com.ahm.jx.app000.model.AhmdsuamMstmenus;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app006.dao.Uam006AhmdsuamHdrrlaccessDao;
import com.ahm.jx.uam.app006.vo.Uam006VoAhmdsuamHdrrlaccess;
import java.io.Serializable;
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
 * @author george
 */
@Repository("uam006AhmdsuamHdrrlaccessDao")
public class Uam006AhmdsuamHdrrlaccessDaoImpl extends GenericHibernateDao<AhmdsuamHdrrlaccess, String>
implements Uam006AhmdsuamHdrrlaccessDao{

    public int getPagingCountAhmdsuamHdrrlaccess(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamHdrrlaccess.class, "ahmdsuamHdrrlaccess");
        criteria.createAlias("ahmdsuamHdrrlaccess.ahmdsuamMstmenus", "ahmdsuamMstmenus");
        criteria.createAlias("ahmdsuamHdrrlaccess.ahmdsuamMstroles", "ahmdsuamMstroles");
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"ahmdsuamMstroles.vrolesId","ahmdsuamMstroles.vrolesName",
                                "ahmdsuamMstmenus.vmenuId","ahmdsuamMstmenus.vtitle"},
                            AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }

    public List<Uam006VoAhmdsuamHdrrlaccess> getPagingDataAhmdsuamHdrrlaccess(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<Uam006VoAhmdsuamHdrrlaccess> result=new ArrayList<Uam006VoAhmdsuamHdrrlaccess>();
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamHdrrlaccess.class, "ahmdsuamHdrrlaccess");
        criteria.createAlias("ahmdsuamHdrrlaccess.ahmdsuamMstmenus", "ahmdsuamMstmenus");
        criteria.createAlias("ahmdsuamHdrrlaccess.ahmdsuamMstroles", "ahmdsuamMstroles");
        criteria.add(Restrictions.isNotNull("ahmdsuamMstmenus.vurl"));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"ahmdsuamMstroles.vrolesId","ahmdsuamMstroles.vrolesName",
                                "ahmdsuamMstmenus.vmenuId","ahmdsuamMstmenus.vtitle"},
                            AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vmenuid")) {
                    criteria.addOrder(Order.asc("ahmdsuamMstmenus.vmenuId").ignoreCase());
                } else if (sortField.equals("vtitle")) {
                    criteria.addOrder(Order.asc("ahmdsuamMstmenus.vtitle").ignoreCase());
                } else if (sortField.equals("vrolesId")) {
                    criteria.addOrder(Order.asc("ahmdsuamMstroles.vrolesId").ignoreCase());
                } else if (sortField.equals("vrolesName")) {
                    criteria.addOrder(Order.asc("ahmdsuamMstroles.vrolesName").ignoreCase());
                }
            } else {
                if (sortField.equals("vmenuid")) {
                    criteria.addOrder(Order.desc("ahmdsuamMstmenus.vmenuId").ignoreCase());
                } else if (sortField.equals("vtitle")) {
                    criteria.addOrder(Order.desc("ahmdsuamMstmenus.vtitle").ignoreCase());
                } else if (sortField.equals("vrolesId")) {
                    criteria.addOrder(Order.desc("ahmdsuamMstroles.vrolesId").ignoreCase());
                } else if (sortField.equals("vrolesName")) {
                    criteria.addOrder(Order.desc("ahmdsuamMstroles.vrolesName").ignoreCase());
                }
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmdsuamHdrrlaccess> tempResult = criteria.list();
        for(AhmdsuamHdrrlaccess ahmdsuamHdrrlaccess:tempResult){
            Uam006VoAhmdsuamHdrrlaccess voAhmdsuamHdrrlaccess=new Uam006VoAhmdsuamHdrrlaccess();
            voAhmdsuamHdrrlaccess.setVid(ahmdsuamHdrrlaccess.getVid());
            voAhmdsuamHdrrlaccess.setIver(ahmdsuamHdrrlaccess.getIver());
            voAhmdsuamHdrrlaccess.setVidAhmdsuamMstmenus(ahmdsuamHdrrlaccess.getVidAhmdsuamMstmenus());
            voAhmdsuamHdrrlaccess.setVidAhmdsuamMstroles(ahmdsuamHdrrlaccess.getVidAhmdsuamMstroles());
            voAhmdsuamHdrrlaccess.setVmenuid(ahmdsuamHdrrlaccess.getAhmdsuamMstmenus().getVmenuId());
            voAhmdsuamHdrrlaccess.setVtitle(ahmdsuamHdrrlaccess.getAhmdsuamMstmenus().getVtitle());
            voAhmdsuamHdrrlaccess.setVrolesId(ahmdsuamHdrrlaccess.getAhmdsuamMstroles().getVrolesId());
            voAhmdsuamHdrrlaccess.setVrolesName(ahmdsuamHdrrlaccess.getAhmdsuamMstroles().getVrolesName());
            result.add(voAhmdsuamHdrrlaccess);
        }
        return result;
    }

    public boolean isHasNeighbour(String vid, String role, String parent) {
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamHdrrlaccess.class, "ahmdsuamHdrrlaccess");
        criteria.createAlias("ahmdsuamHdrrlaccess.ahmdsuamMstmenus", "ahmdsuamMstmenus");
        criteria.createAlias("ahmdsuamHdrrlaccess.ahmdsuamMstroles", "ahmdsuamMstroles");
        criteria.add(Restrictions.eq("vidAhmdsuamMstroles", role));
        criteria.add(Restrictions.eq("ahmdsuamMstmenus.vparent", parent));
        
        List<AhmdsuamHdrrlaccess> tempResult = criteria.list();
        
        return tempResult.size()>1;
    }

    public AhmdsuamHdrrlaccess getParentRoleAccess(String role, String parent) {
        AhmdsuamHdrrlaccess result;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamHdrrlaccess.class, "ahmdsuamHdrrlaccess");
        criteria.createAlias("ahmdsuamHdrrlaccess.ahmdsuamMstmenus", "ahmdsuamMstmenus");
        criteria.createAlias("ahmdsuamHdrrlaccess.ahmdsuamMstroles", "ahmdsuamMstroles");
        criteria.add(Restrictions.eq("vidAhmdsuamMstroles", role));
        criteria.add(Restrictions.eq("vidAhmdsuamMstmenus", parent));
        
        result =(AhmdsuamHdrrlaccess) criteria.uniqueResult();
        return result;
    }
}
