package com.myapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myapp.entity.AbsentDetail;

public interface AbsentDetailRepository extends JpaRepository<AbsentDetail, Long> {

	@Query("select d from AbsentDetail d where d.deleted=?1 and d.absentDate=?2")
	List<AbsentDetail> getAbsentDetailsByDate(char deleted, Date curDate);
	
}
