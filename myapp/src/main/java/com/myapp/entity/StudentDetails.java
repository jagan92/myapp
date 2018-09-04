package com.myapp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.myapp.entity.base.BaseSoftDeletable;

@Entity
@Table(name = "student_details")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "student_detail_id")) })
public class StudentDetails extends BaseSoftDeletable {

	private static final long serialVersionUID = -5485347851769144137L;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "department_id")
	private Long departmentId;
	
	@Column(name = "course_id")
	private Long courseId;
	
	@Column(name = "course_period")
	private Long coursePeriod;
	
	@Column(name = "course_section")
	private Long courseSection;
	
	/********************** hashcode, and equals methods **********************/

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		StudentDetails other = (StudentDetails) obj;
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
