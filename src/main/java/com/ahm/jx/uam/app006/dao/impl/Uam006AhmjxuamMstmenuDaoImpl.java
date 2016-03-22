/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamHdrrlaccess;
import com.ahm.jx.app000.model.AhmjxuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.ahm.jx.uam.app006.dao.Uam006AhmjxuamMstmenuDao;

/**
 *
 * @author george
 */
@Repository("uam006AhmjxuamMstmenuDao")
public class Uam006AhmjxuamMstmenuDaoImpl extends GenericHibernateDao<AhmjxuamMstmenus, String>
        implements Uam006AhmjxuamMstmenuDao {

    public int getPagingCountAhmsuamMstmenus(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstmenus.class, "ahmjxuamMstmenus");
        criteria.add(Restrictions.isNotNull("vurl"));
        criteria.add(Restrictions.eq("vstat", "T"));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vmenuId", "vtitle"},
                                    AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }

    public List<VoAhmjxuamMstmenus> getPagingDataAhmdsh1cMstmenus(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<VoAhmjxuamMstmenus> result = new ArrayList<VoAhmjxuamMstmenus>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstmenus.class, "ahmjxuamMstmenus");
        criteria.add(Restrictions.isNotNull("vurl"));
        criteria.add(Restrictions.eq("vstat", "T"));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                System.out.println("key " + filter.getKey());
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    System.out.println("valueStr : " + valueStr);
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vmenuId", "vtitle"},
                                    AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        } else {
            System.out.println("filter null");
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
                if (sortField.equals("vmenuid")) {
                    criteria.addOrder(Order.asc("vmenuId").ignoreCase());
                } else if (sortField.equals("vtitle")) {
                    criteria.addOrder(Order.asc("vtitle").ignoreCase());
                }
            } else if (sortField.equals("vmenuid")) {
                criteria.addOrder(Order.desc("vmenuId").ignoreCase());
            } else if (sortField.equals("vtitle")) {
                criteria.addOrder(Order.desc("vtitle").ignoreCase());
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstmenus> tempResult = criteria.list();
        for (AhmjxuamMstmenus ahmjxuamMstmenus : tempResult) {
            VoAhmjxuamMstmenus voAhmjxuamMstmenus = new VoAhmjxuamMstmenus();
            voAhmjxuamMstmenus.setVid(ahmjxuamMstmenus.getVid());
            voAhmjxuamMstmenus.setVmenuid(ahmjxuamMstmenus.getVmenuId());
            voAhmjxuamMstmenus.setVtitle(ahmjxuamMstmenus.getVtitle());
            result.add(voAhmjxuamMstmenus);
        }
        return result;
    }

    public String getParentId(String vidAhmjxuamMstmenus) {
        System.out.println("------> Uam006AhmjxuamMstmenuDaoImpl.getParentId()");
        System.out.println("------> vidAhmjxuamMstmenus: " + vidAhmjxuamMstmenus);
        String result;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstmenus.class, "ahmjxuamMstmenus");
        criteria.add(Restrictions.eq("vid", vidAhmjxuamMstmenus));

        result = ((AhmjxuamMstmenus) criteria.uniqueResult()).getVparent();
        return result;
    }

    /*Cek parent sudah tersimpan di tabel AHMDSUAM_HDRRLACCESS */
    public boolean isParentExist(String parent, String rolesId) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamHdrrlaccess.class, "ahmjxuamHdrrlaccess");
        criteria.add(Restrictions.eq("vidAhmjxuamMstmenus", parent));
        criteria.add(Restrictions.eq("vidAhmjxuamMstroles", rolesId));

        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        if (result > 0) {
            return true;
        }
        return false;
    }

}
