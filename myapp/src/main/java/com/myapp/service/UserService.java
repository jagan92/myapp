package com.myapp.service;

import java.util.List;

import com.myapp.dto.UserVO;
import com.myapp.entity.User;

public interface UserService {
	public User findUserByEmail(String email);
	public String saveUser(UserVO userVO);
	public List<UserVO> allUsers();
}
