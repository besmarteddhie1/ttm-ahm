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
import com.ahm.jx.ttm.entities.UamMenu;


@RestController
@RequestMapping("/api/menu")
public class MenuController extends AbstractImplDao<UamMenu, String> {	
	
	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	UamMenuDao dao;
	
	@Override
	protected JpaRepository<UamMenu, String> getRepository() {
		return dao;
	}	
	
	public UamMenu findOneByIdMenu(String idMenu) {
		return dao.findOneByIdMenu(idMenu);
	}

	public UamMenu findOneByIdApplication(String idApplication) {
		return dao.findOneByIdApplication(idApplication);
	}
	
	@RequestMapping(value = "filter")
	@ResponseBody
	public UamMenu getFilter(@RequestParam("id") String filter) {
		UamMenu m = null;
		try {
			m = em.createQuery("select r from UamMenu r where r.idMenu = :idMenu ", UamMenu.class)
				.setParameter("idMenu", filter)
				.getSingleResult();
		} catch (NoResultException ex) {			
			return null;
		}
		
		return m;
	}
	
	@RequestMapping(value = "show")
	@ResponseBody
	public List<UamMenu> getByCriteria() {
		String[] values = {"010", "License", "uam"};
		String[] fields = {"idMenu", "title", "url"};
		return getByCriteria(fields, values);
	}	

	
	public List<UamMenu> getBy(String[] fields, String[] values) {		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UamMenu> query = builder.createQuery(UamMenu.class);
		Root<UamMenu> root = query.from(UamMenu.class);
		
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
					
		TypedQuery<UamMenu> q = em.createQuery(query);
		return q.getResultList();
	}
	
	@Override
	public List<UamMenu> getByCriteria(String[] fields, String[] values) {		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UamMenu> query = builder.createQuery(UamMenu.class);
		Root<UamMenu> root = query.from(UamMenu.class);
		
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
		
		TypedQuery<UamMenu> q = em.createQuery(query);
		return q.getResultList();
	}

}
