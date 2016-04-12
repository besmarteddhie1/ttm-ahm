package com.ahm.jx.ttm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahm.jx.ttm.dao.UamMenuDao;
import com.ahm.jx.ttm.dao.impl.AbstractImplDao;
import com.ahm.jx.ttm.model.AhmjxUamMenu;


@RestController
@RequestMapping("/api/menu")
public class MenuController extends AbstractImplDao<AhmjxUamMenu, String> {	
	
	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	UamMenuDao dao;
	
	@Override
	protected JpaRepository<AhmjxUamMenu, String> getRepository() {
		return dao;
	}	
	
	public AhmjxUamMenu findOneByIdMenu(String idMenu) {
		return dao.findOneByIdMenu(idMenu);
	}

	public AhmjxUamMenu findOneByIdApplication(String idApplication) {
		return dao.findOneByIdApplication(idApplication);
	}
	
	@RequestMapping(value = "filter")
	@ResponseBody
	public AhmjxUamMenu getFilter(@RequestParam("id") String filter) {
		AhmjxUamMenu m = null;
		try {
			m = em.createQuery("select r from UamMenu r where r.idMenu = :idMenu ", AhmjxUamMenu.class)
				.setParameter("idMenu", filter)
				.getSingleResult();
		} catch (NoResultException ex) {			
			return null;
		}
		
		return m;
	}
	
	@RequestMapping(value = "show")
	@ResponseBody
	public List<AhmjxUamMenu> getByCriteria() {
		String[] fields = {"idMenu", "title", "url"};
		return getByCriteria(fields, "1", 1, 10);
	}	
	
	public List<AhmjxUamMenu> getBy(String[] fields, String[] values) {		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<AhmjxUamMenu> query = builder.createQuery(AhmjxUamMenu.class);
		Root<AhmjxUamMenu> root = query.from(AhmjxUamMenu.class);
		
		query.select(root);
		
		Predicate v1 = builder.or(
			    builder.like(root.get(fields[0]), values[0]),
			    builder.like(root.get(fields[1]), values[0])
			);
		
		Predicate v2 = builder.or(
			    builder.like(root.get(fields[0]), values[1]),
			    builder.like(root.get(fields[1]), values[1])
			);
		
		query.where(builder.and(v1, v2));		
					
		TypedQuery<AhmjxUamMenu> q = em.createQuery(query);
		return q.getResultList();
	}
	
	@Override
	public List<AhmjxUamMenu> getByCriteria(String[] fields, String filter, Integer pageNum, Integer rowNum) {
		String[] values = filter.split("\\s+");
						
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<AhmjxUamMenu> query = builder.createQuery(AhmjxUamMenu.class);
		Root<AhmjxUamMenu> root = query.from(AhmjxUamMenu.class);
		
		query.select(root);		
		List<Predicate> pv = new ArrayList<Predicate>();
		
		for (String s: values) {									
			List<Predicate> pf = new ArrayList<Predicate>();
			
			for (String f: fields) {
				Predicate vpf = builder.like(builder.lower(root.get(f)), "%" + s.toLowerCase() + "%");
				pf.add(vpf);
			}		
			
			Predicate[] apf = new Predicate[pf.size()];
			Predicate vpv = builder.or(pf.toArray(apf));
			pv.add(vpv);
		}
								
		Predicate[] apv = new Predicate[pv.size()];
		query.where(builder.and(pv.toArray(apv)));				
		
		System.out.println("Page Record Start : " + pageNum + "  >> " + ((pageNum - 1) * rowNum));		
		TypedQuery<AhmjxUamMenu> q = em.createQuery(query);
		
		q.setFirstResult((pageNum - 1) * rowNum);
		q.setMaxResults(rowNum);
		
		return q.getResultList();
		
	}
	
	@RequestMapping(value = "getAll")
	@ResponseBody
	public List<AhmjxUamMenu> getAll() {
		return dao.findAll();
	}	

	
}
