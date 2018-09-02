package com.myapp.service;

import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dto.UserVO;
import com.myapp.entity.User;
import com.myapp.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByLoginId(email);
	}

	@Override
	public void saveUser(UserVO userVO) {
		try {
			User user = new User();
			BeanUtils.copyProperties(user, userVO);
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setActive(1);
			userRepository.save(user);	
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
