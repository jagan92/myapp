package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.entity.StudentDetails;

public interface StudentDetailRepository extends JpaRepository<StudentDetails, Long>{

}
