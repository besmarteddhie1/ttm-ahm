package com.ahm.jx.ttm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.Account;

@Repository
@RepositoryRestResource(path = "accounts")
public interface AccountDao extends JpaRepository<Account, Long> {
	
	Account findOneByEmail(@Param("email") String email);
	
	List<Account> findByRole(@Param("role") String role);
	
}