package com.ahm.jx.ttm.repository;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

public class JpaPartyCategoryTest {
	
    @Inject
    private AhmjxMstPartyCategoryRepository repository;

    @Test
    @Transactional
    public void createCategory() {
    }
}