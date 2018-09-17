package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.entity.AbsentDetail;

public interface AbsentDetailRepository extends JpaRepository<AbsentDetail, Long> {

}
