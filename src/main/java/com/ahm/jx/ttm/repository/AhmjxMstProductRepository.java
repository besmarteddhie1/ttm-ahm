package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxMstProduct;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface AhmjxMstProductRepository extends JpaRepository<AhmjxMstProduct, String> {
	
}
