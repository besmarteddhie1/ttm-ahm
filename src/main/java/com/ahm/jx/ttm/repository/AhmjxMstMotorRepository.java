package com.ahm.jx.ttm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahm.jx.ttm.model.AhmjxMstMotor;

@RepositoryRestResource(collectionResourceRel = "motor", path = "motor")
public interface AhmjxMstMotorRepository extends JpaRepository<AhmjxMstMotor, Integer> {
	
	//@Query("select r AhmjxMstMotor r")
    //public List<AhmjxMstMotor> queryById();

}
