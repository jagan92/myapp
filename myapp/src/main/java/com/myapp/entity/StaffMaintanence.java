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
@Table(name = "staff_maintanences")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "staff_maintanence_id")) })
public class StaffMaintanence extends BaseSoftDeletable{

	
	private static final long serialVersionUID = -4810205226225181535L;

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
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		StaffMaintanence other = (StaffMaintanence) obj;
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
	

	
}
