package com.myapp.service;

import java.util.List;

import com.myapp.dto.AbsentDetailVO;
import com.myapp.dto.AttendanceVO;
import com.myapp.dto.MasterDetailVO;
import com.myapp.dto.StudentDetailVO;
import com.myapp.entity.MasterDetails;

public interface AdminService {
	
	public boolean saveMasterDetail(MasterDetailVO masterDetailVO);

	public List<MasterDetails> listMasterDetailsByType(String masterType);
	
	public List<MasterDetailVO> listMasterDetailVOByType(String masterType);
	
	public List<AbsentDetailVO> listUsersForAttendance(StudentDetailVO studentDetailVO);
	
	public boolean saveAttendance(AttendanceVO attendanceVO);
	
}
