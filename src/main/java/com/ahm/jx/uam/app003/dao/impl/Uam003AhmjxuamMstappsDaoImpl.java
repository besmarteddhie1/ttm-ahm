package com.ahm.jx.uam.app003.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.ahm.jx.app000.model.AhmjxuamMstapps;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app003.dao.Uam003AhmjxuamMstappsDao;
import com.ahm.jx.uam.app003.vo.Uam003VoApp;
import com.ahm.jx.uam.app008.util.Uam008Util;
import com.ahm.jx.uam.app008.vo.Uam008VoAhmjxuamMstapps;

@Repository("uam003AhmjxuamMstappsDao")
public class Uam003AhmjxuamMstappsDaoImpl extends GenericHibernateDao<AhmjxuamMstapps, String> implements Uam003AhmjxuamMstappsDao {

	@Override
	public List<Uam003VoApp> getPagingDataAhmjxuamMstapps(int first, int pageSize, String sortField, String sortOrder,
			Map<String, Object> filters) {
		List<Uam003VoApp> result = new ArrayList<Uam003VoApp>();
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstapps.class, "ahmjxuamMstapps");

        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vname"},
                                    AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }

        if (sortField != null) {
            System.out.println("sortField : " + sortField);
            if (sortOrder.equals(CommonConstant.ASC)) {
            	if (sortField.equals("vname")) {
                    criteria.addOrder(Order.asc("vname").ignoreCase());
                }
            } else if (sortField.equals("vname")) {
                criteria.addOrder(Order.desc("vname").ignoreCase());
            }
        }

        System.out.println("first : " + first);
        System.out.println("pageSize : " + pageSize);
        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);
        List<AhmjxuamMstapps> tempResult = criteria.list();
        for (AhmjxuamMstapps ahmjxuamMstapps : tempResult) {
            Uam003VoApp vo = new Uam003VoApp();
            vo.setVid(ahmjxuamMstapps.getVid());
            vo.setVname(ahmjxuamMstapps.getVname());
            result.add(vo);
        }

        return result;
	}

	@Override
	public int getPagingCountAhmjxuamMstapps(Map<String, Object> filters) {
		// TODO Auto-generated method stub

		int result = 0;

        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstapps.class, "ahmjxuamMstapps");
        if (filters != null) {
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
                    String valueStr = filter.getValue().toString();
                    criteria.add(
                            buildResctrictionsAndForAllProperty(
                                    new String[]{"vname"},
                                    AhmStringUtil.splitBySpace(valueStr)));

                }
            }
        }
        criteria.setProjection(Projections.rowCount());
        Number number = (Number) criteria.uniqueResult();
        result = number.intValue();

        return result;
	}

}
