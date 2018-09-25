package com.myapp.dto;

import java.util.Date;
import java.util.List;

public class AttendanceVO {

	private List<AbsentDetailVO> absentDetailVOs;
	private Date currentDate;
	
	public AttendanceVO() {
		//this.currentDate = new Date();
	}
	
	public AttendanceVO(List<AbsentDetailVO> absentDetailVOs) {
		this.absentDetailVOs = absentDetailVOs;
		//this.currentDate = new Date();
	}

	public List<AbsentDetailVO> getAbsentDetailVOs() {
		return absentDetailVOs;
	}

	public void setAbsentDetailVOs(List<AbsentDetailVO> absentDetailVOs) {
		this.absentDetailVOs = absentDetailVOs;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

}
