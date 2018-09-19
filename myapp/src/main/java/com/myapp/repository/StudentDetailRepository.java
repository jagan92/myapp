package com.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myapp.entity.StudentDetails;

public interface StudentDetailRepository extends JpaRepository<StudentDetails, Long>{

	@Query("select d from StudentDetails d where d.deleted=?1 and d.departmentId=?2 and d.courseId=?3 and d.coursePeriod=?4 and d.courseSection=?5")
	List<StudentDetails> getStudentsByFilter(char deleted, Long departmentId, Long courseId, Long coursePeriod, Long courseSection);

	
}
