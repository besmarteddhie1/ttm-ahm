package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxttmKecamatan;

@RepositoryRestResource(collectionResourceRel = "kecamatan", path = "kecamatan")
public interface AhmjxTtmKecamatanRepository extends JpaRepository<AhmjxttmKecamatan, Integer> {
	
	List<AhmjxttmKecamatan> findByIdParentGeoBoundary(@Param("idParentGeoBoundary") String idparentgeobou);

}
