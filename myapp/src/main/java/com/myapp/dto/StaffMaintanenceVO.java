package com.myapp.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.myapp.dto.base.BaseVO;

public class StaffMaintanenceVO extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6562320343775195530L;

	private Long userId;
	private Long departmentId;
	private Long courseId;
	private Long coursePeriod;
	private Long courseSection;

	private String department;
	private String course;
	private String period;
	private String section;

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		StaffMaintanenceVO other = (StaffMaintanenceVO) obj;
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
