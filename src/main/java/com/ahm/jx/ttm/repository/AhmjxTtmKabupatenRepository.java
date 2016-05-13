package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxttmKabupaten;

@RepositoryRestResource(collectionResourceRel = "kabupaten", path = "kabupaten")
public interface AhmjxTtmKabupatenRepository extends JpaRepository<AhmjxttmKabupaten, Integer> {
	
	List<AhmjxttmKabupaten> findByIdParentGeoBoundary(@Param("idParentGeoBoundary") String idparentgeobou);

}
