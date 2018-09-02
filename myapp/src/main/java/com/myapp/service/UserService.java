package com.myapp.service;

import com.myapp.dto.UserVO;
import com.myapp.entity.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(UserVO userVO);
}
