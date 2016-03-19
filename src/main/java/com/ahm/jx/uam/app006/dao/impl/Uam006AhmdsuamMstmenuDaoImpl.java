/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app006.dao.impl;

import com.ahm.jx.app000.model.AhmdsuamHdrrlaccess;
import com.ahm.jx.app000.model.AhmdsuamMstmenus;
import com.ahm.jx.app000.vo.VoAhmdsuamMstmenus;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app006.dao.Uam006AhmdsuamMstmenuDao;
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
@Repository("uam006AhmdsuamMstmenuDao")
public class Uam006AhmdsuamMstmenuDaoImpl extends GenericHibernateDao<AhmdsuamMstmenus, String>
implements Uam006AhmdsuamMstmenuDao{

    public int getPagingCountAhmsuamMstmenus(Map<String, Object> filters) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstmenus.class, "ahmdsuamMstmenus");
        criteria.add(Restrictions.isNotNull("vurl"));
        criteria.add(Restrictions.eq("vstat", "T"));
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                            new String[]{"vmenuId","vtitle"},
                            AhmStringUtil.splitBySpace(valueStr)));
                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        return result;
    }

    public List<VoAhmdsuamMstmenus> getPagingDataAhmdsh1cMstmenus(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        List<VoAhmdsuamMstmenus> result = new ArrayList<VoAhmdsuamMstmenus>();
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstmenus.class, "ahmdsuamMstmenus");
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
                            new String[]{"vmenuId","vtitle"},
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
            } else {
                if (sortField.equals("vmenuid")) {
                    criteria.addOrder(Order.desc("vmenuId").ignoreCase());
                } else if (sortField.equals("vtitle")) {
                    criteria.addOrder(Order.desc("vtitle").ignoreCase());
                }
            }
        }
        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmdsuamMstmenus> tempResult = criteria.list();
        for (AhmdsuamMstmenus ahmdsh1cMstmenus : tempResult) {
            VoAhmdsuamMstmenus voAhmdsh1cMstmenus = new VoAhmdsuamMstmenus();
            voAhmdsh1cMstmenus.setVid(ahmdsh1cMstmenus.getVid());
            voAhmdsh1cMstmenus.setVmenuid(ahmdsh1cMstmenus.getVmenuId());
            voAhmdsh1cMstmenus.setVtitle(ahmdsh1cMstmenus.getVtitle());
            result.add(voAhmdsh1cMstmenus);
        }
        return result;
    }

    public String getParentId(String vidAhmdsuamMstmenus) {
        String result;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstmenus.class, "ahmdsuamMstmenus");
        criteria.add(Restrictions.eq("vid", vidAhmdsuamMstmenus));
        
        result =((AhmdsuamMstmenus) criteria.uniqueResult()).getVparent();
        return result;
    }

    /*Cek parent sudah tersimpan di tabel AHMDSUAM_HDRRLACCESS */
    public boolean isParentExist(String parent, String rolesId) {
        int result = 0;
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamHdrrlaccess.class, "ahmdsuamHdrrlaccess");
        criteria.add(Restrictions.eq("vidAhmdsuamMstmenus", parent));
        criteria.add(Restrictions.eq("vidAhmdsuamMstroles", rolesId));
        
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();
        if(result>0){
            return true;
        }
        return false;
    }

}
