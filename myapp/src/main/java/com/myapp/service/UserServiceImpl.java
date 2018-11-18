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

import com.myapp.constants.AppConstants;
import com.myapp.dto.StaffDetailVO;
import com.myapp.dto.StudentDetailVO;
import com.myapp.dto.UserVO;
import com.myapp.entity.StaffDetail;
import com.myapp.entity.StudentDetails;
import com.myapp.entity.User;
import com.myapp.repository.StaffDetailRepository;
import com.myapp.repository.StaffMaintanenceRepository;
import com.myapp.repository.StudentDetailRepository;
import com.myapp.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentDetailRepository studentDetailRepository;
	
	@Autowired
	private StaffDetailRepository staffDetailRepository;
	
	@Autowired
	private StaffMaintanenceRepository staffMaintanenceRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByLoginId(email);
	}

	@Override
	public String saveUser(UserVO userVO) {
		String returnString = "true";
		try {
			User user = new User();
			BeanUtils.copyProperties(user, userVO);
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setActive(1);
			User saveUser = userRepository.save(user);
			if(saveUser != null && saveUser.getId() != null && saveUser.getRole().equalsIgnoreCase(AppConstants.ROLE_STUDENT)) {
				StudentDetails studentDetails = new StudentDetails();
				StudentDetailVO stuDetVO = userVO.getStudentDetailVO();
				stuDetVO.setUserId(saveUser.getId());
				BeanUtils.copyProperties(studentDetails, stuDetVO);
				studentDetailRepository.save(studentDetails);
			} else if(saveUser != null && saveUser.getId() != null && saveUser.getRole().equalsIgnoreCase(AppConstants.ROLE_STAFF)) {
				StaffDetail staffDetail = new StaffDetail();
				StaffDetailVO staffDetailVO = userVO.getStaffDetailVO();
				staffDetailVO.setUserId(saveUser.getId());
				BeanUtils.copyProperties(staffDetail, staffDetailVO);
				staffDetailRepository.save(staffDetail);
			}
		}catch(Exception e) {
			returnString = "false";
			System.out.println(e);
		}
		return returnString;
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
