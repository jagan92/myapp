package com.myapp.dto;

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
	
	public StudentDetailVO() {
		
	}

	/********************** HashCode, and equals methods **********************/

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
	
	/********************** Getters and Setters **********************/


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
	
}
