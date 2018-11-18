package com.myapp.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.myapp.dto.base.BaseVO;

public class StudentDetailVO extends BaseVO {

	private static final long serialVersionUID = -987710574755185851L;

	private Long userId;
	private Long departmentId;
	private Long courseId;
	private Long coursePeriod;
	private Long courseSection;
	private Date fromDate;
	private Date toDate;

	private String department;
	private String course;
	private String period;
	private String section;

	public StudentDetailVO() {

	}
	
	public StudentDetailVO(String department, String course, String period, String section) {
		this.department = department;
		this.course = course;
		this.period = period;
		this.section = section;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		MasterDetailVO other = (MasterDetailVO) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getCoursePeriod() {
		return coursePeriod;
	}

	public void setCoursePeriod(Long coursePeriod) {
		this.coursePeriod = coursePeriod;
	}

	public Long getCourseSection() {
		return courseSection;
	}

	public void setCourseSection(Long courseSection) {
		this.courseSection = courseSection;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
