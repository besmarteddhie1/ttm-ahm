/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app001.dao.impl;

import com.ahm.jx.app000.model.AhmdsbscMstdlrcode;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app001.dao.Uam001AhmdsbscMstdlrcodeDao;
import com.ahm.jx.uam.app001.vo.Uam001VoAhmdsbscMstdlrcode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hendra.fs
 */
@Repository("uam001AhmdsbscMstdlrcodeDao")
public class Uam001AhmdsbscMstdlrcodeDaoImpl extends GenericHibernateDao<AhmdsbscMstdlrcode, String>
        implements Uam001AhmdsbscMstdlrcodeDao {

    public AhmdsbscMstdlrcode findByDealerCode(String dealerCode) {
        Criteria crit = getCurrentSession().createCriteria(AhmdsbscMstdlrcode.class, "ahmdsbscMstdlrcode");
        crit.add(Restrictions.eq("vdealercode", dealerCode));
        
        return (AhmdsbscMstdlrcode) crit.uniqueResult();
    }
    
    public int getPagingCountAhmdsbscMstdlrcode(Map<String, Object> filters) {
        int result = 0;
        
        List<Map.Entry<String, String>> searchParams = new ArrayList<Map.Entry<String, String>>();
        String hql = "select count(*) "
                + "from AhmdsbscMstdlrcode ";
        
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

    public List<Uam001VoAhmdsbscMstdlrcode> getPagingDataAhmdsbscMstdlrcode(int first, int pageSize,
            String sortField, String sortOrder, Map<String, Object> filters) {
        List<Uam001VoAhmdsbscMstdlrcode> result = new ArrayList<Uam001VoAhmdsbscMstdlrcode>();
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
                + "from AhmdsbscMstdlrcode ";
        
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
                hql += "order by "+sortField+" asc ";
            } else {
                hql += "order by "+sortField+" desc ";
            }
        }
        
        Query query = getCurrentSession().createQuery(hql);
        for (Map.Entry<String, String> param : searchParams) {
            query.setString(param.getKey(), "%" + param.getValue() + "%");
        }
        
        query.setFirstResult(first);
        query.setMaxResults(pageSize);
        Uam001VoAhmdsbscMstdlrcode uam001VoAhmdsbscMstdlrcode;
        List<Object[]> tempResult = query.list();
        for (Object[] ahmdsbscMstdlrcode : tempResult) {
            uam001VoAhmdsbscMstdlrcode = new Uam001VoAhmdsbscMstdlrcode();
            uam001VoAhmdsbscMstdlrcode.setVid((String) ahmdsbscMstdlrcode[0]);
            uam001VoAhmdsbscMstdlrcode.setVdealercode((String) ahmdsbscMstdlrcode[1]);
            uam001VoAhmdsbscMstdlrcode.setVname((String) ahmdsbscMstdlrcode[2]);
            uam001VoAhmdsbscMstdlrcode.setVmdcode((String) ahmdsbscMstdlrcode[3]);
            uam001VoAhmdsbscMstdlrcode.setVlevel((String) ahmdsbscMstdlrcode[4]);
            uam001VoAhmdsbscMstdlrcode.setDbegineff((Date) ahmdsbscMstdlrcode[5]);
            uam001VoAhmdsbscMstdlrcode.setDendeff((Date) ahmdsbscMstdlrcode[6]);
            uam001VoAhmdsbscMstdlrcode.setIver((Integer) ahmdsbscMstdlrcode[7]);
            
            result.add(uam001VoAhmdsbscMstdlrcode);
        }
        
        return result;
    }
}
