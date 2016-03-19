/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app010.dao.impl;

import com.ahm.jx.app000.model.AhmjxuamMstpartner;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app010.vo.Uam010VoAhmjxuamMstpartner;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.ahm.jx.uam.app010.dao.Uam010AhmjxuamMstpartnerDao;

/**
 *
 * @author hendra.fs
 */
@Repository("uam010AhmjxuamMstpartnerDao")
public class Uam010AhmjxuamMstpartnerDaoImpl extends GenericHibernateDao<AhmjxuamMstpartner, String>
        implements Uam010AhmjxuamMstpartnerDao {

    public AhmjxuamMstpartner findByDealerCode(String dealerCode) {
        Criteria crit = getCurrentSession().createCriteria(AhmjxuamMstpartner.class, "ahmjxuamMstpartner");
        crit.add(Restrictions.eq("vdealercode", dealerCode));

        return (AhmjxuamMstpartner) crit.uniqueResult();
    }

    public int getPagingCountAhmjxuamMstpartner(Map<String, Object> filters) {
        int result = 0;

        List<Map.Entry<String, String>> searchParams = new ArrayList<Map.Entry<String, String>>();
        String hql = "select count(*) "
                + "from AhmjxuamMstpartner ";

        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase("any")) {
                    String valueStr = filter.getValue().toString().trim().toLowerCase();
                    if (valueStr != null && !valueStr.equals("")) {
                        hql += "where (";
                        String[] params = AhmStringUtil.splitBySpace(valueStr);

                        for (int i = 0; i < params.length; i++) {
                            if (i > 0) {
                                hql += "\n or ";
                            }
                            hql += "(lower(vdealercode) like :searchParam" + i + " "
                                    + "or lower(vname) like :searchParam" + i + " "
                                    + "or lower(vmdcode) like :searchParam" + i + " "
                                    + "or lower(str(nlevel)) like :searchParam" + i + " "
                                    + "or lower(str(dbegineff)) like :searchParam" + i + " "
                                    + "or lower(str(dendeff)) like :searchParam" + i + " ) ";
                            searchParams.add(new AbstractMap.SimpleEntry("searchParam" + i, params[i]));
                        }

                        hql += ") ";
                    }
                }
            }
        }

        Query query = getCurrentSession().createQuery(hql);
        for (Map.Entry<String, String> param : searchParams) {
            query.setString(param.getKey(), "%" + param.getValue() + "%");
        }

        Number number = (Number) query.uniqueResult();
        result = number.intValue();
        return result;
    }

    public List<Uam010VoAhmjxuamMstpartner> getPagingDataAhmjxuamMstpartner(int first, int pageSize,
            String sortField, String sortOrder, Map<String, Object> filters) {
        List<Uam010VoAhmjxuamMstpartner> result = new ArrayList<Uam010VoAhmjxuamMstpartner>();
        List<Map.Entry<String, String>> searchParams = new ArrayList<Map.Entry<String, String>>();
        String hql = "select vid, vdealercode, vname, vmdcode, "
                + "case "
                + "when nlevel = 1 then 'H1' "
                + "when nlevel = 2 then 'H2' "
                + "when nlevel = 3 then 'H12' "
                + "when nlevel = 4 then 'H3' "
                + "when nlevel = 5 then 'H13' "
                + "when nlevel = 6 then 'H23' "
                + "when nlevel = 7 then 'H123' "
                + "end as vlevel, "
                + "dbegineff, dendeff, iver "
                + "from AhmjxuamMstpartner ";

        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase("any")) {
                    String valueStr = filter.getValue().toString().trim().toLowerCase();
                    if (valueStr != null && !valueStr.equals("")) {
                        hql += "where (";
                        String[] params = AhmStringUtil.splitBySpace(valueStr);

                        for (int i = 0; i < params.length; i++) {
                            if (i > 0) {
                                hql += "\n or ";
                            }
                            hql += "(lower(vdealercode) like :searchParam" + i + " "
                                    + "or lower(vname) like :searchParam" + i + " "
                                    + "or lower(vmdcode) like :searchParam" + i + " "
                                    + "or lower(case "
                                    + "when nlevel = 1 then 'h1' "
                                    + "when nlevel = 2 then 'h2' "
                                    + "when nlevel = 3 then 'h12' "
                                    + "when nlevel = 4 then 'h3' "
                                    + "when nlevel = 5 then 'h13' "
                                    + "when nlevel = 6 then 'h23' "
                                    + "when nlevel = 7 then 'h123' "
                                    + "end) like :searchParam" + i + " "
                                    + "or lower(str(dbegineff)) like :searchParam" + i + " "
                                    + "or lower(str(dendeff)) like :searchParam" + i + " ) ";
                            searchParams.add(new AbstractMap.SimpleEntry("searchParam" + i, params[i]));
                        }

                        hql += ") ";
                    }
                }
            }
        }

        if (sortField != null) {
            if (sortOrder.equals(CommonConstant.ASC)) {
                hql += "order by " + sortField + " asc ";
            } else {
                hql += "order by " + sortField + " desc ";
            }
        }

        Query query = getCurrentSession().createQuery(hql);
        for (Map.Entry<String, String> param : searchParams) {
            query.setString(param.getKey(), "%" + param.getValue() + "%");
        }

        query.setFirstResult(first);
        query.setMaxResults(pageSize);
        Uam010VoAhmjxuamMstpartner uam010VoAhmjxuamMstpartner;
        List<Object[]> tempResult = query.list();
        for (Object[] ahmjxuamMstpartner : tempResult) {
            uam010VoAhmjxuamMstpartner = new Uam010VoAhmjxuamMstpartner();
            uam010VoAhmjxuamMstpartner.setVid((String) ahmjxuamMstpartner[0]);
            uam010VoAhmjxuamMstpartner.setVdealercode((String) ahmjxuamMstpartner[1]);
            uam010VoAhmjxuamMstpartner.setVname((String) ahmjxuamMstpartner[2]);
            uam010VoAhmjxuamMstpartner.setVmdcode((String) ahmjxuamMstpartner[3]);
            uam010VoAhmjxuamMstpartner.setVlevel((String) ahmjxuamMstpartner[4]);
            uam010VoAhmjxuamMstpartner.setDbegineff((Date) ahmjxuamMstpartner[5]);
            uam010VoAhmjxuamMstpartner.setDendeff((Date) ahmjxuamMstpartner[6]);
            uam010VoAhmjxuamMstpartner.setIver((Integer) ahmjxuamMstpartner[7]);

            result.add(uam010VoAhmjxuamMstpartner);
        }

        return result;
    }
}
