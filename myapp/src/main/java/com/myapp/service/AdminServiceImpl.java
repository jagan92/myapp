package com.myapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AppConfigurationEntry;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.constants.AppConstants;
import com.myapp.dto.AbsentDetailVO;
import com.myapp.dto.MasterDetailVO;
import com.myapp.dto.StudentDetailVO;
import com.myapp.dto.UserVO;
import com.myapp.entity.MasterDetails;
import com.myapp.entity.StudentDetails;
import com.myapp.entity.User;
import com.myapp.repository.MasterDetailRepository;
import com.myapp.repository.StudentDetailRepository;
import com.myapp.repository.UserRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MasterDetailRepository masterDetailRepository;
	
	@Autowired
	private StudentDetailRepository studentDetailRepository;
	

	@Override
	public boolean saveMasterDetail(MasterDetailVO masterDetailVO) {
		try {
			MasterDetails masterDetail = new MasterDetails();
			BeanUtils.copyProperties(masterDetail, masterDetailVO);
			masterDetailRepository.save(masterDetail);
			return true;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<MasterDetails> listMasterDetailsByType(String masterType) {
		List<MasterDetails> masterDetails = new ArrayList<>(); 
		try {
			masterDetails = masterDetailRepository.findByMasterType(masterType);
		} catch(Exception e) {
			System.out.println(e);
			masterDetails = new ArrayList<>();
		}
		return masterDetails;
	}

	@Override
	public List<MasterDetailVO> listMasterDetailVOByType(String masterType) {
		List<MasterDetailVO> masterDetailVOs = new ArrayList<>(); 
		try {
			List<MasterDetails> masterDetails = masterDetailRepository.findByMasterType(masterType);
			for(MasterDetails masterDet : masterDetails) {
				MasterDetailVO masterDetailVO = new MasterDetailVO(masterDet);
				masterDetailVOs.add(masterDetailVO);
			}
		} catch(Exception e) {
			System.out.println(e);
			masterDetailVOs = new ArrayList<>();
		}
		return masterDetailVOs;
	}
	
	@Transactional(readOnly = false)
	@Override
	public List<AbsentDetailVO> listUsersForAttendance(StudentDetailVO studentDetailVO){
		List<AbsentDetailVO> absentDetailVOs = new ArrayList<AbsentDetailVO>();
		try {
			List<StudentDetails> studentDetails = studentDetailRepository.getStudentsByFilter(AppConstants.NO, studentDetailVO.getDepartmentId(), studentDetailVO.getCourseId(), 
					studentDetailVO.getCoursePeriod(), studentDetailVO.getCourseSection());
			for(StudentDetails studentDetail : studentDetails) {
				AbsentDetailVO absentDetailVO = new AbsentDetailVO();
				User user = userRepository.findOne(studentDetail.getUserId());
				UserVO userVO = new UserVO(user, true);
				absentDetailVO.setUserVO(userVO);
				absentDetailVO.setUserId(studentDetail.getUserId());
				//absentDetailVO.setStatus(AppConstants.STATUS_ABSENT);
				absentDetailVOs.add(absentDetailVO);
			}
			
		} catch(Exception er) {
			System.out.println(er);
			absentDetailVOs = new ArrayList<>();
		}
		return absentDetailVOs;
		
	}
	
	
}
