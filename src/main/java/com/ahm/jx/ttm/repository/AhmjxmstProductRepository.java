package com.ahm.jx.ttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxmstProduct;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface AhmjxmstProductRepository extends JpaRepository<AhmjxmstProduct, String> {
	
}
