package com.ahm.jx.uam.app007.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ahm.jx.app000.model.AhmjxuamMstroles;
import com.ahm.jx.app000.model.AhmjxuamMstservices;
import com.ahm.jx.app000.model.AhmjxuamMstsvcrols;
import com.ahm.jx.app000.vo.VoAhmjxuamMstservices;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.util.AhmStringUtil;
import com.ahm.jx.uam.app006.dao.Uam006AhmjxuamHdrrlaccessDao;
import com.ahm.jx.uam.app007.dao.Uam007AhmjxuamMstsvcrolsDao;
import com.ahm.jx.uam.app007.vo.Uam007VoAhmjxuamMstsvcrols;

@Repository("uam007AhmjxuamMstsvcrolsDao")
public class Uam007AhmjxuamMstsvcrolsDaoImpl extends GenericHibernateDao<AhmjxuamMstsvcrols, String>
implements Uam007AhmjxuamMstsvcrolsDao{

	@Override
	public int getPagingCountAhmjxuamMstsvcrols(Map<String, Object> filters) {
		 int result = 0;
	        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstsvcrols.class, "ahmjxuamMstsvcrols");
	        if (filters != null) {
	            for (Map.Entry<String, Object> filter : filters.entrySet()) {
	                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
	                    String valueStr = filter.getValue().toString();
	                    criteria.add(
	                            buildResctrictionsAndForAllProperty(
	                                    new String[]{"vid_ahmjxuam_mstroles","vid_ahmjxuam_mstservices"},
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
	public List<Uam007VoAhmjxuamMstsvcrols> getPagingDataAhmjxuamMstsvcrols(int first, int pageSize, String sortField,
			String sortOrder, Map<String, Object> filters) {
		 List<Uam007VoAhmjxuamMstsvcrols> result = new ArrayList<Uam007VoAhmjxuamMstsvcrols>();
	        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstsvcrols.class, "ahmjxuamMstsvcrols");
	        if (filters != null) {
	            for (Map.Entry<String, Object> filter : filters.entrySet()) {
	                System.out.println("key " + filter.getKey());
	                if (filter.getKey().equalsIgnoreCase(CommonConstant.ANY)) {
	                    String valueStr = filter.getValue().toString();
	                    System.out.println("valueStr : " + valueStr);
	                    criteria.add(
	                            buildResctrictionsAndForAllProperty(
	                                    new String[]{"vid_ahmjxuam_mstroles","vid_ahmjxuam_mstservices"},
	                                    AhmStringUtil.splitBySpace(valueStr)));
	                }
	            }
	        } else {
	            System.out.println("filter null");
	        }

	        if (sortField != null) {
	            System.out.println("sortField : " + sortField);
	            if (sortOrder.equals(CommonConstant.ASC)) {
	                if (sortField.equals("vid_ahmjxuam_mstroles")) {
	                    criteria.addOrder(Order.asc("vid_ahmjxuam_mstroles").ignoreCase());
	                } else if (sortField.equals("vid_ahmjxuam_mstservices")) {
	                    criteria.addOrder(Order.asc("vid_ahmjxuam_mstservices").ignoreCase());
	                } 
	            } else if (sortField.equals("vid_ahmjxuam_mstroles")) {
	                criteria.addOrder(Order.desc("vid_ahmjxuam_mstroles").ignoreCase());
	            } else if (sortField.equals("vid_ahmjxuam_mstservices")) {
	                criteria.addOrder(Order.desc("vid_ahmjxuam_mstservices").ignoreCase());
	            } 
	        }
	        System.out.println("first : " + first);
	        System.out.println("pageSize : " + pageSize);
	        criteria.setFirstResult(first);
	        criteria.setMaxResults(pageSize);
	        List<AhmjxuamMstsvcrols> tempResult = criteria.list();
	        for (AhmjxuamMstsvcrols ahmjxuamMstsvcrols : tempResult) {
	        	Uam007VoAhmjxuamMstsvcrols uam007VoAhmjxuamMstsvcrols = new Uam007VoAhmjxuamMstsvcrols();
	        	uam007VoAhmjxuamMstsvcrols.setVid(uam007VoAhmjxuamMstsvcrols.getVid());
	        	uam007VoAhmjxuamMstsvcrols.setVidAhmjxuamMstroles(uam007VoAhmjxuamMstsvcrols.getVidAhmjxuamMstroles());
	        	uam007VoAhmjxuamMstsvcrols.setVidAhmjxuamMstservices(uam007VoAhmjxuamMstsvcrols.getVidAhmjxuamMstservices());
	            result.add(uam007VoAhmjxuamMstsvcrols);
	        }
	        return result;
	    }

//	@Override
//	public Uam007VoAhmjxuamMstsvcrols getSvcRoleById(String vid) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
