package com.myapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dto.StudentDetailVO;
import com.myapp.dto.UserVO;
import com.myapp.entity.StudentDetails;
import com.myapp.entity.User;
import com.myapp.repository.StudentDetailRepository;
import com.myapp.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentDetailRepository studentDetailRepository;
	
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
			User saveUser = userRepository.save(user);
			if(saveUser != null && saveUser.getId() != null) {
				StudentDetails studentDetails = new StudentDetails();
				StudentDetailVO stuDetVO = userVO.getStudentDetailVO();
				stuDetVO.setUserId(saveUser.getId());
				BeanUtils.copyProperties(studentDetails, stuDetVO);
				studentDetailRepository.save(studentDetails);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Override
	public List<UserVO> allUsers(){
		List<UserVO> userVOs = new ArrayList<>();
		try {
			List<User> users = userRepository.findAll();
			for(User user : users) {
				UserVO userVO = new UserVO(user, true);
				userVOs.add(userVO);
			}
		} catch(Exception e) {
			System.out.println(e);
			userVOs = new ArrayList<>();
		}
		return userVOs;
	}

}
