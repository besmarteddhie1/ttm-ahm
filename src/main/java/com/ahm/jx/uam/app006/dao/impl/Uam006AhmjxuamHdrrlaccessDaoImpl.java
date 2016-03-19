/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamHdrrlaccess;
import com.ahm.jx.app000.model.AhmjxuamMstmenus;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app006.vo.Uam006VoAhmjxuamHdrrlaccess;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.ahm.jx.uam.app006.dao.Uam006AhmjxuamHdrrlaccessDao;

/**
 *
 * @author george
 */
@Repository("uam006AhmjxuamHdrrlaccessDao")
public class Uam006AhmjxuamHdrrlaccessDaoImpl extends GenericHibernateDao<AhmjxuamHdrrlaccess, String>
        implements Uam006AhmjxuamHdrrlaccessDao {

    public int getPagingCountAhmjxuamHdrrlaccess(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamHdrrlaccess.class, "ahmjxuamHdrrlaccess");
        criteria.createAlias("ahmjxuamHdrrlaccess.ahmjxuamMstmenus", "ahmjxuamMstmenus");
        criteria.createAlias("ahmjxuamHdrrlaccess.ahmjxuamMstroles", "ahmjxuamMstroles");
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"ahmjxuamMstroles.vrolesId", "ahmjxuamMstroles.vrolesName",
                                        "ahmjxuamMstmenus.vmenuId", "ahmjxuamMstmenus.vtitle"},
                                    AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }

    public List<Uam006VoAhmjxuamHdrrlaccess> getPagingDataAhmjxuamHdrrlaccess(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<Uam006VoAhmjxuamHdrrlaccess> result = new ArrayList<Uam006VoAhmjxuamHdrrlaccess>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamHdrrlaccess.class, "ahmjxuamHdrrlaccess");
        criteria.createAlias("ahmjxuamHdrrlaccess.ahmjxuamMstmenus", "ahmjxuamMstmenus");
        criteria.createAlias("ahmjxuamHdrrlaccess.ahmjxuamMstroles", "ahmjxuamMstroles");
        criteria.add(Restrictions.isNotNull("ahmjxuamMstmenus.vurl"));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"ahmjxuamMstroles.vrolesId", "ahmjxuamMstroles.vrolesName",
                                        "ahmjxuamMstmenus.vmenuId", "ahmjxuamMstmenus.vtitle"},
                                    AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vmenuid")) {
                    criteria.addOrder(Order.asc("ahmjxuamMstmenus.vmenuId").ignoreCase());
                } else if (sortField.equals("vtitle")) {
                    criteria.addOrder(Order.asc("ahmjxuamMstmenus.vtitle").ignoreCase());
                } else if (sortField.equals("vrolesId")) {
                    criteria.addOrder(Order.asc("ahmjxuamMstroles.vrolesId").ignoreCase());
                } else if (sortField.equals("vrolesName")) {
                    criteria.addOrder(Order.asc("ahmjxuamMstroles.vrolesName").ignoreCase());
                }
            } else if (sortField.equals("vmenuid")) {
                criteria.addOrder(Order.desc("ahmjxuamMstmenus.vmenuId").ignoreCase());
            } else if (sortField.equals("vtitle")) {
                criteria.addOrder(Order.desc("ahmjxuamMstmenus.vtitle").ignoreCase());
            } else if (sortField.equals("vrolesId")) {
                criteria.addOrder(Order.desc("ahmjxuamMstroles.vrolesId").ignoreCase());
            } else if (sortField.equals("vrolesName")) {
                criteria.addOrder(Order.desc("ahmjxuamMstroles.vrolesName").ignoreCase());
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamHdrrlaccess> tempResult = criteria.list();
        for (AhmjxuamHdrrlaccess ahmjxuamHdrrlaccess : tempResult) {
            Uam006VoAhmjxuamHdrrlaccess voAhmjxuamHdrrlaccess = new Uam006VoAhmjxuamHdrrlaccess();
            voAhmjxuamHdrrlaccess.setVid(ahmjxuamHdrrlaccess.getVid());
            voAhmjxuamHdrrlaccess.setIver(ahmjxuamHdrrlaccess.getIver());
            voAhmjxuamHdrrlaccess.setVidAhmjxuamMstmenus(ahmjxuamHdrrlaccess.getVidAhmjxuamMstmenus());
            voAhmjxuamHdrrlaccess.setVidAhmjxuamMstroles(ahmjxuamHdrrlaccess.getVidAhmjxuamMstroles());
            voAhmjxuamHdrrlaccess.setVmenuid(ahmjxuamHdrrlaccess.getAhmjxuamMstmenus().getVmenuId());
            voAhmjxuamHdrrlaccess.setVtitle(ahmjxuamHdrrlaccess.getAhmjxuamMstmenus().getVtitle());
            voAhmjxuamHdrrlaccess.setVrolesId(ahmjxuamHdrrlaccess.getAhmjxuamMstroles().getVrolesId());
            voAhmjxuamHdrrlaccess.setVrolesName(ahmjxuamHdrrlaccess.getAhmjxuamMstroles().getVrolesName());
            result.add(voAhmjxuamHdrrlaccess);
        }
        return result;
    }

    public boolean isHasNeighbour(String vid, String role, String parent) {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamHdrrlaccess.class, "ahmjxuamHdrrlaccess");
        criteria.createAlias("ahmjxuamHdrrlaccess.ahmjxuamMstmenus", "ahmjxuamMstmenus");
        criteria.createAlias("ahmjxuamHdrrlaccess.ahmjxuamMstroles", "ahmjxuamMstroles");
        criteria.add(Restrictions.eq("vidAhmjxuamMstroles", role));
        criteria.add(Restrictions.eq("ahmjxuamMstmenus.vparent", parent));

        List<AhmjxuamHdrrlaccess> tempResult = criteria.list();

        return tempResult.size() > 1;
    }

    public AhmjxuamHdrrlaccess getParentRoleAccess(String role, String parent) {
        AhmjxuamHdrrlaccess result;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamHdrrlaccess.class, "ahmjxuamHdrrlaccess");
        criteria.createAlias("ahmjxuamHdrrlaccess.ahmjxuamMstmenus", "ahmjxuamMstmenus");
        criteria.createAlias("ahmjxuamHdrrlaccess.ahmjxuamMstroles", "ahmjxuamMstroles");
        criteria.add(Restrictions.eq("vidAhmjxuamMstroles", role));
        criteria.add(Restrictions.eq("vidAhmjxuamMstmenus", parent));

        result = (AhmjxuamHdrrlaccess) criteria.uniqueResult();
        return result;
    }
}
