package com.ahm.jx.ttm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahm.jx.ttm.entities.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Long> {
	Account findOneByEmail(String email);
}