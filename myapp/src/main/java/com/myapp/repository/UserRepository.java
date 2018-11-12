package com.myapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByLoginId(String loginId);
	
	@Query("select d from User d where d.deleted=?1 and d.id in (?2)")
	List<User> getUserDetails(char deleted, Long[] arrUserId);

}
