package com.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.entity.MasterDetails;

public interface MasterDetailRepository extends JpaRepository<MasterDetails, Long>{

	public List<MasterDetails> findByMasterType(String masterType);
	
}
