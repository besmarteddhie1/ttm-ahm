package com.ahm.jx.ttm.repository.implementation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.ahm.jx.ttm.repository.BsJpaRepository;

public class BsJpaRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BsJpaRepository<T, ID> {
	
	private EntityManager em;
	
	public BsJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}

	@Override
	public Page<T> findBySearch(String fieldString, String filter, Integer  pageNum, Integer  rowNum) {
		String[] values = filter.split("\\s+");
		String[] fields = fieldString.split("\\s+");
						
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getDomainClass());
		Root<T> root = query.from(getDomainClass());
		
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
		
		TypedQuery<T> q = em.createQuery(query);
		
		q.setFirstResult((pageNum - 1) * rowNum);
		q.setMaxResults(rowNum);
		
		return new PageImpl<T>(q.getResultList());
		
	}

}
