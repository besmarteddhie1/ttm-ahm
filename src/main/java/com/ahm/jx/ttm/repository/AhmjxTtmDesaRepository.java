package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxttmDesa;

@RepositoryRestResource(collectionResourceRel = "desa", path = "desa")
public interface AhmjxTtmDesaRepository extends JpaRepository<AhmjxttmDesa, Integer> {
	
	List<AhmjxttmDesa> findByIdParentGeoBoundary(@Param("idParentGeoBoundary") String idparentgeobou);

}
