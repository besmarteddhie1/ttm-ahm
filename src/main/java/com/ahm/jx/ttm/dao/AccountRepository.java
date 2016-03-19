package com.ahm.jx.ttm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Account findOneByEmail(String email);
	
}