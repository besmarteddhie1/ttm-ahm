package com.ahm.jx.ttm.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BsJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	
	Page<T> findBySearch(String fieldString, String filter, Pageable pageable);

}
