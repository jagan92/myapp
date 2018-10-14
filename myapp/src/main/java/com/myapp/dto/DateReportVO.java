package com.myapp.dto;

import java.util.Date;

public class DateReportVO {

	private Date absentDate;
	private Long absentCount;
	private Long presentCount;
	private Long totalCount;

	public DateReportVO() {
		
	}
	
	public Date getAbsentDate() {
		return absentDate;
	}

	public void setAbsentDate(Date absentDate) {
		this.absentDate = absentDate;
	}

	public Long getAbsentCount() {
		return absentCount;
	}

	public void setAbsentCount(Long absentCount) {
		this.absentCount = absentCount;
	}

	public Long getPresentCount() {
		return presentCount;
	}

	public void setPresentCount(Long presentCount) {
		this.presentCount = presentCount;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
