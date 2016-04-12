package com.ahm.jx.ttm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractImplDao<T, ID extends Serializable> implements JpaRepository<T, ID> {	
	
	protected abstract JpaRepository<T, ID> getRepository();

	@Override
	public Page<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

	@Override
	public <S extends T> S save(S entity) {
		return getRepository().save(entity);
	}

	@Override
	public T findOne(ID id) {
		return getRepository().findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		return getRepository().exists(id);
	}

	@Override
	public long count() {
		return getRepository().count();
	}

	@Override
	public void delete(ID id) {
		getRepository().delete(id);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		getRepository().delete(entities);		
	}

	@Override
	public void deleteAll() {
		getRepository().deleteAll();		
	}

	@Override
	public List<T> findAll() {		
		return getRepository().findAll();
	}

	@Override
	public List<T> findAll(Sort sort) {
		return getRepository().findAll(sort);
	}

	@Override
	public List<T> findAll(Iterable<ID> ids) {
		return findAll(ids);
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		return getRepository().save(entities);
	}

	@Override
	public void flush() {
		getRepository().flush();		
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		return getRepository().saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
		deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		getRepository().deleteAllInBatch();
	}

	@Override
	public T getOne(ID id) {
		return getRepository().getOne(id);
	}
	
	public abstract List<T> getByCriteria(String[] Fields, String filter, Integer pageNum, Integer rowNum);
	
}
